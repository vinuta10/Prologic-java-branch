package com.synel.synergy.synergy2416.model;

public interface TransactionDataManager {
	
	public void uploadTransaction(int id, long epoch, int uId, String eId, int punchType, String lldetails);
	
	public void saveTransaction(int id, long epoch, int uId, String eId, int punchType, String lldetails);
	
	public void cleanupTransactions(); //delete all transactions that were uploaded to the server
}
