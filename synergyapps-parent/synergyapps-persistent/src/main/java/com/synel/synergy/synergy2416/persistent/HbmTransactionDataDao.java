package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public class HbmTransactionDataDao extends HbmBaseDao<TransactionDataPOJO> implements TransactionDataDao {

	@Override
	public void saveTransactionData(TransactionDataPOJO td) {
		this.saveData(td);
	}

	@Override
	public TransactionDataPOJO getTransactionDataById(int id) {
		return this.getData(id);
	}

	@Override
	public List<TransactionDataPOJO> getTransactionDataList() {
		return this.getTransactionDataList();
	}

	@Override
	public void saveTransactionDataList(List<TransactionDataPOJO> lltd) {
		this.saveDataList(lltd);
	}

	@Override
	public int cleanUpTransactionData() {
		String hql = "delete TransactionDataPOJO where uploaded = 'true'"; //check it!
		return HibernateUtilities.ExecUpdateQuery(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionDataPOJO> getTransactiondataListThatNeedUpload() {
	    String hql = "From TransactionDataPOJO where uploaded = 'false'";
		return (List<TransactionDataPOJO>) HibernateUtilities.SelectQuery(hql);
	}
}
