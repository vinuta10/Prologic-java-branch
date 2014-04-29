package com.synel.synergy.synergy2416.model;

public interface EmployeeManager {
	
	public Integer addEmployee(int uId,int BadgeNumber, String EmpNumber, String laborlevelmap);
	
	public void listEmployees();
	
	public void updateEmployee(Integer EmpId, String laborlevelmap);
	
	public void deleteEmployee(Integer EmpId);
	
	public String getEmployeeLaborLevelsById(int id);
	
	/*
	 *    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "BadgeNumber")
    protected int badgeNumber;
    @XmlElement(name = "EmployeeNumber")
    protected String employeeNumber;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "LaborLevelMap")
    protected String laborLevelMap;
	 */

}
