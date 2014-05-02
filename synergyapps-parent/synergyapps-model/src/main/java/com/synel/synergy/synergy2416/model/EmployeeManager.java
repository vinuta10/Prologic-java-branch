package com.synel.synergy.synergy2416.model;

public interface EmployeeManager {
	
	/*
	 * This method can be run periodically to sync the Employee Data with the server
	 * or can be manually called to force the sync action.
	 * it is also called in the constructor to initialize the Employee data
	 * @return number of employees downloaded and saved to the persistence layer.
	 */
	public int syncEmployeesFromServer();
	
	//public int addEmployee(int uId,int BadgeNumber, String EmpNumber, String laborlevelmap);
	
	public int getEmployeeCount();
	
	public int updateEmployeeLaborLevels(int EmpId, String laborlevelmap);
	
	public int deleteEmployeeById(int badgenum);
	
	public String getEmployeeLaborLevelsById(int badgenum);
	
	public String getEmployeeNameById(int badgenum);

}
