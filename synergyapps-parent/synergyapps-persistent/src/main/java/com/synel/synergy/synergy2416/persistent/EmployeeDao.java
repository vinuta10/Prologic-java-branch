package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface EmployeeDao {
	
	public EmployeePOJO findEmployeeById(int id);
	
	public EmployeePOJO findEmployeeByBadgeNumber(int BadgeNumber);
	
	public EmployeePOJO findEmployeeByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByBadgeNumber(int BadgeNumber);
	
	public void saveEmployee(EmployeePOJO emp);
	
	public List<EmployeePOJO> getEmployeeList();
}
