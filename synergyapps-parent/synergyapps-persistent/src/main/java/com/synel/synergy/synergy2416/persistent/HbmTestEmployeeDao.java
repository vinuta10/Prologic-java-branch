package com.synel.synergy.synergy2416.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class HbmTestEmployeeDao extends HbmBaseDao<TestEmployee> implements TestEmployeeDao {

	@Override
	public void saveEmployee(TestEmployee emp) {
		this.saveData(emp);
	}

	@Override
	public void saveEmployeeBatch(List<TestEmployee> emps) {
		this.saveDataList(emps);	
	}
	
	@Override
	public TestEmployee findEmployeeById(int id) {
		return this.getData(id);
	}

	@Override
	public List<TestEmployee> getEmployeeList() {
		
		if (msession == null){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		Transaction tx = null;
		TestEmployee emp = null;
		List<TestEmployee> emps = new ArrayList<TestEmployee>();
		String hql = "FROM TestEmployee";
		System.out.println("Creating query...");
		Query qry = msession.createQuery(hql);
		System.out.println("Get all the employee from database...");
		try {
			tx = msession.beginTransaction();
			emps = qry.list();
			for (Iterator iterator = 
					emps.iterator(); iterator.hasNext();){
				emp = (TestEmployee) iterator.next(); 
				System.out.print("First Name: " + emp.getFirstName()); 
				System.out.print("  Last Name: " + emp.getLastName()); 
				System.out.println("  Salary: " + emp.getSalary()); 
			}

		}catch (Exception ex){
			ex.printStackTrace();
			return null;
		}
		tx.commit();
		return emps;
	}

	@Override
	public TestEmployee getEmployeeByName(String Name) {
		if (msession == null){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		Transaction tx = null;
		TestEmployee emp = null;
		String hql = "FROM TestEmployee E WHERE E.firstName = "+Name;
		Query qry = msession.createQuery(hql);
		try {
			tx = msession.beginTransaction();
			List emplist = qry.list();
			for (Iterator iterator = 
					emplist.iterator(); iterator.hasNext();){
				emp = (TestEmployee) iterator.next(); 
				System.out.print("First Name: " + emp.getFirstName()); 
				System.out.print("  Last Name: " + emp.getLastName()); 
				System.out.println("  Salary: " + emp.getSalary()); 
			}

		}catch (Exception ex){
			ex.printStackTrace();
			return null;
		}
		tx.commit();
		return emp;
	}
}
