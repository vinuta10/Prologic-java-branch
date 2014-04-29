package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface TransactionDataDao {
	
	public void saveTransactionData(TransactionData td);
	
	public void saveTransactionDataList(List<TransactionData> lltd);
	
	public TransactionData getTransactionDataById(int id);
	
	public List<TransactionData> getTransactionDataList();

}
