package com.synel.synergy.synergy2416.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

public class HbmTestEmployeeDaoUnitTest extends TestCase {
	private TestEmployee emp;
	private TestEmployeeDao empDao;

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	public void testSaveEmployee() {
		emp = new TestEmployee();
		empDao = new HbmTestEmployeeDao();
		emp.setFirstName("John");
		emp.setLastName("Doe");
		emp.setSalary(50000);
		empDao.saveEmployee(emp);
		System.out.println("BEFORE: Empolyee Salary: "+emp.getSalary()+" Last Name: "+emp.getLastName() + " First Name: "+emp.getFirstName());
		emp = empDao.findEmployeeById(0);
		System.out.println("Employee 0: "+emp.getFirstName()+"saved!");
		
	}

	public void testSaveEmployeeBatch() {
		List<TestEmployee> emps= new ArrayList<TestEmployee>();
		for(int i=0; i<100000; i++){
			emp = new TestEmployee();
			emp.setFirstName("John"+i);
			emp.setLastName("Doe"+i);
			emp.setSalary(50000+i);
			emps.add(emp);
		}
		empDao = new HbmTestEmployeeDao();
		empDao.saveEmployeeBatch(emps);
	}

	public void testGetEmployeeList() {
		List<TestEmployee> emps = new ArrayList<TestEmployee>();
		emps = empDao.getEmployeeList();
		printEmpList(emps);
	}

	public void testGetEmployeeByName() {
		emp = new TestEmployee();
		empDao = new HbmTestEmployeeDao();
		emp = empDao.getEmployeeByName("John");
		System.out.println("Empolyee Salary: "+emp.getSalary()+" Last Name: "+emp.getLastName() + " First Name: "+emp.getFirstName());
	}
	
	private void printEmpList(List<TestEmployee> emps) {
		for (Iterator<TestEmployee> iterator = 
				emps.iterator(); iterator.hasNext();){
			emp = (TestEmployee) iterator.next(); 
			System.out.print("First Name: " + emp.getFirstName()); 
			System.out.print("  Last Name: " + emp.getLastName()); 
			System.out.println("  Salary: " + emp.getSalary()); 
		}
	}

}
