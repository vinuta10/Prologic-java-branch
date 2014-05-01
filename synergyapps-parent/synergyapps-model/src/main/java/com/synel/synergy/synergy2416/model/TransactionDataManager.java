package com.synel.synergy.synergy2416.model;

public interface TransactionDataManager {
	
	public void uploadTransactionRt(int id, long epoch, int uId, String eId, int punchType, String lldetails); //upload the single punch to the web server real time
	
	public void saveTransaction(int id, long epoch, int uId, String eId, int punchType, String lldetails);//log data to the persistent layer
	
	public void cleanupTransactions(); //delete all transactions that were uploaded to the server from the persistent layer
	
	public void uploadTransactionBatch(); //go through the persistent layer and upload all punchdata that have not been uploaded

}
