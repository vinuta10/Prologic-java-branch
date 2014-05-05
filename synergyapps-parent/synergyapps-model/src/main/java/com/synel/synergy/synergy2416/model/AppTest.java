package com.synel.synergy.synergy2416.model;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Ignore;
import org.junit.Test;

public class AppTest {

	private static EmployeeManager mEmpMgr = EmployeeManagerImpl.getInstance();
//	private static EmployeeManagerImplTest emt = new EmployeeManagerImplTest();
//	private static FingerPrintManagerImplTest fpmt = new FingerPrintManagerImplTest();
//	private static TransactionDataManagerImplTest tdmt = new TransactionDataManagerImplTest();
	
	public static void main(String[] args) {
//		emt.testMasterSuite();
//		fpmt.testMasterSuite();
//		tdmt.testMasterSuite();
		testEmployeeSuite();
	}
	
	public static void testEmployeeSuite(){
	System.out.println("===========================Begin Test 1==========================================");
	testSyncEmployeesFromServer();
	
	System.out.println("===========================Begin Test 2==========================================");
	testGetEmployeeCount();
	
	System.out.println("===========================Begin Test 3==========================================");
	testGetEmployeeLaborLevelsById();
	
	System.out.println("===========================Begin Test 4==========================================");
	testGetEmployeeNameById();
	
	System.out.println("===========================Begin Test 5==========================================");
	testUpdateEmployeeLaborLevels();
	
	System.out.println("===========================Begin Test 6==========================================");
	testGetEmployeeLaborLevelsById();
	
	System.out.println("===========================Begin Test 7==========================================");
	testGetEmployeeNameById();
	
	System.out.println("===========================Begin Test 8==========================================");
	testDeleteEmployeeById();
	
	System.out.println("===========================Begin Test 9==========================================");
	testGetEmployeeCount();
	
	System.out.println("===========================  End Test ==========================================");
}
	
	public static void testSyncEmployeesFromServer() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        return mEmpMgr.syncEmployeesFromServer();
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
	public static void testGetEmployeeCount() {
		System.out.println("Employee Count: "+mEmpMgr.getEmployeeCount());
	}

	@Test
	@Ignore
	public static void testUpdateEmployeeLaborLevels() {
		System.out.println("updated "+mEmpMgr.updateEmployeeLaborLevels(101, "01,02,03,04")+" record ");
	}

	@Test
	@Ignore
	public static void testDeleteEmployeeById() {
		int res = mEmpMgr.deleteEmployeeById(101);
		System.out.println("Deleted "+res+" record 101");
	}

	@Test
	@Ignore
	public static void testGetEmployeeLaborLevelsById() {
		System.out.println("LaborLevels for employee 101 is : "+mEmpMgr.getEmployeeLaborLevelsById(101));
	}

	@Test
	@Ignore
	public static void testGetEmployeeNameById() {
		System.out.println("Employee #101 name is: "+mEmpMgr.getEmployeeNameById(101));
	}


}
