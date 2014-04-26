package com.synel.synergy.synergy2416.webservices;

import junit.framework.TestCase;

public class SynergyWebServicesUnitTest extends TestCase {
	
	private SynergyWebServices mSws;

	protected void setUp() throws Exception {
		super.setUp();
		mSws = new SynergyWebServices();
	}

	public void testSendPunchRt() {
		try {
			mSws.sendPunchRt(2,1398213377, 1 , new int[] {12,34,56,78});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testSendPunchesBatch() {
		fail("Not yet implemented");
	}

	public void testGetFingerPrints() {
		fail("Not yet implemented");
	}

	public void testSendFingerPrint() {
		fail("Not yet implemented");
	}

	public void testGetEmployees() {
		fail("Not yet implemented");
	}

	public void testGetLaborLevelDetails() {
		fail("Not yet implemented");
	}

	public void testGetServerTime() {
		fail("Not yet implemented");
	}

}
