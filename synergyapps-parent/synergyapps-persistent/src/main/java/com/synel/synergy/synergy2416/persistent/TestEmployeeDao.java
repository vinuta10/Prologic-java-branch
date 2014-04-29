package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface TestEmployeeDao {
	
	public TestEmployee findEmployeeById(int id);
	
	public void saveEmployee(TestEmployee emp);
	
	public void saveEmployeeBatch(List<TestEmployee> emps);
	
	public List<TestEmployee> getEmployeeList();
	
	public TestEmployee getEmployeeByName(String Name);

}
