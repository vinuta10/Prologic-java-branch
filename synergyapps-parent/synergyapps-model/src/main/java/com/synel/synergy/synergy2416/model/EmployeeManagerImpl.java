package com.synel.synergy.synergy2416.model;

import java.util.ArrayList;
import java.util.List;

import com.synel.synergy.synergy2416.persistent.EmployeeDao;
import com.synel.synergy.synergy2416.persistent.EmployeePOJO;
import com.synel.synergy.synergy2416.persistent.HbmEmployeeDao;
import com.synel.synergy.synergy2416.webservices.SynergyWebServices;
import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;
import com.xacttime.Employee;


public class EmployeeManagerImpl implements EmployeeManager {
	
	private static EmployeeManagerImpl mInstance = null;
	
	private EmployeeDao empDao;
	private SynergyWebServiceApi mSws;
	private List<EmployeePOJO> mEmps;
	
	//implement the "radio station to signal the db ready status
	//
	
	private EmployeeManagerImpl(){
		//initialize variables and start the sync on class start up.
		empDao = new HbmEmployeeDao();
		mSws = new SynergyWebServices();
		mEmps = new ArrayList<EmployeePOJO>();
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
		// the caller shall do this in future thread and
		// check the future.get for result or error
		
		int res = -1;
		//Do it in Future thread example:
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		Future future = executorService.submit(new Callable(){
//		    public Object call() throws Exception {
//		        return mSws.getEmployees();
//		    }
//		});

		//System.out.println("future.get() = " + future.get().toString());
		try {
			mEmps = EntityMapUtility.mapToEmployeePOJOList(mSws.getEmployees());
		} catch (Exception ex){
			ex.printStackTrace();
			return -1;
		}
		empDao.saveEmployees(mEmps);
		res = 0;
		return res;
	}

	@Override
	public int getEmployeeCount() {
		return empDao.getEmployeeCount();
	}

	@Override
	public void updateEmployeeLaborLevels(int EmpId, String laborlevelmap) {
		empDao.updateLaborLevelMapByBadgeNumber(EmpId, laborlevelmap);
	}

	@Override
	public void deleteEmployeeById(int id) {
		//Id is badgenumber in this case.
		empDao.deleteEmployeeByBadgeNumber(id);
	}

	@Override
	public String getEmployeeLaborLevelsById(int id) {
		return empDao.getLaborLevelMapByBadgeNumber(id);
	}

	@Override
	public String getEmployeeNameById(int id) {
		return empDao.findEmployeeByBadgeNumber(id).getName();
	}
}
