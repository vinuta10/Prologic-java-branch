package com.synel.synergy.synergy2416.model;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FingerPrintManagerImplTest {
	
	private FingerPrintManager mFpMgr = FingerPrintManagerImpl.getInstance();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMasterSuite(){
		System.out.println("===========================Begin Test 1==========================================");
		testSyncFingerPrintsFromServer();
	
		System.out.println("===========================Begin Test 2==========================================");
		testFingerprintCount();
		
		System.out.println("===========================Begin Test 3==========================================");
		testUploadFingerPrintRt();
		
		System.out.println("===========================Begin Test 3==========================================");
		testAddFingerPrint();
		
		System.out.println("===========================Begin Test 4==========================================");
		testUpdateFingerPrint();
		
		System.out.println("===========================Begin Test 5==========================================");
		testGetFingerprintByUserId();
		
		System.out.println("===========================Begin Test 6==========================================");
		testDeleteFingerPrints();
		
		System.out.println("===========================Begin Test 7==========================================");
		testFingerprintCount();
		
		System.out.println("===========================Begin Test 8==========================================");
		testDeleteFingerPrint();
		
		System.out.println("===========================Begin Test 9==========================================");
		testFingerprintCount();
		
		System.out.println("===========================  End Test ==========================================");
	}

	@Test
	@Ignore
	public void testSyncFingerPrintsFromServer() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        return mFpMgr.syncFingerPrintsFromServer();
		    }
		});
		try {
			System.out.println("future.get() = " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testUploadFingerPrintRt() {
		String template = mFpMgr.getFingerprintByUserId(2);
		int res = mFpMgr.uploadFingerPrintRt(2, template);
		System.out.println("upload return code: "+res);
	}

	@Test
	@Ignore
	public void testUploadFingerPrintBatch() {
		//int res = mFpMgr.uploadFingerPrintBatch();
		//System.out.println("upload return code: "+res);
		//using async method
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        return mFpMgr.uploadFingerPrintBatch();
		    }
		});
		try {
			System.out.println("upload future.get() = " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testAddFingerPrint() {
		String template = mFpMgr.getFingerprintByUserId(2);
		int res = mFpMgr.addFingerPrint(100, 0, template);
		System.out.println("add fp return code: "+res);
	}

	@Test
	@Ignore
	public void testUpdateFingerPrint() {
		//TODO do fingerprint enrollment action here via FPU JNI call
		String template = mFpMgr.getFingerprintByUserId(2);
		int res = mFpMgr.addFingerPrint(100, 0, template);
		System.out.println("add fp return code: "+res);
	}

	@Test
	@Ignore
	public void testDeleteFingerPrint() {
		int res = mFpMgr.deleteFingerPrint(2, 0);
		System.out.println("Deleted: fingerprint uId 2 fig 0 with result: "+res);
	}

	@Test
	@Ignore
	public void testDeleteFingerPrints() {
		int res = mFpMgr.deleteFingerPrint(2, 0);
		System.out.println("Deleted: fingerprints uId 2 with result: "+res);
	}

	@Test
	@Ignore
	public void testFingerprintCount() {
		System.out.println("FingerPrint count: "+mFpMgr.fingerprintCount());
	}

	@Test
	@Ignore
	public void testGetFingerprintByUserId() {
		String res = mFpMgr.getFingerprintByUserId(2);
		if (res != null){
			System.out.println("FingerPrint #2 is: "+res);
		} else {
			System.out.println("can not find the fp template, does user exist?");
		}
	}

	@Test
	@Ignore
	public void testUpdateFingerPrintSyncStatus() {
		int res = mFpMgr.updateFingerPrintSyncStatus(2, 0, true);
		System.out.println("FingerPrint sync updated with result: "+res);
	}

}
