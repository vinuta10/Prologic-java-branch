package com.synel.synergy.synergy2416.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersistentApp {
	
	public static void main(String[] args){
		testMasterSuites();
	}
	
	public static void testMasterSuites(){
		System.out.println("================== Begin test suite 1===================================");
		testSaveEmployee();
		System.out.println("================== Begin test suite 2===================================");
		testSaveEmployees();
		System.out.println("================== Begin test suite 3===================================");
		testGetEmployeeList();
		System.out.println("================== Begin test suite 4===================================");
		testFindEmployeeById();
		System.out.println("================== Begin test suite 5===================================");
		testFindEmployeeByBadgeNumber();
		System.out.println("================== Begin test suite 6===================================");
		testFindEmployeeByEmployeeNumber();
		System.out.println("================== Begin test suite 7===================================");
		testGetLaborLevelMapByEmployeeNumber();
		System.out.println("================== Begin test suite 8===================================");
		testGetLaborLevelMapByBadgeNumber();
		System.out.println("================== Begin test suite 9===================================");
		testUpdateLaborLevelMapByBadgeNumber();
		System.out.println("================== Begin test suite 10===================================");
		testGetLaborLevelMapByBadgeNumber();
		System.out.println("================== Begin test suite 11===================================");
		testGetEmployeeCount();
		System.out.println("================== Begin test suite 12===================================");
		testDeleteEmployeeByBadgeNumber();
		System.out.println("================== Begin test suite 13===================================");
		testGetEmployeeCount();
		System.out.println("================== Begin test suite 14===================================");
		testDeleteAllEmployees();
		System.out.println("================== Begin test suite 15===================================");
		testGetEmployeeCount();	
		System.out.println("================== End test suite ===================================");
	}

	
	public static void testSaveEmployee() {
		EmployeePOJO emp = new EmployeePOJO();
		emp.setId(1);
		emp.setBadgeNumber("100");
		emp.setEmployeeNumber("A100");
		emp.setName("John Doe");
		emp.setLaborLevelMap("02,04,06,08");
		EmployeeDao empDao = new HbmEmployeeDao();
		System.out.println("Saving employee: "+emp.getName());
		empDao.saveEmployee(emp);
		System.out.println("find this employee...");
		System.out.println("employee "+empDao.findEmployeeByBadgeNumber("100").toString()+" saved to Database.");
	}
	
	
	public static void testSaveEmployees() {
		List<EmployeePOJO> emps = new ArrayList<EmployeePOJO>();
		for(int i=2; i<1000; i++){
			EmployeePOJO emp = new EmployeePOJO();
			emp.setId(i);
			emp.setBadgeNumber(String.valueOf(i+100));
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

	
	public static void testGetEmployeeList() {
		List<EmployeePOJO> emps = new ArrayList<EmployeePOJO>();
		EmployeeDao empDao = new HbmEmployeeDao();
		emps = empDao.getEmployeeList();
		printList(emps);
	}
	
	
	public static void testFindEmployeeById() {
		EmployeeDao empDao = new HbmEmployeeDao();
		EmployeePOJO emp = empDao.findEmployeeById(1);
		if (emp != null){
			System.out.println(emp.toString());
		}else {
			System.out.println("employee not found!");
		}
	}

	
	public static void testFindEmployeeByBadgeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		EmployeePOJO emp = empDao.findEmployeeByBadgeNumber("100");
		if (emp != null){
			System.out.println(emp.toString());
		}else {
			System.out.println("employee not found!");
		}
	}

	
	public static void testFindEmployeeByEmployeeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		EmployeePOJO emp = empDao.findEmployeeByEmployeeNumber("A100");
		if (emp != null){
			System.out.println(emp.toString());
		}else {
			System.out.println("employee not found!");
		}
	}

	
	public static void testGetLaborLevelMapByEmployeeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		String llmap = empDao.getLaborLevelMapByEmployeeNumber("A100"); //TODO or is it the labor level detail descriptions
		if (llmap != null){
			System.out.println(llmap);
		}else {
			System.out.println("llmap not found!");
		}
	}

	
	public static void testGetLaborLevelMapByBadgeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		String llmap = empDao.getLaborLevelMapByBadgeNumber("100");
		if (llmap != null){
			System.out.println(llmap);
		}else {
			System.out.println("llmap not found!");
		}
	}
	
	
	public static void testDeleteEmployeeByBadgeNumber(){
		EmployeeDao empDao = new HbmEmployeeDao();
		int numOfRecords = empDao.deleteEmployeeByBadgeNumber("100");
		System.out.println("Deleted "+numOfRecords+" Record(s)!");
		//assertEquals(numOfRecords,1);
	}
	
	
	public static void testDeleteAllEmployees(){
		EmployeeDao empDao = new HbmEmployeeDao();
		System.out.println("Deleted "+empDao.deleteAllEmployees()+"records!");
	}
	
	
	public static void testGetEmployeeCount() {
		
		EmployeeDao empDao = new HbmEmployeeDao();
		int res = empDao.getEmployeeCount();
		System.out.println("Employee Count: "+res);
	}


	public static void testUpdateLaborLevelMapByBadgeNumber() {
		EmployeeDao empDao = new HbmEmployeeDao();
		int res = empDao.updateLaborLevelMapByBadgeNumber("100","01,03,04,05");
		System.out.println("updateResult: "+res);
	}
	
	private static void printList(List<EmployeePOJO> emps) {
		for (Iterator<EmployeePOJO> iterator = 
				emps.iterator(); iterator.hasNext();){
			System.out.println(iterator.next().toString()); 
		}
	}
}
