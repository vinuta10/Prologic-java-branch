package com.synel.synergy.synergy2416.model;

public interface TransactionDataManager {
	
	public void uploadTransaction(int id, long epoch, int uId, String eId, int punchType, String lldetails); //upload the data to the web server
	
	public void saveTransaction(int id, long epoch, int uId, String eId, int punchType, String lldetails);//log data to the persistent layer
	
	public void cleanupTransactions(); //delete all transactions that were uploaded to the server from the persistent layer
}
