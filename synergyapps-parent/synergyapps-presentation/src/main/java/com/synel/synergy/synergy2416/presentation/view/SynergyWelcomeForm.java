package com.synel.synergy.synergy2416.presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.JPanel;

import com.synel.synergy.synergy2416.presentation.controller.FPU;
import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher;
import com.synel.synergy.synergy2416.presentation.controller.SynergyStatusListener;
import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher.SYNERGY_STATUS;

public class SynergyWelcomeForm extends JPanel {
	private static final long serialVersionUID = 319089484632562510L;
	private static final String ResPath = "/multimedia/";
	private JLabel m_lblWelcomeLabel;
	private JLabel m_lblText;
	private JLayeredPane m_pMsg;
	private MainWindow m_mw;
	//private AtomicInteger m_nIdThread;
	private boolean m_bRunIdThread;
	//private IdentifyEmployeeWorker m_idEmpWorker;
	private static IdentifyEmployeeWorker m_idEmpWorker;
	private static Timer m_idThreadTimer;
	private boolean m_bIsPiggyBack; //PiggyBack on idControl form
	private static AtomicInteger m_nIdThread;
	private ImageIcon m_iconDoorOpen;
	private ImageIcon m_iconDoorClosed;
	//private Image m_imgSnapShot;
	//add identify succeed boolean and associated badgenumber as private field
	//add a timer to accept punch from the employee
	private PunchWindow m_pw;
	//private static Timer m_punchwindowtimer;
	private List<SynergyStatusListener> listeners = new ArrayList<SynergyStatusListener>();


	public void addListener(SynergyStatusListener sl) {
		listeners.add(sl);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param mw 
	 */
	public SynergyWelcomeForm(MainWindow mw) {
		m_pw = new PunchWindow();
		m_nIdThread = new AtomicInteger(0);
		m_bRunIdThread = false;
		m_bIsPiggyBack = false;
		m_iconDoorOpen = createImageIcon(ResPath+"gif_door_in.gif",
				"a door open gif file");
		m_iconDoorClosed = createImageIcon(ResPath+"locked_gif_058.gif",
				"a door close gif file");
		this.m_mw = mw;
		this.setLayout(new BorderLayout());
		addComponentsToPane();
		this.setOpaque(false);
		updateLabel();

		m_idThreadTimer = new Timer(8000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runIdThreadAgain();
			}
		});

		this.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {

				if (KeyEvent.VK_F5 == e.getKeyCode()){
					//IN key sequence starts with F5 (keyCode 116)
						m_pw.setM_punchType(1);
						m_pw.setM_punchkeypressed(true);
						if (! m_pw.isM_allowedToPunch()){
						m_lblText.setText("<html><font color=black><div style=\"text-align: center;\"><b>Please place your finger</b></font></html>");
						}
				}else if (KeyEvent.VK_F6 == e.getKeyCode()){
						m_pw.setM_punchType(2);
						m_pw.setM_punchkeypressed(true);
						if (! m_pw.isM_allowedToPunch()){
						m_lblText.setText("<html><font color=black><div style=\"text-align: center;\"><b>Please place your finger</b></font></html>");
						}
				} else {
					m_mw.get_Sed().handlekeyPressed(e);
				}

			}

