package com.synel.synergy.synergy2416.persistent;

import static org.junit.Assert.*;

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
	public void testFindEmployeeById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveEmployee() {
		EmployeePOJO emp = new EmployeePOJO();
		emp.setId(2);
		emp.setBadgeNumber(200);
		emp.setEmployeeNumber("A102");
		emp.setName("John Doe2");
		emp.setLaborLevelMap("02,04,06,08");
		EmployeeDao empDao = new HbmEmployeeDao();
		System.out.println("Saving employee: "+emp.getName());
		empDao.saveEmployee(emp);
		System.out.println("find this employee...");
		System.out.println("employee "+empDao.findEmployeeByBadgeNumber(200).getName()+"saved to Database.");
	}

	@Test
	public void testGetEmployeeList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeeByBadgeNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeeByEmployeeNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLaborLevelMapByEmployeeNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLaborLevelMapByBadgeNumber() {
		fail("Not yet implemented");
	}

}
