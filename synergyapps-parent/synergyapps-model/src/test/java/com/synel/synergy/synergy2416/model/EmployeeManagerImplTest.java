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
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployeeLaborLevels() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployeeById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeLaborLevelsById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeNameById() {
		fail("Not yet implemented");
	}

}
