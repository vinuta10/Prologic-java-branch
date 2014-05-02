package com.synel.synergy.synergy2416.model;

import java.util.ArrayList;
import java.util.List;

import com.synel.synergy.synergy2416.persistent.FingerPrintDao;
import com.synel.synergy.synergy2416.persistent.FingerPrintPOJO;
import com.synel.synergy.synergy2416.persistent.HbmFingerPrintDao;
import com.synel.synergy.synergy2416.webservices.SynergyWebServices;
import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;
import com.xacttime.Fingerprint;

public class FingerPrintManagerImpl implements FingerPrintManager{
	
	private static FingerPrintManagerImpl mInstance = null;
	
	private FingerPrintDao mFpDao;
	private SynergyWebServiceApi mSws;
	private List<FingerPrintPOJO> mFps;
	
	//implement the "radio station to signal the db ready status
	//
	
	private FingerPrintManagerImpl(){
		//initialize variables and start the sync on class start up.
		mFpDao = new HbmFingerPrintDao();
		mSws = new SynergyWebServices();
		mFps = new ArrayList<FingerPrintPOJO>();
	} 
	
	public static FingerPrintManagerImpl getInstance(){
		if(mInstance == null){
			mInstance = new FingerPrintManagerImpl();
		}
		return mInstance;
	}

	@Override
	public int syncFingerPrintsFromServer() {
		int res = -1;
		try {
			mFps = EntityMapUtility.mapToFingerPrintPOJOList(mSws.getFingerPrints());
			EntityMapUtility.updateFingerPrintPOJOStatusList(mFps, true); //TODO test
		} catch (Exception ex){
			ex.printStackTrace();
			return -1;
		}
		mFpDao.saveFingerprints(mFps);
		res = 0;
		//emit fingerprint_db_ready();
		return res;
	}

	@Override
	public void uploadFingerPrintRt(int uId, String template) {
		mSws.sendFingerPrint(uId, template);
	}

	@Override
	public void uploadFingerPrintBatch() {
		// TODO Auto-generated method stub
		//go through the finger print db and upload those that are not synced already
		List<Fingerprint> fps = EntityMapUtility.mapToFingerPrintList(mFpDao.getDirtyFingerPrints());
		
		
		
	}

	@Override
	public int addFingerPrint(int uId, int fingerNum, String template) {
		FingerPrintPOJO fp = new FingerPrintPOJO();
		fp.setFingerNum(0);//it is always #0 for this version, will expand in the future
		fp.setUserId(uId);
		fp.setTemplate(template);
		mFpDao.saveFingerprint(fp);
		return 0;
	}

	@Override
	public int updateFingerPrint(int uId, int fingerNum, String template) {
		return mFpDao.updateFingerPrintTemplate(uId,fingerNum,template);
	}

	@Override
	public int deleteFingerPrint(int uId, int fingerNum) {
		return mFpDao.deleteFingerPrint(uId, fingerNum);
	}

	@Override
	public int deleteFingerPrints(int uId) {
		return mFpDao.deleteFingerPrints(uId);
	}

	@Override
	public int fingerprintCount() {
		return mFpDao.getFingerPrintCount();
	}

	@Override
	public String getFingerprintByUserId(int uId) {
		return mFpDao.getFingerprint(uId, 0).getTemplate();
	}

	@Override
	public int updateFingerPrintSyncStatus(int uId, int fingerNum,
			boolean isSynced) {
		// TODO Auto-generated method stub
		int res= -1;
		res = mFpDao.updateFingerPrintSyncStatus(uId, fingerNum, isSynced);
		return res;
	}
}
