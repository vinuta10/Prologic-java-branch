package com.synel.synergy.synergy2416.model;

import java.util.ArrayList;
import java.util.List;

import com.synel.synergy.synergy2416.persistent.HbmTransactionDataDao;
import com.synel.synergy.synergy2416.persistent.TransactionDataDao;
import com.synel.synergy.synergy2416.persistent.TransactionDataPOJO;
import com.synel.synergy.synergy2416.webservices.SynergyWebServices;
import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;

public class TransactionDataManagerImpl implements TransactionDataManager {
	
private static TransactionDataManagerImpl mInstance = null;
	
	private TransactionDataDao mTdDao;
	private SynergyWebServiceApi mSws;
	private List<TransactionDataPOJO> mTds;
	
	//implement the "radio station to signal the db ready status
	//
	
	private TransactionDataManagerImpl(){
		//initialize variables and start the sync on class start up.
		mTdDao = new HbmTransactionDataDao();
		mSws = new SynergyWebServices();
		mTds = new ArrayList<TransactionDataPOJO>();
	} 
	
	public static TransactionDataManagerImpl getInstance(){
		if(mInstance == null){
			mInstance = new TransactionDataManagerImpl();
		}
		return mInstance;
	}

	@Override
	public void uploadTransactionRt(int id, long epoch, int uId, String eId,
			int punchType, String lldetails) {
		//mSws.sendPunchRt(uId, epoch, punchType, lldetailIds)
//		PunchDataPOJO pd = new PunchDataPOJO();
//		pd.setPunchType(convertToPunchTypeString(punchType));
//		pd.setTransactionTime(epoch);
//		pd.setLaborLevelDetailIds(lldetails);
	}

	@Override
	public void saveTransaction(int id, long epoch, int uId, String eId,
			int punchType, String lldetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanupTransactions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadTransactionBatch() {
		// go through the transaction database and upload all the are not uploaded to the server
		// TODO test
		
	}

}
