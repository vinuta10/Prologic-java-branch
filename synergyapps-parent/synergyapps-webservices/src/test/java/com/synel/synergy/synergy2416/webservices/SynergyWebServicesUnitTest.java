package com.synel.synergy.synergy2416.webservices;

import java.util.List;

import com.xacttime.ArrayOfFingerprint;
import com.xacttime.Fingerprint;

import junit.framework.TestCase;

public class SynergyWebServicesUnitTest extends TestCase {
	
	private SynergyWebServices mSws;
	private List<Fingerprint> mFps;

	protected void setUp() throws Exception {
		super.setUp();
		mSws = new SynergyWebServices();
	}

	public void testSendPunchRt() {
		try {
			mSws.sendPunchRt(4,1398213379, 2 , new int[] {12,11,16,9});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testSendPunchesBatch() {
		fail("Not yet implemented");
	}

	public void testGetFingerPrints() {
		try {
			mFps = mSws.getFingerPrints();
			showFingerprints(mFps);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void showFingerprints(List<Fingerprint> aof) {
		
		for(Fingerprint fp:aof){
			System.out.println("UID: "+fp.getUserId()+" Template: "+fp.getTemplate());
		}
		
	}

	public void testSendFingerPrint() {
		mFps = mSws.getFingerPrints();
		for(Fingerprint fp:mFps){
			mSws.sendFingerPrint(fp.getUserId()+5, fp.getTemplate());
		}
	}

	public void testGetEmployees() {
		try {
			mSws.getEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetLaborLevel() {
		fail("Not yet implemented");
	}

	public void testGetServerTime() {
		fail("Not yet implemented");
	}

}
