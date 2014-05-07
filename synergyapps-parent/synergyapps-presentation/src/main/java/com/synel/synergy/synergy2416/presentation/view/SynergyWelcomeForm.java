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
		
	public boolean isM_bIsPiggyBack() {
		return m_bIsPiggyBack;
	}

	public void setM_bIsPiggyBack(boolean bIsPiggyBack) {
		this.m_bIsPiggyBack = bIsPiggyBack;
	}

	/**
	 * Initialize the contents of the frame.
	 * @param mw 
	 */
	public SynergyWelcomeForm(MainWindow mw) {
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
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				
				if( KeyEvent.VK_F6 == e.getKeyCode()) {
					runIdThreadAgain();
				}
				else {
					m_mw.get_Sed().handlekeyPressed(e);
				}
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
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
            return FPU.identifyEmployee();
        	
        	//return "Succeed!";
        }

        @Override
        protected void done() {
        	
        	SynergyEventDispatcher.SYNERGY_STATUS st = SynergyWelcomeForm.this.m_mw.get_Sed().synergyStatus();
        	//System.out.print("status is "+st);
			if (st == SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_MENU || st == SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_FINGERPRINT_CONTROL ||st == SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_READY)
			{
				try { 
            	String strResult = get();
            	//System.out.println(strResult);
            	if (strResult.compareTo("Succeed!") == 0) {
            		if (m_bIsPiggyBack){
                  		m_lblText.setText("<html><font color=black><div style=\"text-align: center;\">Access Granted!</font></html>");
                  		m_lblText.setIcon(m_iconDoorOpen);
                  	}else{
                  		m_lblText.setText("<html><font color=black><div style=\"text-align: center;\">Punch Accepted!</font></html");		
                  	}
                  	//m_lblWelcomeLabel.repaint();
                  	FPU.Light.RED.off();
                  	FPU.Light.GREEN.on();
                  	MainWindow.get_Sap().playAcceptedSound();
                  	
                  } else {
                  		if (m_bIsPiggyBack){
                  			m_lblText.setIcon(m_iconDoorClosed);
                  			m_lblText.setText("<html><font color=black><div style=\"text-align: center;\">"+"Access Denied"+"</font></html>");
                  		}else{
                  			
                  			//SynergyWelcomeForm.this.m_mw.get_Sec().getM_webCamDemoForm().takeSnapshot(m_lblWelcomeLabel);
                  			m_lblText.setText("<html><font color=black><div style=\"text-align: center;\">"+"Punch Rejected"+"</font></html>");
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

}
