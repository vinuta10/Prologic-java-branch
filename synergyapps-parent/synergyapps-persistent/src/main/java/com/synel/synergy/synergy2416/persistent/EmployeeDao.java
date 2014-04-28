package com.synel.synergy.synergy2416.persistent;

import java.util.List;

import com.xacttime.Employee;

public interface EmployeeDao {
	
	public Employee findEmployById(String uId);
	
	public int saveEmployee(Employee emp);
	
	public List<Employee> getEmployeeList();
}
