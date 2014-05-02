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
	public int uploadFingerPrintRt(int uId, String template) {
		return mSws.sendFingerPrint(uId, template);
	}

	@Override
	public int uploadFingerPrintBatch() {
		// TODO Auto-generated method stub
		//go through the finger print db and upload those that are not synced already
		List<FingerPrintPOJO> fps = mFpDao.getDirtyFingerPrints();
		int uId =0;
		String template;
		for(FingerPrintPOJO fp:fps){
			uId = fp.getUserId();
			template = fp.getTemplate();
			if (0 == mSws.sendFingerPrint(uId, template)){
				 updateFingerPrintSyncStatus(uId, 0, true);
				//or: fp.setSynced(true); mFpDao.saveFingerprint(fp);
			}
		}
		return 0;
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
		//TODO need to set the synced flag to false
		return mFpDao.updateFingerPrintTemplate(uId,fingerNum,template);
	}

	@Override
	public int deleteFingerPrint(int uId, int fingerNum) {
		//TODO need to add a web method to delete the corresponding record on the server as well.
		return mFpDao.deleteFingerPrint(uId, fingerNum);
	}

	@Override
	public int deleteFingerPrints(int uId) {
		//TODO need to add a web method to delete the corresponding record on the server as well.
		return mFpDao.deleteFingerPrints(uId);
	}

	@Override
	public int fingerprintCount() {
		return mFpDao.getFingerPrintCount();
	}

	@Override
	public String getFingerprintByUserId(int uId) {
		//return result can be null
		String res = null;
		FingerPrintPOJO fp = mFpDao.getFingerprint(uId, 0);
		if (null != fp){
			res = fp.getTemplate();
		}
		return res;
	}

	@Override
	public int updateFingerPrintSyncStatus(int uId, int fingerNum,
			boolean isSynced) {
		int res= -1;
		res = mFpDao.updateFingerPrintSyncStatus(uId, fingerNum, isSynced);
		return res;
	}

	@Override
	public int enrollFingerPrint() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sendFingerPrintToFPU() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFingerPrintFromFPU() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int verifyFingerPrintFromFPU() {
		// TODO Auto-generated method stub
		return 0;
	}
}
