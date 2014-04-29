package com.synel.synergy.synergy2416.model;

/*
 * This Model is intended to be used in the App
 * as part of the MVC pattern in the presentation layer
 * @author Chaol
 */

public interface FingerPrintManager {
	
	public Integer addFingerPrint(int uId,String template);
	
	public void updateFingerPrint(int uId, String template);
	
	public void deleteFingerPrint(int uId);
	
	public void listFingerPrints();
	
	public String getFingerprintByUserId(int uId);
	
	public void uploadFingerPrint(int uId,String template);
	
	public void uploadFingerPrintBatch();

}
