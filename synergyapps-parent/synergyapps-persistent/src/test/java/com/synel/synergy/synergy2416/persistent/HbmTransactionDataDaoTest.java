package com.synel.synergy.synergy2416.persistent;

import com.xacttime.ArrayOfInt;
import com.xacttime.PunchData;
import com.xacttime.TimeSlicePreType;

import junit.framework.TestCase;

public class HbmTransactionDataDaoTest extends TestCase {
	
	private HbmTransactionDataDao htdd;

	protected void setUp() throws Exception {
		super.setUp();
		htdd = new HbmTransactionDataDao();
	}

	public void testSaveTransactionData() {
		PunchData pd = new PunchData();
		pd.setUserId(2);
		pd.setPunchType(TimeSlicePreType.CLOCK_IN);
		ArrayOfInt aoi = new ArrayOfInt();
		for(int i:new int[]{12,11,7,3})
		aoi.getInt().add(i);
		pd.setLaborLevelDetailIds(aoi);
		
		TransactionData td = new TransactionData();
		td.setTimestamp(System.currentTimeMillis());
		td.setUploaded(false);
		td.setPd(pd);
		htdd.saveTransactionData(td);
		
	}

	public void testGetTransactionDataById() {
		fail("Not yet implemented");
	}

	public void testGetTransactionDataList() {
		fail("Not yet implemented");
	}

	public void testSaveTransactionDataList() {
		fail("Not yet implemented");
	}

}
