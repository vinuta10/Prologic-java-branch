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
			mFps = convertToFingerPrintPOJOList(mSws.getFingerPrints());
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
	public void uploadFingerPrint(int uId, String template) {
		mSws.sendFingerPrint(uId, template);
	}

	@Override
	public void uploadFingerPrintBatch() {
		// TODO Auto-generated method stub
	}

	@Override
	public int addFingerPrint(int uId, int fingerNum, String template) {
		FingerPrintPOJO fp = new FingerPrintPOJO();
		fp.setFingerNum(0);
		fp.setUserId(uId);
		fp.setTemplate(template);
		mFpDao.saveFingerprint(fp);
		return 0;
	}

	@Override
	public int updateFingerPrint(int uId, int fingerNum, String template) {
		//TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFingerPrint(int uId, int fingerNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFingerPrints(int uId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int listFingerPrints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fingerprintCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFingerprintByUserId(int uId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<FingerPrintPOJO> convertToFingerPrintPOJOList(List<Fingerprint> fps) {
		List<FingerPrintPOJO> aofp = new ArrayList<FingerPrintPOJO>();
		for(Fingerprint fp:fps){
			aofp.add(convertToFingerPrintPOJO(fp));
		}
		return aofp;
	}
	
	private FingerPrintPOJO convertToFingerPrintPOJO(Fingerprint fp){
		FingerPrintPOJO f = new FingerPrintPOJO();
		f.setUserId(fp.getUserId());
		f.setFingerNum(0);
		f.setTemplate(fp.getTemplate());
		return f;
	}

}
