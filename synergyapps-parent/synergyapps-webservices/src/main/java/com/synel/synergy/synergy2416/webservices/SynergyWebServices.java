package com.synel.synergy.synergy2416.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.synel.synergy.synergy2416.webservices.api.SynergyWebServiceApi;
import com.synel.synergy.synergy2416.system.SystemInformation;


public class SynergyWebServices implements SynergyWebServiceApi {
	
	private SynergySoapStub mSYservice;
	private SynergyLocator mloc;
	//private static SynergySoapProxy mssp = new SynergySoapProxy(); 
	private SynergySoap mPort;
	private String mWebServicesKey;
	private int mTerminalId;
	
	public SynergyWebServices ()
	{
		mWebServicesKey = SystemInformation.getWebServicesKey();
		mTerminalId = SystemInformation.getTerminalId();
		mloc =  new SynergyLocator();
		URL url = null;
		try {
			url = new URL(SystemInformation.getWebServiceEndPoint());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mPort=mloc.getSynergySoap(url);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mSYservice = (SynergySoapStub) mPort;
 	   	mSYservice.setTimeout(SystemInformation.getWebServicesTimeoutValue());
	}
	
	public int sendPunchRt(int userID, long transactionTimeEpoch,
			int punchNum, int[] lldetailIds) throws Exception {
		PunchData pd = new PunchData();
		pd.setUserId(userID);
		pd.setLaborLevelDetailIds(lldetailIds);
		pd.setPunchType(getPunchType(punchNum));
		pd.setTransactionTime(new DateTimeOffset());
		PunchStatus ps = mSYservice.recordPunch(mWebServicesKey, mTerminalId, pd);
		if (ps.isSuccess())
		{
			System.out.println("PunchData Send... "+ps.getMessage());
		}
		return ps.isSuccess()?0:-1;
	}

	private TimeSlicePreType getPunchType(int punchNum) {
		switch(punchNum){
    	case 1:
    		return TimeSlicePreType.ClockIn;
    	case 2:
    		return TimeSlicePreType.ClockOut;
    	case 3:
    		return TimeSlicePreType.StartBreak;
    	case 4:
    		return TimeSlicePreType.StartLunch;
    	case 5:
    		return TimeSlicePreType.EndBreak;
    	case 6:
    		return TimeSlicePreType.EndLunch;
    	case 7:
    		return TimeSlicePreType.PayAdjustment;
    	case 8:
    		return TimeSlicePreType.NonWork;
    	default:
    		return TimeSlicePreType.SwipeAndGo;
		}
	}

	public int sendPunchesBatch() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFingerPrints() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sendFingerPrint(long userID, int fingerNumber) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Employee> getEmployees(int deviceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LaborLevelDetail> getLaborLevelDetails() {
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

}

