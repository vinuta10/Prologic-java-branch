package com.synel.synergy.synergy2416.model;

import static org.junit.Assert.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeManagerImplTest {
	
	private EmployeeManager mEmpMgr = EmployeeManagerImpl.getInstance();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMasterSuite(){
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

	@Test
	public void testSyncEmployeesFromServer() {
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
	public void testGetEmployeeCount() {
		System.out.println("Employee Count: "+mEmpMgr.getEmployeeCount());
	}

	@Test
	public void testUpdateEmployeeLaborLevels() {
		System.out.println("updated "+mEmpMgr.updateEmployeeLaborLevels(101, "01,02,03,04")+" record ");
	}

	@Test
	public void testDeleteEmployeeById() {
		int res = mEmpMgr.deleteEmployeeById(101);
		System.out.println("Deleted "+res+" record 101");
	}

	@Test
	public void testGetEmployeeLaborLevelsById() {
		System.out.println("LaborLevels for employee 101 is : "+mEmpMgr.getEmployeeLaborLevelsById(101));
	}

	@Test
	public void testGetEmployeeNameById() {
		System.out.println("Employee #101 name is: "+mEmpMgr.getEmployeeNameById(101));
	}

}
