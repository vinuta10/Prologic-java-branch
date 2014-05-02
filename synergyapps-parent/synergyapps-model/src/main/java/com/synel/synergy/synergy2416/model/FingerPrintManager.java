package com.synel.synergy.synergy2416.model;

/*
 * This Model is intended to be used in the App
 * as part of the MVC pattern in the presentation layer
 * @author Chaol
 */

public interface FingerPrintManager {
	/*
	 * Download Fingerprint data from server in the background
	 * save them to the local persistence layer.
	 * send a signal when it is done.
	 */
	public int syncFingerPrintsFromServer();
	
	public int uploadFingerPrintRt(int uId, String template);
	
	public int uploadFingerPrintBatch();
	
	public int addFingerPrint(int uId, int fingerNum, String template);
	
	public int updateFingerPrint(int uId, int fingerNum, String template);
	
	public int updateFingerPrintSyncStatus(int uId, int fingerNum, boolean isSynced);
	
	public int deleteFingerPrint(int uId, int fingerNum);
	
	public int deleteFingerPrints(int uId);
	
	public int fingerprintCount();
	
	public String getFingerprintByUserId(int uId);
	
	public int enrollFingerPrint(); //via JNI calls to the fp device
	
	public int sendFingerPrintToFPU();//this is for sending the fp from the db to the fp reader mem
	
	public int deleteFingerPrintFromFPU();// 
	
	public int verifyFingerPrintFromFPU(int badgeNum, int fingerNum); //calling FPU return 0 on success. call validateEmployee(String strBadgeNum, int nFingerNum)

}
