package com.synel.synergy.synergy2416.model;

import com.synel.synergy.synergy2416.persistent.PunchDataPOJO;
import com.synel.synergy.synergy2416.persistent.TransactionDataPOJO;

public interface TransactionDataManager {
	
	public int uploadTransactionRt(PunchDataPOJO pd); //upload the single punch to the web server real time, return success or error code
	
	public long saveTransaction(TransactionDataPOJO td);//log data to the persistent layer, return the id given by persistent layer
	
	public int cleanupTransactions(); //delete all transactions that were uploaded to the server from the persistent layer, return error code or success
	
	public int uploadTransactionBatch(); //go through the persistent layer and upload all punchdata that have not been uploaded, return error code or success

}
