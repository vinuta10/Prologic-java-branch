package com.synel.synergy.synergy2416.persistent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PunchDataPOJO {
	
	
    private int userId;
    
    private long transactionTime;
   
    private String punchType;
   
    private List<Integer> laborLevelDetailIds;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the transactionTime
	 */
	public long getTransactionTime() {
		return transactionTime;
	}

	/**
	 * @param transactionTime the transactionTime to set
	 */
	public void setTransactionTime(long transactionTime) {
		this.transactionTime = transactionTime;
	}

	/**
	 * @return the punchType
	 */
	public String getPunchType() {
		return punchType;
	}

	/**
	 * @param punchType the punchType to set
	 */
	public void setPunchType(String punchType) {
		this.punchType = punchType;
	}
	
	/**
	 * @return the laborLevelDetailIds
	 */
	public List<Integer> getLaborLevelDetailIds() {
		return laborLevelDetailIds;
	}

	/**
	 * @param laborLevelDetailIds the laborLevelDetailIds to set
	 */
	public void setLaborLevelDetailIds(List<Integer> laborLevelDetailIds) {
		this.laborLevelDetailIds=laborLevelDetailIds;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("UID: "+userId+" TransactionTime: "+Long.toString(transactionTime)+" PunchType: "+punchType);
//		if (laborLevelDetailIds != null){
//			sb.append("\nLaborLevelDetailIds: \n");
//			sb.append(laborLevelDetailIds);
//		}
		return sb.toString();
	}
}
