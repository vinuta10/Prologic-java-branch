package com.synel.synergy.synergy2416.persistent;

/*
 *    @XmlElement(name = "UserId")
    protected int userId;
    @XmlElement(name = "Template")
    protected String template;
 */

public interface FingerPrintDao {
	
	public FingerPrintPOJO getFingerprint(int uId, int fingerNum);
	
	public void saveFingerprint(FingerPrintPOJO fp);
}
