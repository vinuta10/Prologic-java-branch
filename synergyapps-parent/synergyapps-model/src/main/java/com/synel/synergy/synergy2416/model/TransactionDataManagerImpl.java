package com.synel.synergy.synergy2416.model;

import java.util.ArrayList;
import java.util.List;

import com.synel.synergy.synergy2416.persistent.HbmTransactionDataDao;
import com.synel.synergy.synergy2416.persistent.PunchDataPOJO;
import com.synel.synergy.synergy2416.persistent.TransactionDataDao;
import com.synel.synergy.synergy2416.persistent.TransactionDataPOJO;
import com.synel.synergy.synergy2416.webservices.SynergyWebServices;
import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;
import com.xacttime.PunchData;

public class TransactionDataManagerImpl implements TransactionDataManager {
	
private static TransactionDataManagerImpl mInstance = null;
	
	private TransactionDataDao mTdDao;
	private SynergyWebServiceApi mSws;
	private List<TransactionDataPOJO> mTds;
	private EmployeeManager mEmpMgr;
	
	//implement the "radio station to signal the db ready status
	//
	
	private TransactionDataManagerImpl(){
		//initialize variables and start the sync on class start up.
		mTdDao = new HbmTransactionDataDao();
		mSws = new SynergyWebServices();
		mTds = new ArrayList<TransactionDataPOJO>();
		mEmpMgr = EmployeeManagerImpl.getInstance();
	} 
	
	public static TransactionDataManagerImpl getInstance(){
		if(mInstance == null){
			mInstance = new TransactionDataManagerImpl();
		}
		return mInstance;
	}

	@Override
	public int uploadTransactionRt(String badgeNum, String punchType, long timestamp, List<Integer> lldetailIds) {
		
		//int uId = mEmpMgr.getuIdByBadgeNum(badgeNum);
		//int uId = mEmpMgr.getuIdByBadgeNum("101"); //for test only
		int uId = Integer.parseInt(badgeNum); //test
		
			//lldetailIds = EntityMapUtility.mapToLaborLevelDetailIds(mEmpMgr.getEmployeeLaborLevelsById(badgeNum));
		lldetailIds = EntityMapUtility.mapToLaborLevelDetailIds("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0"); //for test only
		System.out.println("Uid: "+uId+ " Sending punchType: "+punchType+" to server..."+"LLIds: "+lldetailIds+" timestamp: "+timestamp);
		return mSws.sendPunchRt(uId, timestamp, punchType, lldetailIds);
	}

	@Override
	public long saveTransaction(TransactionDataPOJO td) {
		return mTdDao.saveTransactionData(td);
	}

	@Override
	public int cleanupTransactions() {
		return mTdDao.cleanUpTransactionData();
	}

	@Override
	public int uploadTransactionBatch() { //make it run in a thread pool?
		// go through the transaction database and upload all the are not uploaded to the server
		// TODO test
		mTds = mTdDao.getTransactiondataListThatNeedUpload();
		List<PunchData> lopd = EntityMapUtility.mapToPunchDataListFromTransactionDataListPOJO(mTds);
		int res = -1;
		res = mSws.sendPunchesBatch(lopd);
		//update the sync status of each record in the db accordingly
		if ( res == 0 ){
			for (TransactionDataPOJO td: mTds) {
				mTdDao.updateTransactionDataSyncStatus(td.id, true);
			}
		}
		return res;
	}

	@Override
	public int uploadTransactionRt(PunchDataPOJO pd) {
		// TODO Auto-generated method stub
		return 0;
	}
}
