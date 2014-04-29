package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface TransactionDataDao {
	
	public void saveTransactionData(TransactionDataPOJO td);
	
	public void saveTransactionDataList(List<TransactionDataPOJO> lltd);
	
	public TransactionDataPOJO getTransactionDataById(int id);
	
	public List<TransactionDataPOJO> getTransactionDataList(); //get the list of transactions 
	
	public List<TransactionDataPOJO> getTransactiondataListThatNeedUpload(); //get the list of transactions not uploaded
	
	public int cleanUpTransactionData(); //delete all records that were uploaded to the server

}
