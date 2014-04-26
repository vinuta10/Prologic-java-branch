package com.synel.synergy.synergy2416.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;
import com.synel.synergy.synergy2416.system.SystemInformation;
import com.xacttime.*;


public class SynergyWebServices implements SynergyWebServiceApi {
	
	private Synergy mSYservice;
	private SynergySoap mPort;
	private String mWebServicesKey;
	private int mTerminalId;
	
	public SynergyWebServices ()
	{
		//Make a service
		mSYservice = new Synergy();
		// Use the service to get a stub which implements the SDI
		mPort = mSYservice.getSynergySoap();
		mWebServicesKey = SystemInformation.getWebServicesKey();
		mTerminalId = SystemInformation.getTerminalId();
	}
	
	public int sendPunchRt(int userID, long transactionTimeEpoch,
			int punchNum, int[] lldetailIds) throws Exception {
		com.xacttime.PunchData pd = new com.xacttime.PunchData();
		pd.setUserId(userID);
		ArrayOfInt aoi = new ArrayOfInt();
		for(Integer i:lldetailIds){
			aoi.getInt().add(i);
		}
		pd.setLaborLevelDetailIds(aoi);
		pd.setPunchType(getPunchType(punchNum));
		pd.setTransactionTime(new DateTimeOffset());
		PunchStatus ps = mPort.recordPunch(mWebServicesKey, mTerminalId, pd);
		if (ps.isSuccess())
		{
			System.out.println("PunchData Send... "+ps.getMessage());
		}
		return ps.isSuccess()?0:-1;
	}

	private TimeSlicePreType getPunchType(int punchNum) {
		switch(punchNum){
    	case 1:
    		return TimeSlicePreType.CLOCK_IN;
    	case 2:
    		return TimeSlicePreType.CLOCK_OUT;
    	case 3:
    		return TimeSlicePreType.START_BREAK;
    	case 4:
    		return TimeSlicePreType.START_LUNCH;
    	case 5:
    		return TimeSlicePreType.END_BREAK;
    	case 6:
    		return TimeSlicePreType.END_LUNCH;
    	case 7:
    		return TimeSlicePreType.PAY_ADJUSTMENT;
    	case 8:
    		return TimeSlicePreType.NON_WORK;
    	default:
    		return TimeSlicePreType.SWIPE_AND_GO;
		}
	}

	public int sendPunchesBatch() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFingerPrints() {
		ArrayOfFingerprint fps = new ArrayOfFingerprint();
		try {
    	fps = mPort.getFingerprints(mWebServicesKey, mTerminalId);
    	//save fps to the database using hibernate
    	
		}catch (Exception ex) {
			return -1;
		}
		return 0;
	}

	public int sendFingerPrint(long userID, int fingerNumber) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Employee> getEmployees(int deviceId) throws Exception {
		
		ArrayOfEmployee employees = new ArrayOfEmployee();
		
		employees = mPort.getEmployees(mWebServicesKey, mTerminalId);
		showEmployees(employees);
		return employees.getEmployee();
	}

	public List<LaborLevel> getLaborLevels() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getServerTime() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public String sendHeartBeat() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void showEmployees(ArrayOfEmployee employees) {
		for(Employee emp:employees.getEmployee()){
			System.out.println("==================================");
			System.out.println(emp.toString());
			System.out.println("==================================");
		}
		
	}

	public List<LaborLevelDetail> getLaborLevelDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}

