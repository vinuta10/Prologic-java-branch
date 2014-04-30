package com.synel.synergy.synergy2416.persistent;

import java.util.List;

/*
 *    @XmlElement(name = "UserId")
    protected int userId;
    @XmlElement(name = "Template")
    protected String template;
 */

public interface FingerPrintDao {
	
	public FingerPrintPOJO getFingerprint(int uId, int fingerNum);
	
	public void saveFingerprint(FingerPrintPOJO fp);
	
	public void saveFingerprints(List<FingerPrintPOJO> fps);
}
