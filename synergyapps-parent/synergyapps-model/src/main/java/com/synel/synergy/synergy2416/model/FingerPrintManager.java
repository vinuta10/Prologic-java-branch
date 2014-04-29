package com.synel.synergy.synergy2416.model;

/*
 * This Model is intended to be used in the App
 * as part of the MVC pattern in the presentation layer
 * @author Chaol
 */

public interface FingerPrintManager {
	
	public Integer addFingerPrint(int uId, int fingerNum, String template);
	
	public int updateFingerPrint(int uId, int fingerNum, String template);
	
	public int deleteFingerPrint(int uId, int fingerNum);
	
	public int deleteFingerPrints(int uId);
	
	public int listFingerPrints();
	
	public String getFingerprintByUserId(int uId);
	
	public void uploadFingerPrint(int uId,String template);
	
	public void uploadFingerPrintBatch();

}
