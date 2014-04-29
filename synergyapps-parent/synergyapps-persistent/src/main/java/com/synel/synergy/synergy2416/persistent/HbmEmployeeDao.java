package com.synel.synergy.synergy2416.persistent;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class HbmEmployeeDao extends HbmBaseDao<Employee> implements EmployeeDao {

	@Override
	public Employee findEmployeeById(int id) {
		return this.getData(id);
	}

	@Override
	public void saveEmployee(Employee emp) {
		this.saveData(emp);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return this.getEmployeeList();
	}

	@Override
	public Employee findEmployeeByBadgeNumber(int BadgeNumber) {
		String hql = "FROM Employee E WHERE E.badgeNumber = "+BadgeNumber;
		System.out.println("executing query: "+hql);
		List<?> res = QueryEmployee(hql);
		return getEmployeeFromList(res);
	}

	@Override
	public Employee findEmployeeByEmployeeNumber(String empNumber) {
		String hql = "FROM Employee E WHERE E.employeeNumber = "+empNumber;
		List<?> res = QueryEmployee(hql);
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
	
	private List<?> QueryEmployee(String hql) {
		if (msession == null || !msession.isOpen()){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		List<?> results;
		Transaction tx = null;
		System.out.println("before: creating query..."+hql);
		Query qry = msession.createQuery(hql);
		try {
			System.out.println("Try transaction...");
			tx = msession.beginTransaction();
			results = qry.list();

		}catch (Exception ex){
			ex.printStackTrace();
			return null;
		}
		tx.commit();
		return results;
	}
	
	private Employee getEmployeeFromList(List<?> emps){
		Employee emp = null;
		for (Iterator<?> iterator = 
					emps.iterator(); iterator.hasNext();){
				emp = (Employee) iterator.next(); 
			}
		return emp;
	}

}
