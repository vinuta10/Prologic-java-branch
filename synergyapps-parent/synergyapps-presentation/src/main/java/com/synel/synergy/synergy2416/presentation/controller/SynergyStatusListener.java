package com.synel.synergy.synergy2416.presentation.controller;

import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher.SYNERGY_STATUS;

public interface SynergyStatusListener {
	//This is similar to the Signal portion of QT's signal-slot idiom...
		public void onSynergyStatusChanged(SYNERGY_STATUS ss);
		
		public void onFingerprintEnrollmentSuccess(String strBadgeNum, int nFingerNum);
		
		public void onPunchEvent(String badgeNum, int PunchTypeCode, long timestamp); 
		//TODO let the controller handle the validation of fingerprint validation 
		public void onFingerPrintValidationTimerStart();
}
