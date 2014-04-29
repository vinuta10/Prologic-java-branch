package com.synel.synergy.synergy2416.persistent;

import com.xacttime.Fingerprint;

public class HbmFingerPrintDao extends HbmBaseDao<Fingerprint> implements FingerPrintDao {

	@Override
	public Fingerprint getFingerprintbyUid(int uId) {
		return this.getData(uId);
	}

	@Override
	public void saveFingerprint(Fingerprint fp) {
		this.saveData(fp);
	}
}
