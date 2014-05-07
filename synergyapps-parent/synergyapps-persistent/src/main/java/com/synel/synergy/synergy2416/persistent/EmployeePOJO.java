package com.synel.synergy.synergy2416.persistent;


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

public class EmployeePOJO {
	
	private int id;
	private String badgeNumber;
	private String employeeNumber;
	private String name;
	private String laborLevelMap;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the badgeNumber
	 */
	public String getBadgeNumber() {
		return badgeNumber;
	}
	/**
	 * @param badgeNumber the badgeNumber to set
	 */
	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}
	/**
	 * @return the employeeNumber
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the laborLevelMap
	 */
	public String getLaborLevelMap() {
		return laborLevelMap;
	}
	/**
	 * @param laborLevelMap the laborLevelMap to set
	 */
	public void setLaborLevelMap(String laborLevelMap) {
		this.laborLevelMap = laborLevelMap;
	}
	
	@Override
	public String toString(){
		return "Id: "+id+" Name: "+name+" BadgeNumber: "+badgeNumber+" EmployeeNumber: "+employeeNumber+" LaborLevelMap: "+laborLevelMap;
	}
	
}
