package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface EmployeeDao {
	
	public EmployeePOJO findEmployeeById(int id);
	
	public EmployeePOJO findEmployeeByBadgeNumber(String badgenum);
	
	public EmployeePOJO findEmployeeByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByEmployeeNumber(String empNumber);
	
	public String getLaborLevelMapByBadgeNumber(String badgenum);
	
	public void saveEmployee(EmployeePOJO emp);
	
	public void saveEmployees(List<EmployeePOJO> emps);
	
	public List<EmployeePOJO> getEmployeeList();
	
	public int deleteEmployeeByBadgeNumber(String badgenum);
	
	public int deleteAllEmployees();

	public int getEmployeeCount();

	public int updateLaborLevelMapByBadgeNumber(String BadgeNumber, String llmap);

}
