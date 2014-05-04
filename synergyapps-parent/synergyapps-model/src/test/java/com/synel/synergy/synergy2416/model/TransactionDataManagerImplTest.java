package com.synel.synergy.synergy2416.model;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.synel.synergy.synergy2416.persistent.PunchDataPOJO;
import com.synel.synergy.synergy2416.persistent.TransactionDataPOJO;

public class TransactionDataManagerImplTest {
	
	private TransactionDataManagerImpl mTdm;

	@Before
	public void setUp() throws Exception {
		mTdm = TransactionDataManagerImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUploadTransactionRt() {
		PunchDataPOJO pd = new PunchDataPOJO();
		pd.setUserId(3);
		pd.setTransactionTime(System.currentTimeMillis());
		pd.setPunchType("ClockIn");
		pd.setLaborLevelDetailIds(new ArrayList<Integer>(Arrays.asList(12,11,2,8)));
		int res = mTdm.uploadTransactionRt(pd);
		System.out.println("punchdata sent successfully, result: "+res);
	}

	@Test
	public void testSaveTransaction() {
		TransactionDataPOJO td = new TransactionDataPOJO();
		PunchDataPOJO pd = new PunchDataPOJO();
		pd.setUserId(3);
		pd.setTransactionTime(System.currentTimeMillis());
		pd.setPunchType("ClockIn");
		pd.setLaborLevelDetailIds(new ArrayList<Integer>(Arrays.asList(12,11,2,8)));
		td.setPd(pd);
		td.setTimestamp(pd.getTransactionTime());
		td.setUploaded(false);
		long id = mTdm.saveTransaction(td);
		System.out.println("transaction data saved suceecssfully with id: "+id);
	}

	@Test
	public void testUploadTransactionBatch() {
		//int res = mFpMgr.uploadFingerPrintBatch();
		//System.out.println("upload return code: "+res);
		//using async method
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		@SuppressWarnings("unchecked")
		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        return mTdm.uploadTransactionBatch();
		    }
		});
		try {
			System.out.println("upload future.get() = " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCleanupTransactions() {
		int res = mTdm.cleanupTransactions();
		System.out.println("Cleaned Up the transaction table with result: "+res);
	}
}
