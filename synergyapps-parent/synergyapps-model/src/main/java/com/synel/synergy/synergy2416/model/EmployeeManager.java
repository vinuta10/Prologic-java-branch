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
	
	public int updateEmployeeLaborLevels(String badgenum, String laborlevelmap);
	
	public int deleteEmployeeById(String badgenum); //currently the Id is the "badgeNum string", we can add EmployeeNumber as Id or the key UID as search index
	
	public String getEmployeeLaborLevelsById(String badgenum);
	
	public String getEmployeeNameById(String badgenum);

	public int getuIdByBadgeNum(String badgeNum);

}
