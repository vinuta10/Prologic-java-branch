package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface EmployeeDao {
	
	public EmployeePOJO findEmployeeById(long id);
	
	public EmployeePOJO findEmployeeByBadgeNumber(int BadgeNumber);
	
	public EmployeePOJO findEmployeeByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByBadgeNumber(int BadgeNumber);
	
	public void saveEmployee(EmployeePOJO emp);
	
	public void saveEmployees(List<EmployeePOJO> emps);
	
	public List<EmployeePOJO> getEmployeeList();
	
	public int deleteEmployeeByBadgeNumber(int BadgeNumber);
	
	public int deleteAllEmployees();

	public int getEmployeeCount();

	public int updateLaborLevelMapByBadgeNumber(int BadgeNumber, String llmap);
}
