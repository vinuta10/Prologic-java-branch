package com.synel.synergy.synergy2416.persistent;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HbmEmployeeDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveEmployee() {
		EmployeePOJO emp = new EmployeePOJO();
		emp.setId(1);
		emp.setBadgeNumber(100);
		emp.setEmployeeNumber("A100");
		emp.setName("John Doe");
		emp.setLaborLevelMap("02,04,06,08");
		EmployeeDao empDao = new HbmEmployeeDao();
		System.out.println("Saving employee: "+emp.getName());
		empDao.saveEmployee(emp);
		System.out.println("find this employee...");
		System.out.println("employee "+empDao.findEmployeeByBadgeNumber(100).toString()+" saved to Database.");
	}
	
	@Test
	public void testSaveEmployees() {
		List<EmployeePOJO> emps = new ArrayList<EmployeePOJO>();
		for(int i=2; i<1000; i++){
			EmployeePOJO emp = new EmployeePOJO();
			emp.setId(i);
			emp.setBadgeNumber(i+100);
			emp.setEmployeeNumber("P"+i*100+1);
			emp.setName("Peter Pan"+i);
			emp.setLaborLevelMap("00,01,02,03");
			emps.add(emp);
		}
		EmployeeDao empDao = new HbmEmployeeDao();
		empDao.saveEmployees(emps);
		//emps = empDao.getEmployeeList();
		//printList(emps);
	}

	@Test
	public void testGetEmployeeList() {
		List<EmployeePOJO> emps = new ArrayList<EmployeePOJO>();
		EmployeeDao empDao = new HbmEmployeeDao();
		emps = empDao.getEmployeeList();
		printList(emps);
	}
	
	@Test
	public void testFindEmployeeById() {
		EmployeeDao empDao = new HbmEmployeeDao();
		EmployeePOJO emp = empDao.findEmployeeById(1);
		assertNotNull(emp);
		System.out.println(emp.getName());
	}

	@Test
	public void testFindEmployeeByBadgeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		EmployeePOJO emp = empDao.findEmployeeByBadgeNumber(100);
		System.out.println(emp.toString());
	}

	@Test
	public void testFindEmployeeByEmployeeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		EmployeePOJO emp = empDao.findEmployeeByEmployeeNumber("A100");
		System.out.println(emp.toString());
	}

	@Test
	public void testGetLaborLevelMapByEmployeeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		String llmap = empDao.getLaborLevelMapByEmployeeNumber("A100");
		assertNotNull(llmap);
		//System.out.println(llmap);
	}

	@Test
	public void testGetLaborLevelMapByBadgeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		String llmap = empDao.getLaborLevelMapByBadgeNumber(100);
		assertNotNull(llmap);
		//System.out.println(llmap);
	}
	
	@Test
	public void testDeleteEmployeeByBadgeNumber(){
		EmployeeDao empDao = new HbmEmployeeDao();
		int numOfRecords = empDao.deleteEmployeeByBadgeNumber(101);
		System.out.println("Deleted "+numOfRecords+" Record(s)!");
		//assertEquals(numOfRecords,1);
	}
	
	@Test
	public void testDeleteAllEmployees(){
		EmployeeDao empDao = new HbmEmployeeDao();
		System.out.println("Deleted "+empDao.deleteAllEmployees()+"records!");
	}

	private void printList(List<EmployeePOJO> emps) {
		for (Iterator<EmployeePOJO> iterator = 
				emps.iterator(); iterator.hasNext();){
			System.out.println(iterator.next().toString()); 
		}
	}
}
