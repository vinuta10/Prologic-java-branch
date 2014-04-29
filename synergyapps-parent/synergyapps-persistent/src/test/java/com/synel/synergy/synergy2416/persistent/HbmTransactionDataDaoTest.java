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
		PunchDataPOJO pd = new PunchDataPOJO();
		pd.setUserId(2);
		pd.setPunchType("Clock_In");
		pd.setLaborLevelDetailIds(new int[]{12,11,7,3});
		TransactionDataPOJO td = new TransactionDataPOJO();
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
