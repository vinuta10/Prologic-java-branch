package com.synel.synergy.synergy2416.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.joda.time.DateTime;

import com.synel.synergy.synergy2416.persistent.EmployeePOJO;
import com.synel.synergy.synergy2416.persistent.FingerPrintPOJO;
import com.synel.synergy.synergy2416.persistent.PunchDataPOJO;
import com.synel.synergy.synergy2416.persistent.TransactionDataPOJO;
import com.xacttime.ArrayOfInt;
import com.xacttime.DateTimeOffset;
import com.xacttime.Employee;
import com.xacttime.Fingerprint;
import com.xacttime.PunchData;
import com.xacttime.TimeSlicePreType;

/*
 * This is the utility class to convert Soap/Rest objects from the webservice
 * to the corresponding objects that we defined in the persistent layer
 * @author chaol
 * @TODO: using reflection to convert?
 * @TODO: consider using third party lib like Dozer or ModelMapper etc.(http://modelmapper.org/)
 */

public class EntityMapUtility {
	
	public static List<EmployeePOJO> mapToEmployeePOJOList(List<Employee> employees) {
		List<EmployeePOJO> dbEmps = new ArrayList<EmployeePOJO>();
		for (Employee emp:employees){
			dbEmps.add(mapToEmployeePOJO(emp));
		}
		return dbEmps;
	}
	
	public static EmployeePOJO mapToEmployeePOJO(Employee emp){
		EmployeePOJO dbEmp = new EmployeePOJO();
		dbEmp.setBadgeNumber(String.valueOf(emp.getBadgeNumber()));
		dbEmp.setEmployeeNumber(emp.getEmployeeNumber());
		dbEmp.setId(emp.getId());
		dbEmp.setName(emp.getName());
		dbEmp.setLaborLevelMap(emp.getLaborLevelMap());
		return dbEmp;
	}
	
	public static List<FingerPrintPOJO> mapToFingerPrintPOJOList(List<Fingerprint> fps) {
		List<FingerPrintPOJO> aofp = new ArrayList<FingerPrintPOJO>();
		for(Fingerprint fp:fps){
			aofp.add(mapToFingerPrintPOJO(fp));
		}
		return aofp;
	}
	
	public static FingerPrintPOJO mapToFingerPrintPOJO(Fingerprint fp){
		FingerPrintPOJO f = new FingerPrintPOJO();
		f.setUserId(fp.getUserId());
		f.setFingerNum(0);
		f.setTemplate(fp.getTemplate());
		return f;
	}
	
	public static List<PunchData> mapToPunchDataList(List<PunchDataPOJO> dbpds) {
		List<PunchData> aopd = new ArrayList<PunchData>();
		for(PunchDataPOJO dbpd:dbpds){
			aopd.add(mapToPunchData(dbpd));
		}
		return aopd;
	}
	
	public static PunchData mapToPunchData(PunchDataPOJO dbpd){
		PunchData pd = new PunchData();
		pd.setUserId(dbpd.getUserId());
	    pd.setPunchType(toPunchType(dbpd.getPunchType()));
		pd.setTransactionTime(toTransactionTime(dbpd.getTransactionTime()));
		pd.setLaborLevelDetailIds(toLaborLevelDetailIds(dbpd.getLaborLevelDetailIds()));
		return pd;
	}
	
	public static void updateFingerPrintPOJOStatusList(List<FingerPrintPOJO> fps,boolean isSync){
		//TODO test
		for(FingerPrintPOJO fp:fps){
			fp.setSynced(isSync);
		}
	}

	private static ArrayOfInt toLaborLevelDetailIds(
			List<Integer> laborLevelDetailIds) {
		ArrayOfInt aoi = new ArrayOfInt();
		for(Integer i:laborLevelDetailIds){
			aoi.getInt().add(i);
		}
		return aoi;
	}

	private static DateTimeOffset toTransactionTime(long transactionTime) {
		DateTimeOffset dtos = new DateTimeOffset();
		dtos.setMyTime(new DateTime(transactionTime));
		return dtos;
	}

	private static TimeSlicePreType toPunchType(String punchType) {
		return TimeSlicePreType.fromValue(punchType);
	}

	public static List<Fingerprint> mapToFingerPrintList(
			List<FingerPrintPOJO> dbfps) {
		List<Fingerprint> aofp = new ArrayList<Fingerprint>();
		for(FingerPrintPOJO dbfp:dbfps){
			aofp.add(mapToFingerPrint(dbfp));
		}
		return aofp;
	}
	
	public static Fingerprint mapToFingerPrint(FingerPrintPOJO dbfp){
		Fingerprint f = new Fingerprint();
		f.setUserId(dbfp.getUserId());
		f.setTemplate(dbfp.getTemplate());
		return f;
	}

	public static List<PunchData> mapToPunchDataListFromTransactionDataListPOJO(
			List<TransactionDataPOJO> mTds) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Integer> mapToLaborLevelDetailIds(
			String employeeLaborLevelsById) {
		List<Integer> llids = new ArrayList<Integer>();
		/*
		 * ==================================
 			Id: 2 BadgeNumber: 101 EmpNo: 101 Name: Alpha Zebra LaborLevelDetails: [1,2,*],[2,11,*],[3,16,*],[4,21,*],[5,26,*]
			==================================
			==================================
 			Id: 3 BadgeNumber: 102 EmpNo: 102 Name: Bravo Yoke LaborLevelDetails: [1,7,(2,7,31)],[2,11,(3,11)],[3,15,(4,15)],[4,19,(5,19)],[5,23,(6,23)]
		 */
		StringTokenizer st = new StringTokenizer(employeeLaborLevelsById,",");
	     while (st.hasMoreTokens()) {
	    	 String token = st.nextToken();
	         llids.add(Integer.parseInt(token));
	     }
		return llids;
	}

}
