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
	
	public void saveEmployees(List<EmployeePOJO> emps){
		this.saveDataList(emps);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePOJO> getEmployeeList() {
		String hql = "FROM EmployeePOJO";
		return (List<EmployeePOJO>) HibernateUtilities.SelectQueryList(hql);
	}

	@Override
	public EmployeePOJO findEmployeeByBadgeNumber(int BadgeNumber) {
		String hql = "FROM EmployeePOJO where badgeNumber = "+BadgeNumber;
		List<?> res = HibernateUtilities.SelectQueryList(hql);
		return getEmployeeFromList(res);
	}

	@Override
	public EmployeePOJO findEmployeeByEmployeeNumber(String empNumber) {
		String hql = "FROM EmployeePOJO where employeeNumber = "+"\'"+empNumber+"\'";
		List<?> res = HibernateUtilities.SelectQueryList(hql);
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

	@Override
	public int deleteEmployeeByBadgeNumber(int BadgeNumber) {
		String hql = "delete from EmployeePOJO where badgeNumber = "+BadgeNumber;
		return HibernateUtilities.ExecUpdateQuery(hql);
	}

	@Override
	public int deleteAllEmployees() {
		String hql = "delete from EmployeePOJO";
		return HibernateUtilities.ExecUpdateQuery(hql);
	}
	
	private EmployeePOJO getEmployeeFromList(List<?> emps){
		EmployeePOJO emp = null;
		for (Iterator<?> iterator = 
					emps.iterator(); iterator.hasNext();){
				emp = (EmployeePOJO) iterator.next(); 
			}
		return emp;
	}

	@Override
	public int getEmployeeCount() {
		//TODO test
		int res = 0;
		String hql = "select count(e) from EmployeePOJO e";
		res = HibernateUtilities.SelectQueryUniqueInt(hql);
		return res;
	}

	@Override
	public int updateLaborLevelMapByBadgeNumber(int BadgeNumber, String llmap) {
		//TODO test
		int res = 0;
		String hql = "update EmployeePOJO e set e.laborlevelmap=llmap where e.badgeNumber = BadgeNumber";
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

}
