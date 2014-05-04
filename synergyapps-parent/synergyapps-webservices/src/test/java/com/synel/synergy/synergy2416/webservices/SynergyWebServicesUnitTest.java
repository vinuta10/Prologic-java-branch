package com.synel.synergy.synergy2416.webservices;

import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import com.xacttime.ArrayOfInt;
import com.xacttime.ArrayOfLaborLevelDetail;
import com.xacttime.ArrayOfPunchData;
import com.xacttime.DateTimeOffset;
import com.xacttime.Employee;
import com.xacttime.Fingerprint;
import com.xacttime.LaborLevel;
import com.xacttime.LaborLevelDetail;
import com.xacttime.PunchData;
import com.xacttime.TimeSlicePreType;

public class SynergyWebServicesUnitTest extends TestCase {
	
	private SynergyWebServices mSws;
	private List<Fingerprint> mFps;
	private List<Employee> mEmps;
	private List<LaborLevel> mLLs;

	protected void setUp() throws Exception {
		super.setUp();
		mSws = new SynergyWebServices();
	}

	public void testSendPunchRt() {
		try {
			mSws.sendPunchRt(3,System.currentTimeMillis(), new Random().nextInt(5) , new int[] {12,11,16,9});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testSendPunchesBatch() {
		ArrayOfPunchData aopd = new ArrayOfPunchData();
		for(int i = 0; i<10000; i++){
			PunchData pd = new PunchData();
			Random rdg = new Random();
			pd.setUserId(rdg.nextInt(i+1));
			pd.setPunchType(getPunchType(i%9));
			pd.setTransactionTime(new DateTimeOffset(System.currentTimeMillis()));
			pd.setLaborLevelDetailIds(generateLLDetailIds(new int[] {rdg.nextInt(15),rdg.nextInt(15),rdg.nextInt(15), rdg.nextInt(15)}));
			System.out.println("punched: "+pd.getUserId()+" punchtype: "+pd.getPunchType()+" timestamp: "+pd.getTransactionTime().getMyepoch()+" llids: "+pd.getLaborLevelDetailIds().toString());
			aopd.getPunchData().add(pd);
		}
		System.out.println("sending "+aopd.getPunchData().size()+ " punchData ...");
		int res=-1;
		try {
			res = mSws.sendPunchesBatch(aopd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("punchBatch process result code: "+res);
	}

	public void testGetFingerPrints() {
		try {
			mFps = mSws.getFingerPrints();
			showFingerprints(mFps);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testSendFingerPrint() {
		mFps = mSws.getFingerPrints();
		int size = mFps.size();
		for(Fingerprint fp:mFps){
			mSws.sendFingerPrint(fp.getUserId()+size, fp.getTemplate());
		}
	}

	public void testGetEmployees() {
		try {
			mEmps = mSws.getEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showEmployees(mEmps);
	}

	public void testGetLaborLevel() {
		try {
			mLLs = mSws.getLaborLevels();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showLaborLevels(mLLs);
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
	
	private ArrayOfInt generateLLDetailIds(int[] lldetailIds){
		ArrayOfInt aoi = new ArrayOfInt();
		for(Integer i:lldetailIds){
			aoi.getInt().add(i);
		}
		return aoi;
	}
	
	private void showFingerprints(List<Fingerprint> aof) {
		
		for(Fingerprint fp:aof){
			System.out.println("UID: "+fp.getUserId()+" Template: "+fp.getTemplate());
		}
		
	}
	
	private void showEmployees(List<Employee> aoe) {
		for(Employee emp:aoe){
			System.out.println("Id: "+emp.getId()+" Name: "+emp.getName()+" BadgeNumber: "+emp.getBadgeNumber()+"EmployeeNumber: "+emp.getEmployeeNumber()+" LaborLevelMap: "+emp.getLaborLevelMap());
		}		
	}
	
	private void showLaborLevels(List<LaborLevel> aol) {
		for(LaborLevel ll:aol){
			List<LaborLevelDetail> llds = ll.getDetails().getLaborLevelDetail();
			System.out.println("Id: "+ll.getId()+" Name: "+ll.getName()+" Details: ");
			showLaborLevelDetails(llds);
		}		
	}

	private void showLaborLevelDetails(List<LaborLevelDetail> llds) {
		for(LaborLevelDetail ld:llds){
			System.out.println("LaborLevel : "+ld.getId()+" Code: "+ld.getCode()+ " Description: "+ld.getDescription());
		}
	}

}
