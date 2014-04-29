package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public class HbmTransactionDataDao extends HbmBaseDao<TransactionData> implements TransactionDataDao {

	@Override
	public void saveTransactionData(TransactionData td) {
		this.saveData(td);
	}

	@Override
	public TransactionData getTransactionDataById(int id) {
		return this.getData(id);
	}

	@Override
	public List<TransactionData> getTransactionDataList() {
		return this.getTransactionDataList();
	}

	@Override
	public void saveTransactionDataList(List<TransactionData> lltd) {
		this.saveDataList(lltd);
	}
}
