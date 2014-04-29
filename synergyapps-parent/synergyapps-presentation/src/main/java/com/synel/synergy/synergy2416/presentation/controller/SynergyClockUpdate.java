package com.synel.synergy.synergy2416.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.swing.Timer;

public class SynergyClockUpdate {
	
	 private static TimeZone m_tz = TimeZone.getDefault();
	 private static SimpleDateFormat mFormatTime =  new SimpleDateFormat("hh:mm:ss");
	 private static SimpleDateFormat mFormatDate =  new SimpleDateFormat("EEE MMM dd, yyyy");
	 

	/**
	 * 
	 */
	public static void initialize(final JLabel timePanel){
		//FontMetrics metrics = timePanel.getFontMetrics(timePanel.getFont());
		Calendar cal = Calendar.getInstance(m_tz);
		timePanel.setText("<html><center><font color=Black><b>"+mFormatDate.format(cal.getTime())+"<br/>"+mFormatTime.format(cal.getTime())+"</b></font></center></html>");
		
	     ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	//Date d = new Date();
	            	Calendar cal = Calendar.getInstance(m_tz);
	                timePanel.setText("<html><center><font color=Black><b>"+mFormatDate.format(cal.getTime())+"<br/>"+mFormatTime.format(cal.getTime())+"</b></font></center></html>");
	            }
	        };
	        Timer t = new Timer(1000, taskPerformer);
	        t.start();
	}
	
	public static void showTimeZoneInfo(){
		System.out.println("This is TimeZone: "+m_tz.toString());
	}

}
