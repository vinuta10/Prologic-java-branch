package com.synel.synergy.synergy2416.model;

import java.util.ArrayList;
import java.util.List;

import com.synel.synergy.synergy2416.persistent.EmployeePOJO;
import com.synel.synergy.synergy2416.persistent.FingerPrintPOJO;
import com.synel.synergy.synergy2416.persistent.PunchDataPOJO;
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
		dbEmp.setBadgeNumber(emp.getBadgeNumber());
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
		dtos.setMyepoch(transactionTime);
		return dtos;
	}

	private static TimeSlicePreType toPunchType(String punchType) {
		return TimeSlicePreType.fromValue(punchType);
	}
}
