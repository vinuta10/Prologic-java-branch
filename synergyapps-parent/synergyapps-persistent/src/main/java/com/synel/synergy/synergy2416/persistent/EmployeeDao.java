package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface EmployeeDao {
	
	public Employee findEmployeeById(int id);
	
	public Employee findEmployeeByBadgeNumber(int BadgeNumber);
	
	public Employee findEmployeeByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByBadgeNumber(int BadgeNumber);
	
	public void saveEmployee(Employee emp);
	
	public List<Employee> getEmployeeList();
}
