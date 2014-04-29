package com.synel.synergy.synergy2416.persistent;

import com.xacttime.Fingerprint;

/*
 *    @XmlElement(name = "UserId")
    protected int userId;
    @XmlElement(name = "Template")
    protected String template;
 */

public interface FingerPrintDao {
	
	public Fingerprint getFingerprintbyUid(int uId);
	
	public void saveFingerprint(Fingerprint fp);
}
