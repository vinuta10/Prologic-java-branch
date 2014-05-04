package com.synel.synergy.synergy2416.persistent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class HbmTransactionDataDaoTest extends TestCase {
	
	private HbmTransactionDataDao htdd;
	private long mId = 3;

	protected void setUp() throws Exception {
		super.setUp();
		htdd = new HbmTransactionDataDao();
	}
	
	@Test
	public void testMasterSuites() {
		
		System.out.println("================== Begin test suite 1===================================");
		testSaveTransactionData();
		System.out.println("================== Begin test suite 2===================================");
		testSaveTransactionDataList();
		System.out.println("================== Begin test suite 3===================================");
		testGetTransactionDataList();
		System.out.println("================== Begin test suite 4===================================");
		testGetTransactionDataById();
		System.out.println("================== Begin test suite 5===================================");
		testGetTransactiondataListThatNeedUpload();
		System.out.println("================== Begin test suite 6===================================");
		testCleanUpTransactionData();
		System.out.println("================== End test suite ===================================");
		
	}

	@Test
	@Ignore
	public void testSaveTransactionData() {
		PunchDataPOJO pd = new PunchDataPOJO();
		pd.setUserId(2);
		pd.setPunchType("Clock_In");
		pd.setLaborLevelDetailIds(new ArrayList<Integer>(Arrays.asList(12,2,3,11)));
		TransactionDataPOJO td = new TransactionDataPOJO();
		td.setTimestamp(System.currentTimeMillis());
		td.setUploaded(false);
		td.setPd(pd);
		mId = htdd.saveTransactionData(td);
		System.out.println("Transaction data saved with id: "+mId);
	}
	
	@Test
	@Ignore
	public void testSaveTransactionDataList() {
		List<TransactionDataPOJO> lltd = new ArrayList<TransactionDataPOJO>();
		for(int i = 0; i<10000; i++){
			TransactionDataPOJO td = new TransactionDataPOJO();
			PunchDataPOJO pd = new PunchDataPOJO();
			Random rdg = new Random();
			td.setId(rdg.nextLong());
			td.setTimestamp(System.currentTimeMillis());
			td.setPd(pd);
			pd.setUserId(rdg.nextInt(i+1));
			pd.setPunchType(getPunchType(i%9));
			pd.setTransactionTime(System.currentTimeMillis());
			pd.setLaborLevelDetailIds(generateLLDetailIds(new int[] {rdg.nextInt(15),rdg.nextInt(15),rdg.nextInt(15), rdg.nextInt(15)}));
			System.out.println("punched: "+pd.getUserId()+" punchtype: "+pd.getPunchType()+" timestamp: "+pd.getTransactionTime()+" llids: "+pd.getLaborLevelDetailIds().toString());
			lltd.add(td);
		}
		List<Long> ids = htdd.saveDataList(lltd);
		System.out.println("Datalist of size "+ids.size() +" saved!");
	}

	@Test
	@Ignore
	public void testGetTransactionDataList() {
		List<TransactionDataPOJO> lltd = new ArrayList<TransactionDataPOJO>(htdd.getTransactionDataList());
		System.out.println("get: "+lltd.size()+" records ");
		for(TransactionDataPOJO td:lltd){
		    //System.out.println("llevels: "+td.getPd().getLaborLevelDetailIds()); //TODO solve the hibernate LIE(LazyInitializationException)
		    System.out.println(td.toString());
		}
	}

	@Test
	@Ignore
	public void testGetTransactionDataById() {
		TransactionDataPOJO td = htdd.getTransactionDataById(mId);
		if (td !=null ){
			System.out.println("dada: "+td.getPd().toString());
		} else {
			System.out.println("No transaction of id "+mId+" found!");
		}
	}
	
	@Test
	@Ignore
	public void testGetTransactiondataListThatNeedUpload() {
		List<TransactionDataPOJO> lltd = htdd.getTransactiondataListThatNeedUpload();
		System.out.println("get: "+lltd.size()+" records ");
		for(TransactionDataPOJO td:lltd){
		    System.out.println(td.toString());
		}
	}
	
	@Test
	public void testCleanUpTransactionData(){
		int res = htdd.cleanUpTransactionData();
		System.out.println("records cleaned: "+res);
	}
	
	
	private String getPunchType(int punchNum) {
		switch(punchNum){
    	case 1:
    		return "CLOCK_IN";
    	case 2:
    		return "CLOCK_OUT";
    	case 3:
    		return "START_BREAK";
    	case 4:
    		return "START_LUNCH";
    	case 5:
    		return "END_BREAK";
    	case 6:
    		return "END_LUNCH";
    	case 7:
    		return "PAY_ADJUSTMENT";
    	case 8:
    		return "NON_WORK";
    	default:
    		return "SWIPE_AND_GO";
		}
	}
	
	private List<Integer> generateLLDetailIds(int[] lldetailIds){
		List<Integer> aoi = new ArrayList<Integer>();
		for(Integer i:lldetailIds){
			aoi.add(i);
		}
		return aoi;
	}

}
