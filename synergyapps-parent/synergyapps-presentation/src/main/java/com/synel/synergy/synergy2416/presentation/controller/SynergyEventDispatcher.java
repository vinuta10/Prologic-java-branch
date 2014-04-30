package com.synel.synergy.synergy2416.presentation.controller;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

/**
 * @author chaol
 * This is the class to catch and report all synergy2416 related events
 * such as keypad press, hid input, finger print event, webcam, etc.
 * This is the "radio station" that the controller can tune in and listen to.
 *
 */
public class SynergyEventDispatcher {
	
	private static final String fpPath = "/home/admin/synergy/fingers/";
	
	
	public enum SYNERGY_STATUS
	{
	    SYNERGYSTATUS_FAULT,
	    SYNERGYSTATUS_UNINITIALIZED,
	    SYNERGYSTATUS_VIDEO,
	    SYNERGYSTATUS_WEBCAM,
	    SYNERGYSTATUS_LED,
	    SYNERGYSTATUS_FINGERPRINT_ENROLL,
	    SYNERGYSTATUS_FINGERPRINT_CONTROL,
	    SYNERGYSTATUS_SYSINFO,
	    SYNERGYSTATUS_MENU,
	    SYNERGYSTATUS_READY
	}
	
	private static SYNERGY_STATUS m_prestatus;
	private SYNERGY_STATUS m_status;
	List<SynergyStatusListener> listeners = new ArrayList<SynergyStatusListener>();
	
	public void addListener(SynergyStatusListener sl) {
		listeners.add(sl);
	}
	
	private void emit(SYNERGY_STATUS cs){
		for (SynergyStatusListener sl : listeners) {
			sl.synergyStatusChanged(cs);
		}	
	}
	
	public void diffAndEmit(SYNERGY_STATUS cs){
		    
  		  set_prestatus(m_status);
  		  m_status = cs;
		  emit (cs);
	}
	
	//Constructor
	public SynergyEventDispatcher(){
		m_status = SYNERGY_STATUS.SYNERGYSTATUS_UNINITIALIZED;
		diffAndEmit (m_status);
	}
	
	public void initialize() {	  
		while (FPU.openFPU(fpPath) !=0 ){
		}
		System.out.println("Changing clock status to ready ...");
  	  	m_status = SYNERGY_STATUS.SYNERGYSTATUS_READY;
  	  	//diffAndEmit(m_status);
  	  	emit(m_status);
  	  	System.out.println("Changing clock status to ready done.");
	}

	public void handlekeyPressed(KeyEvent e) {
		
		System.out.println("keypad pressed, status is "+m_status);
		//MainWindow.getM_ap().playKeypadSound();
		
		switch(e.getKeyCode()){
			case KeyEvent.VK_F1:			
				m_status = SYNERGY_STATUS.SYNERGYSTATUS_VIDEO;
				diffAndEmit(m_status);
				
				break;
				
			case KeyEvent.VK_F2:
				m_status = SYNERGY_STATUS.SYNERGYSTATUS_WEBCAM;
				diffAndEmit(m_status);
	
				break;
				
			case KeyEvent.VK_F3:
				m_status = SYNERGY_STATUS.SYNERGYSTATUS_FINGERPRINT_ENROLL;
				diffAndEmit(m_status);
				
				break;
				
			case KeyEvent.VK_F4:
				
				m_status = SYNERGY_STATUS.SYNERGYSTATUS_FINGERPRINT_CONTROL;
				diffAndEmit(m_status);
		
				break;
				
			case KeyEvent.VK_F7:
				//MENU key has keycode 118 which maps to F7
				System.out.println("MENU Pushed");
				m_status = SYNERGY_STATUS.SYNERGYSTATUS_MENU;
				diffAndEmit(m_status);
				break;
				
			case KeyEvent.VK_F5:
				//IN key sequence starts with F5 (keyCode 116)
				//OUT key sequence starts with F6 (keyCode 117)
				//m_status = CLOCK_STATUS.CLOCKSTATUS_SYSINFO;
				//diffAndEmit(m_status);
				//DemoSysInfo.showInfo();
			case KeyEvent.VK_F6:
				//OUT key sequence starts with F6 (keyCode 117)
			case KeyEvent.VK_ENTER:
		
			case KeyEvent.VK_ESCAPE:
				Component source = e.getComponent();
		         if (source instanceof JTextField){
		             JTextField f = (JTextField) source;
		             f.setText("");
		         }
				//Let the focus window handle the enter/esc/IN/OUT key event
				break;
			default:
				break;
		}
	}
	
	public SYNERGY_STATUS synergyStatus(){
    	return m_status;
	}

	public void set_status(SYNERGY_STATUS status) {
		this.m_status = status;
	}

	public static SYNERGY_STATUS get_prestatus() {
		return m_prestatus;
	}

	public static void set_prestatus(SYNERGY_STATUS m_prestatus) {
		SynergyEventDispatcher.m_prestatus = m_prestatus;
	}

//	@Override
//	public boolean dispatchKeyEvent(KeyEvent e) {
//		
//		//System.out.println("Key Char: "+ e.getKeyChar() +" Key Code:  "+ (int) e.getKeyCode());
//		//Component comp = e.getComponent();
//		//KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(comp,e);
//	    if (e.getID() == KeyEvent.KEY_PRESSED) {
//	    	handlekeyPressed(e);
//            //System.out.println("key pressed");
//        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
//            //System.out.println("key released");
//        } else if (e.getID() == KeyEvent.KEY_TYPED) {
//           //TODO
//        }
//		return false;
//	}
}
