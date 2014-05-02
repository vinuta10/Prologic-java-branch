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
	
	public void uploadFingerPrintRt(int uId, String template);
	
	public void uploadFingerPrintBatch();
	
	public int addFingerPrint(int uId, int fingerNum, String template);
	
	public int updateFingerPrint(int uId, int fingerNum, String template);
	
	public int updateFingerPrintSyncStatus(int uId, int fingerNum, boolean isSynced);
	
	public int deleteFingerPrint(int uId, int fingerNum);
	
	public int deleteFingerPrints(int uId);
	
	public int fingerprintCount();
	
	public String getFingerprintByUserId(int uId);

}
