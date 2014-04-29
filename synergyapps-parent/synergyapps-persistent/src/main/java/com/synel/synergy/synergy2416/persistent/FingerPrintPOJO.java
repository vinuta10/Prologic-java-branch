package com.synel.synergy.synergy2416.persistent;

public class FingerPrintPOJO {
	
    private int userId; //foreign key to employee table id
    private int fingerNum; //together with userId form a unique key combo
    private String template; //base64 encoded finger print data
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
	 * @return the fingerNum
	 */
	public int getFingerNum() {
		return fingerNum;
	}
	/**
	 * @param fingerNum the fingerNum to set
	 */
	public void setFingerNum(int fingerNum) {
		this.fingerNum = fingerNum;
	}
	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}
	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
	@Override
	public String toString(){
		return "UID: "+userId+" FingerNumber: "+fingerNum+" Template: "+template;
	}
}