			public void keyReleased(KeyEvent e) {
				System.out.println("Key released");
			}

		});

		this.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				m_bRunIdThread = true;
				System.out.println(SynergyWelcomeForm.this.toString()+"Focus GAINED:"+e);
				if (m_idThreadTimer != null && m_idThreadTimer.isRunning()){
					m_idThreadTimer.stop();
				}
				runIdThreadAgain();
				//UpdateClock.showTimeZoneInfo();
			}
			public void focusLost(FocusEvent e){
				System.out.println(SynergyWelcomeForm.this.toString()+"Focus LOST:"+e);
				m_bRunIdThread = false;
				//	            
				//	              if (m_idEmpWorker != null && ! m_idEmpWorker.isDone()) {
				//	            	  m_idEmpWorker.cancel(true);
				//	              }
				if (m_idThreadTimer != null && m_idThreadTimer.isRunning()){
					m_idThreadTimer.stop();
				}
			}
		});

	}

	public void updateLabel(){
		//m_pMsg.moveToFront(m_lblText);
		m_lblWelcomeLabel.setIcon(null);
		if (m_bIsPiggyBack){
			m_mw.get_Sec().getLblVideoImage().setVisible(false);
			m_mw.get_Sec().getLblCameraImage().setVisible(false);
			m_mw.get_Sec().getLblFpuEnrollImage().setVisible(false);
			m_mw.get_Sec().getLblFpuControlImage().setVisible(true);
			m_lblText.setText("<html><font color=black>Please Place Finger</font></html>");
			m_lblText.setIcon(null);
		} else {
			for (Component c : m_mw.get_Sec().getM_pMenuBar().getComponents()){
				c.setVisible(true);
			}
			m_lblText.setIcon(null);
			m_lblText.setText("<html><font color=black><div style=\"text-align: center;\"><b>Welcome!</b></font></html>");
		}

		FPU.Light.GREEN.off();
		FPU.Light.RED.off();
	}

	public boolean isM_bIsPiggyBack() {
		return m_bIsPiggyBack;
	}

	public void setM_bIsPiggyBack(boolean bIsPiggyBack) {
		this.m_bIsPiggyBack = bIsPiggyBack;
	}
	
	public void onSentPunchSuccess(String info){
		clearPunchWindow();
		displayTextInfo(info);
		FPU.Light.RED.off();
		FPU.Light.GREEN.on();
		MainWindow.get_Sap().playAcceptedSound();
	}
	
	private void clearPunchWindow()
	{
		m_pw.setM_allowedToPunch(false);
		m_pw.setM_punchkeypressed(false);
	}
	
	private void displayTextInfo(String info){
		m_lblText.setText("<html><font color=black><div style=\"text-align: center;\"><b>"+info+"</b></font></html>");
	}

	private void addComponentsToPane() {
		createWelcomeLabel();
		createTxtLabel();
		m_pMsg = new JLayeredPane();
		m_pMsg.setSize(320, 200);
		m_pMsg.add(m_lblWelcomeLabel);
		m_pMsg.add(m_lblText);
		m_pMsg.moveToFront(m_lblText);
		m_pMsg.setOpaque(false);
		add(m_pMsg,BorderLayout.CENTER);
	}

	private void createWelcomeLabel(){
		m_lblWelcomeLabel = new JLabel();
		m_lblWelcomeLabel.setSize(new Dimension(320, 200));
		m_lblWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		m_lblWelcomeLabel.setVerticalAlignment(JLabel.CENTER);
		m_lblWelcomeLabel.setOpaque(false);
	}

	private void createTxtLabel(){
		m_lblText = new JLabel("Welcome");
		m_lblText.setSize(new Dimension(320, 150));
		m_lblText.setFont(new Font("Times", Font.BOLD, 25));
		m_lblText.setForeground(Color.BLACK);
		m_lblText.setHorizontalAlignment(JLabel.CENTER);
		m_lblText.setOpaque(false);
	}

	class IdentifyEmployeeWorker extends SwingWorker<String, Void> {
		@Override
		public String doInBackground() {
			m_nIdThread.getAndIncrement();
			return FPU.identifyEmployee(); // one to many return badgenum
		}

		@Override
		protected void done() {

			SynergyEventDispatcher.SYNERGY_STATUS st = SynergyWelcomeForm.this.m_mw.get_Sed().synergyStatus();
			if (st == SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_MENU || st == SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_FINGERPRINT_CONTROL ||st == SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_READY)
			{
				String strResult = "Punch Rejected";
				try { 
					strResult = get();
					System.out.println(strResult);
					Integer badgenumber = -1;
					try {
						badgenumber = Integer.parseInt(strResult);
					} catch (Exception ex) {
						badgenumber = -1;
					}
					if (badgenumber >= 0) {
						if (m_bIsPiggyBack){
							displayTextInfo("Access Granted!");
							m_lblText.setIcon(m_iconDoorOpen);
						}else{
							//Set allowed to punch to true
							//store the employee fingerprint validation status and its associated badgenumber
							m_pw.setM_allowedToPunch(true);
							m_pw.setM_badgenum(String.valueOf(badgenumber));
							m_pw.setM_timestamp(System.currentTimeMillis());
							if (! m_pw.isM_punchkeypressed()){
								String echoStr = "Hello Employee: "+badgenumber+"<br>"+"Please press IN/OUT";
								displayTextInfo(echoStr);
							} else {
								emit(m_pw);
								clearPunchWindow();
							}
							//invoke the punchwindow timer to wait for IN/OUT key event.
						}
						//m_lblWelcomeLabel.repaint();

					} else {
						if (m_bIsPiggyBack){
							m_lblText.setIcon(m_iconDoorClosed);
							m_lblText.setText("<html><font color=black><div style=\"text-align: center;\">"+"Access Denied"+"</font></html>");
						}else{

							//SynergyWelcomeForm.this.m_mw.get_Sec().getM_webCamDemoForm().takeSnapshot(m_lblWelcomeLabel);
							m_lblText.setText("<html><font color=black><div style=\"text-align: center;\">"+strResult+"</font></html>");
						}
						//m_lblWelcomeLabel.repaint();
						FPU.Light.GREEN.off();
						FPU.Light.RED.on();
						MainWindow.get_Sap().playRejectedSound();
					}

				} catch (InterruptedException e) {

					// This is thrown if the thread's interrupted.
				} catch (ExecutionException e) {

					// This is thrown if we throw an exception
					// from doInBackground.
				} catch (CancellationException e) {
					// Do your task after cancellation
					m_nIdThread.getAndDecrement();
					return;

				}
			}

			m_nIdThread.getAndDecrement();
			m_idThreadTimer.start(); 
		}
	}

	protected void runIdThreadAgain() {
		System.out.println("m_nThread is "+m_nIdThread.get());
		if (m_idEmpWorker != null){
			System.out.println("thread is done? "+m_idEmpWorker.isDone());
			System.out.println("thread is cancelled? "+m_idEmpWorker.isCancelled());
		}
		if (m_idEmpWorker == null || (m_bRunIdThread && m_idEmpWorker.isDone())) {
			updateLabel();
			IdentifyEmp();
		}
	}

	private void IdentifyEmp(){
		m_idEmpWorker = new IdentifyEmployeeWorker();
		//m_idEmpWorker = new FPIdWorker(m_lblWelcomeLabel,m_idThreadTimer);
		m_idEmpWorker.execute();
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}


	private void emit(PunchWindow pw){
		for (SynergyStatusListener sl : listeners) {
			sl.onPunchEvent(pw.getM_badgenum(), pw.getM_punchType(), pw.getM_timestamp());
		}	
	}
}
