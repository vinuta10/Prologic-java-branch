package com.synel.synergy.synergy2416.model;

import com.synel.synergy.synergy2416.persistent.EmployeeDao;
import com.synel.synergy.synergy2416.webservices.SynergyWebServices;


public class EmployeeManagerImpl implements EmployeeManager, Runnable{
	
	private static EmployeeManagerImpl mInstance = null;
	
	private EmployeeDao empDao;
	private SynergyWebServices mSws;
	
	private EmployeeManagerImpl(){
		//initialize variables and start the sync on class start up.
	} 
	
	public static EmployeeManagerImpl getInstance(){
		if(mInstance == null){
			mInstance = new EmployeeManagerImpl();
		}
		return mInstance;
	}

	@Override
	public int syncEmployeesFromServer() {
		// first download the employee data from the server
		// second save it in the persistent layer
		// send a signal slot when done.
		int res = 0;
		
		return res;
	}

	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateEmployeeLaborLevels(int EmpId, String laborlevelmap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEmployeeLaborLevelsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployeeNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
