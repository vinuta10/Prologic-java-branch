package com.synel.synergy.synergy2416.webservices;

import java.util.List;

import com.synel.synergy.synergy2416.system.SystemInformation;
import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;
import com.xacttime.ArrayOfEmployee;
import com.xacttime.ArrayOfFingerprint;
import com.xacttime.ArrayOfInt;
import com.xacttime.ArrayOfLaborLevel;
import com.xacttime.ArrayOfLaborLevelDetail;
import com.xacttime.ArrayOfPunchData;
import com.xacttime.ArrayOfPunchStatus;
import com.xacttime.DateTimeOffset;
import com.xacttime.Employee;
import com.xacttime.Fingerprint;
import com.xacttime.LaborLevel;
import com.xacttime.LaborLevelDetail;
import com.xacttime.PunchData;
import com.xacttime.PunchStatus;
import com.xacttime.SetFingerprintResponse;
import com.xacttime.Synergy;
import com.xacttime.SynergySoap;
import com.xacttime.TimeSlicePreType;


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
			int punchNum, int[] lldetailIds) {
		PunchData pd = new PunchData();
		pd.setUserId(userID);
		ArrayOfInt aoi = new ArrayOfInt();
		for(Integer i:lldetailIds){
			aoi.getInt().add(i);
		}
		pd.setLaborLevelDetailIds(aoi);
		pd.setPunchType(getPunchType(punchNum));
		pd.setTransactionTime(new DateTimeOffset(transactionTimeEpoch));
		System.out.println("Sending punch data realtime for terminalId: "+mTerminalId + " puchType: "+pd.getPunchType().toString());
		PunchStatus ps = mPort.recordPunch(mWebServicesKey, mTerminalId, pd);
		System.out.println(ps.toString());
		return ps.isSuccess()?0:-1;
	}

	public int sendPunchesBatch(ArrayOfPunchData aopd) {
		try{
			ArrayOfPunchStatus ps = mPort.recordPunches(mWebServicesKey, mTerminalId, aopd);
			System.out.println(ps.toString());
		}catch (Exception ex){
			return -1;
		}
		return 0;
	}

	public List<Fingerprint> getFingerPrints() {
		ArrayOfFingerprint aof;
		try {
			 aof = mPort.getFingerprints(mWebServicesKey, mTerminalId);
    	
		}catch (Exception ex) {
			return null;
		}
		return aof.getFingerprint();
	}

	public int sendFingerPrint(int userID, String fingerTemplate) {
		
		boolean success = false;
		Fingerprint fp = new Fingerprint();
		fp.setUserId(userID);
		fp.setTemplate(fingerTemplate);
		try{
			success = mPort.setFingerprint(mWebServicesKey,fp);
		}catch (Exception ex){
			return -1;
		}
		return success?0:-1;
	}

	public List<Employee> getEmployees() {
		
		try {
			ArrayOfEmployee aoe = mPort.getEmployees(mWebServicesKey, mTerminalId);
			showEmployees(aoe);
			return aoe.getEmployee();
		}catch (Exception ex) {
			return null;
		}
	}

	public List<LaborLevel> getLaborLevelDetails() {
		try{
			ArrayOfLaborLevel lld = mPort.getLaborLevels(mWebServicesKey);
			return lld.getLaborLevel();
		}catch (Exception ex) {
			return null;
		}
	}

	public int getServerTime() {
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
			System.out.println(" Id: "+emp.getId()+" BadgeNumber: "+emp.getBadgeNumber()+" EmpNo: "+emp.getEmployeeNumber()+" Name: "+emp.getName()+" LaborLevelDetails: "+emp.getLaborLevelMap());
			System.out.println("==================================");
		}
		
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

}

