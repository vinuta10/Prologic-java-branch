package com.synel.synergy.synergy2416.persistent;

import java.util.Iterator;
import java.util.List;

public class HbmEmployeeDao extends HbmBaseDao<EmployeePOJO> implements EmployeeDao {

	@Override
	public EmployeePOJO findEmployeeById(int id) {
		return this.getData(id);
	}

	@Override
	public void saveEmployee(EmployeePOJO emp) {
		this.saveData(emp);
	}

	@Override
	public List<EmployeePOJO> getEmployeeList() {
		return this.getEmployeeList();
	}

	@Override
	public EmployeePOJO findEmployeeByBadgeNumber(int BadgeNumber) {
		String hql = "FROM EmployeePOJO where badgeNumber = "+BadgeNumber;
		System.out.println("executing query: "+hql);
		List<?> res = HibernateUtilities.SelectQuery(hql);
		return getEmployeeFromList(res);
	}

	@Override
	public EmployeePOJO findEmployeeByEmployeeNumber(String empNumber) {
		String hql = "FROM EmployeePOJO where employeeNumber = "+empNumber;
		List<?> res = HibernateUtilities.SelectQuery(hql);
		return getEmployeeFromList(res);
		
	}

	@Override
	public String getLaborLevelMapByEmployeeNumber(String empNumber) {
		return findEmployeeByEmployeeNumber(empNumber).getLaborLevelMap();
	}

	@Override
	public String getLaborLevelMapByBadgeNumber(int BadgeNumber) {
		return findEmployeeByBadgeNumber(BadgeNumber).getLaborLevelMap();
	}
	
	private EmployeePOJO getEmployeeFromList(List<?> emps){
		EmployeePOJO emp = null;
		for (Iterator<?> iterator = 
					emps.iterator(); iterator.hasNext();){
				emp = (EmployeePOJO) iterator.next(); 
			}
		return emp;
	}

}
