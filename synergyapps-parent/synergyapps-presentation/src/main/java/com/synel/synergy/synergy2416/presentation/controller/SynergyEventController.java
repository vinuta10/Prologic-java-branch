package com.synel.synergy.synergy2416.presentation.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.synel.synergy.synergy2416.model.FingerPrintManager;
import com.synel.synergy.synergy2416.model.FingerPrintManagerImpl;
import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher.SYNERGY_STATUS;
import com.synel.synergy.synergy2416.presentation.view.MainWindow;
import com.synel.synergy.synergy2416.presentation.view.SynergyFingerPrintEnrollmentForm;
import com.synel.synergy.synergy2416.presentation.view.SynergyWelcomeForm;


public class SynergyEventController implements SynergyStatusListener {
	
	private FingerPrintManager mFpMgr = FingerPrintManagerImpl.getInstance();
	
	private static final String ResPath = "/multimedia/";
	
	private MainWindow m_frame;
	private SYNERGY_STATUS m_curStatus = SynergyEventDispatcher.SYNERGY_STATUS.SYNERGYSTATUS_UNINITIALIZED;
	
	private CardLayout m_cards;
	private JPanel m_cardPanel;
	private SynergyWelcomeForm m_welcomeForm;
	private SynergyFingerPrintEnrollmentForm m_fingerPrintEnrollForm;
	//private FingerPrintControlForm m_fingerPrintControlForm;
	
	private JLabel m_lblBackground;
	private JLabel m_lblFormName;
	private JPanel m_pMenuBar;
	//private JPanel m_pStatusBar;
	private JPanel m_pFooter;
	private JPanel m_pHeader;
	private ImageIcon m_iconBackground;

	private JLabel lblVideoImage;

	private JLabel lblCameraImage;

	private JLabel lblFpuEnrollImage;

	private JLabel lblFpuControlImage;
	private static final int IconSize=35;
	private static final int LogoSize=30;
	
	public enum ICONS {
		
	}
	
	public SynergyEventController(MainWindow mw) {
		this.m_frame = mw;
	}
	
	public JLabel getM_lblInstruction() {
		return m_lblFormName;
	}
	
	public JPanel getM_pMenuBar() {
		return m_pMenuBar;
	}

	public JLabel getLblVideoImage() {
		return lblVideoImage;
	}

	public JLabel getLblCameraImage() {
		return lblCameraImage;
	}

	public JLabel getLblFpuEnrollImage() {
		return lblFpuEnrollImage;
	}

	public JLabel getLblFpuControlImage() {
		return lblFpuControlImage;
	}

	public void initialize()
	{
		// Can do some hardware initialization while displaying the boot screen
		System.out.println("initilizing SYNERGY event controller ...");
		//Adding signal-slot:
		m_frame.get_Sed().addListener(this); //This is similar to the "Connect(SIGNAL ... SLOT) idiom in QT
		//Initialize HW component, such as the finger print reader
		initializeGUI();
	    returnToMain();
	}
	
	private void initializeGUI() {
			System.out.println("Initializing gui...");
			m_frame.setBounds(0, 0, 320, 240);
			m_frame.setSize(320,240);
			m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			createBackgroundLabel();
			createHeader();
			createFooter();
			m_frame.setContentPane(m_lblBackground);
			m_frame.getContentPane().setLayout(new BorderLayout());
			
			m_cards = new CardLayout();
			m_cardPanel = new JPanel();
			m_cardPanel.setLayout(m_cards);
			m_cardPanel.setSize(320, 200);
			m_cardPanel.setOpaque(false);
			
			m_welcomeForm = new SynergyWelcomeForm(m_frame);
			m_fingerPrintEnrollForm = new SynergyFingerPrintEnrollmentForm(m_frame);
			//m_fingerPrintControlForm = new FingerPrintControlForm(m_frame);
			
			m_cardPanel.add(m_welcomeForm,"welcome");
			m_cardPanel.add(m_fingerPrintEnrollForm,"fpEnroll");
			//m_cardPanel.add(m_fingerPrintControlForm,"fpControl");
			
			m_frame.getContentPane().add(m_pHeader,BorderLayout.NORTH);
			m_frame.getContentPane().add(m_cardPanel,BorderLayout.CENTER);
			m_frame.getContentPane().add(m_pFooter,BorderLayout.SOUTH);
			
			m_frame.pack();
			//m_frame.toFront();
			m_frame.setVisible(true);
			
			System.out.println("Done initializing gui...");
			MainWindow.get_Sap().playSuccessSound();
	}
	
