package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public class HbmTransactionDataDao extends HbmBaseDao<TransactionDataPOJO> implements TransactionDataDao {

	@Override
	public long saveTransactionData(TransactionDataPOJO td) {
		return (this.saveData(td));
	}

	@Override
	public TransactionDataPOJO getTransactionDataById(long id) {
		return this.getDataWithLongId(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionDataPOJO> getTransactionDataList() {
		String hql = "From TransactionDataPOJO";
		return (List<TransactionDataPOJO>) HibernateUtilities.SelectQueryList(hql);
	}

	@Override
	public List<Long> saveTransactionDataList(List<TransactionDataPOJO> lltd) {
		return (this.saveDataList(lltd));
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
		return (List<TransactionDataPOJO>) HibernateUtilities.SelectQueryList(hql);
	}

	@Override
	public int updateTransactionDataSyncStatus(long id, boolean isUploaded) {
	//TODO test
		int res = -1;
		String hql = "update TransactionDataPOJO t set t.uploaded= "+"\'"+isUploaded+"\'"+" where t.id = "+id;
		System.out.println("now updating ..."+hql);
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}
    
	@Override
	public int getNumberOfTransactionDataThatNeedUpload() {
		int res = 0;
		String hql = "select count(t) from TransactionDataPOJO t where t.uploaded = 'false'";
		res = HibernateUtilities.SelectQueryUniqueInt(hql);
		return res;
	}
}