	private void createFooter() {
	        m_pMenuBar = new JPanel();
			m_pMenuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
			m_pMenuBar.setLayout(new GridLayout(1, 4));
		
			ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource(ResPath+"video-75.png")).getImage().getScaledInstance(IconSize, IconSize, java.awt.Image.SCALE_SMOOTH)); 
			lblVideoImage = new JLabel();
			GridBagConstraints gbc_lblVideoimage = new GridBagConstraints();
			gbc_lblVideoimage.anchor = GridBagConstraints.WEST;
			lblVideoImage.setIcon(icon);
			lblVideoImage.setBorder(new EmptyBorder(0,10,0,0));
			m_pMenuBar.add(lblVideoImage, gbc_lblVideoimage);
			
			icon = new ImageIcon(new ImageIcon(getClass().getResource(ResPath+"camera-75.png")).getImage().getScaledInstance(IconSize, IconSize, java.awt.Image.SCALE_SMOOTH)); 
			lblCameraImage = new JLabel();
			GridBagConstraints gbc_lblCameraimage = new GridBagConstraints();
			lblCameraImage.setIcon(icon);
			lblCameraImage.setBorder(new EmptyBorder(0,10,0,0));
			m_pMenuBar.add(lblCameraImage, gbc_lblCameraimage);
			
			icon = new ImageIcon(new ImageIcon(getClass().getResource(ResPath+"finger-icon-75.png")).getImage().getScaledInstance(IconSize, IconSize, java.awt.Image.SCALE_SMOOTH)); 
			lblFpuEnrollImage = new JLabel();
			GridBagConstraints gbc_lblFpuimage = new GridBagConstraints();
			lblFpuEnrollImage.setIcon(icon);
			lblFpuEnrollImage.setBorder(new EmptyBorder(0,10,0,0));
			m_pMenuBar.add(lblFpuEnrollImage, gbc_lblFpuimage);
			
			icon = new ImageIcon(new ImageIcon(getClass().getResource(ResPath+"lock.png")).getImage().getScaledInstance(IconSize, IconSize, java.awt.Image.SCALE_SMOOTH)); 
			lblFpuControlImage = new JLabel();
			GridBagConstraints gbc_lblFpuimage_1 = new GridBagConstraints();
			gbc_lblFpuimage_1.anchor = GridBagConstraints.EAST;
			lblFpuControlImage.setIcon(icon);
			lblFpuControlImage.setBorder(new EmptyBorder(0,10,0,0));
			m_pMenuBar.add(lblFpuControlImage, gbc_lblFpuimage_1);	
			
			m_pFooter = new JPanel();
			m_pFooter.setSize(320, 30);
			m_pFooter.setBorder(BorderFactory.createEmptyBorder(8,20,8,0));
			m_pFooter.setLayout(new BoxLayout(m_pFooter, BoxLayout.X_AXIS));
			m_pFooter.add(m_pMenuBar);
	}
	
	private void createHeader() {
		
			m_lblFormName = new JLabel();
			//m_lblInstruction.setIcon(new ImageIcon(new ImageIcon(MainWindow.class.getResource(ResPath+"synel.png")).getImage().getScaledInstance(LogoSize, LogoSize, java.awt.Image.SCALE_SMOOTH)));
			m_lblFormName.setIcon(new ImageIcon(new ImageIcon(MainWindow.class.getResource(ResPath+"SynelLogoSmall.png")).getImage().getScaledInstance(3*LogoSize, LogoSize, java.awt.Image.SCALE_SMOOTH)));
			m_lblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			m_lblFormName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
			
			//m_pStatusBar = new JPanel();
			JLabel lblTimeLabel = new JLabel();
			lblTimeLabel.setFont(new Font("Times", Font.PLAIN, 16));
			lblTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			lblTimeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
			lblTimeLabel.setOpaque(false);
			SynergyClockUpdate.initialize(lblTimeLabel);
			//m_pStatusBar.add(lblTimeLabel);
			    
			m_pHeader = new JPanel();
			m_pHeader.setSize(320, 30);
			m_pHeader.setLayout(new BoxLayout(m_pHeader, BoxLayout.X_AXIS));
	        m_pHeader.add(m_lblFormName);
	        m_pHeader.add(Box.createHorizontalStrut(5));
	        m_pHeader.add(lblTimeLabel);
		}

	private void createBackgroundLabel(){
		m_iconBackground = new ImageIcon(MainWindow.class.getResource(ResPath+"Background.png"));
		m_lblBackground = new JLabel(m_iconBackground);
		m_lblBackground.setOpaque(true);
	}
		
	public void loadInitializingForm()
	{
	    System.out.println("Loading InitializingForm");
	}
	
	public void loadWelcomeForm()
	{
	    System.out.println("Loading WelcomeForm");
	    m_welcomeForm.setM_bIsPiggyBack(false);
	    m_cards.show(m_cardPanel, "welcome");
	    m_welcomeForm.updateLabel();
	    m_welcomeForm.requestFocusInWindow();
	}
	
	public void loadPlayVideoForm()
	{
	    System.out.println("Loading Playing Video Form");
	    m_cards.show(m_cardPanel, "videoDemo");
	    //m_videoDemoForm.updateLabel();
	    //m_videoDemoForm.requestFocusInWindow();
	}
	
	public void loadShowWebCamForm()
	{
	    System.out.println("Loading WebCamForm");
	    m_cards.show(m_cardPanel, "webcamDemo");
	    //m_webCamDemoForm.updateLabel();
	    //m_webCamDemoForm.requestFocusInWindow();
	}
	
	public void loadFingerPrintEnrollForm()
	{
	    System.out.println("Loading FingerPrint Enrollment Form");
	    m_cards.show(m_cardPanel, "fpEnroll");
	    m_fingerPrintEnrollForm.updateLabel();
	    m_fingerPrintEnrollForm.setFocusable(true);
	    m_fingerPrintEnrollForm.requestFocusInWindow();
	    m_fingerPrintEnrollForm.goDemo();
	    
	}
	public void loadFingerPrintControlForm()
	{
	    System.out.println("Loading FingerPrint Control Form");
	    m_welcomeForm.setM_bIsPiggyBack(true);
	    m_cards.show(m_cardPanel, "welcome");
	    m_welcomeForm.updateLabel();
	    m_welcomeForm.requestFocusInWindow();
	}
	public void loadSysInforForm()
	{
	    System.out.println("Loading SystemInformationForm");
	    //new FingerPrintDemoForm(m_frame);
	}
	
	/**
	 * This is the big state machine that determines the current GUI that should show on the screen.
	 * Driven by events.
	 * 
	 *
	 */
	
	public void returnToMain() {
		
		switch (m_curStatus) {
		
		case SYNERGYSTATUS_FAULT:
			
			break;
		case SYNERGYSTATUS_UNINITIALIZED:
			loadInitializingForm();
			break;	
		case SYNERGYSTATUS_VIDEO:
			
			loadPlayVideoForm();
			break;
		case SYNERGYSTATUS_WEBCAM:
			
			loadShowWebCamForm();
			break;
		case SYNERGYSTATUS_FINGERPRINT_ENROLL:
			
			loadFingerPrintEnrollForm();
			break;
		case SYNERGYSTATUS_FINGERPRINT_CONTROL:
			
			loadFingerPrintControlForm();
			break;
		case SYNERGYSTATUS_SYSINFO:
			
			loadSysInforForm();
			break;
			
		case SYNERGYSTATUS_READY:
		case SYNERGYSTATUS_MENU:
		default:
			loadWelcomeForm();		
		}
	}
	
	/*
	 * pragma here is all the "SLOT" function go
	 * (non-Javadoc)
	 * @see com.synel.synergy.synergy2416.presentation.controller.SynergyStatusListener#synergyStatusChanged(com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher.SYNERGY_STATUS)
	 */
	
	// This correspond to the "SLOT" part of the QT's signal slot idiom...
	public void synergyStatusChanged(SYNERGY_STATUS ss) {
		//System.out.println("clock status changed to ..."+cs.toString());
  		m_curStatus = ss;
  		returnToMain();
	}
	
	public void onFingerprintEnrollmentSuccess(String strBadgeNum, int nFingerNum){
		String template = FPU.encodedTemplate(strBadgeNum, nFingerNum);
		//save it to persistent layer. and/or upload to the server (in the background thread of course).
		mFpMgr.addFingerPrint(Integer.parseInt(strBadgeNum), 0, template);
		uploadFingerPrintBatch();
	}
	
	public void uploadFingerPrintBatch() {
		//int res = mFpMgr.uploadFingerPrintBatch();
		//System.out.println("upload return code: "+res);
		//using async method
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        return mFpMgr.uploadFingerPrintBatch();
		    }
		});
		try {
			System.out.println("upload future.get() = " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
