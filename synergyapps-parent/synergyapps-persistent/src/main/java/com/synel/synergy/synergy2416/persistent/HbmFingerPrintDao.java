package com.synel.synergy.synergy2416.persistent;

import java.util.Iterator;
import java.util.List;

public class HbmFingerPrintDao extends HbmBaseDao<FingerPrintPOJO> implements FingerPrintDao {

	@Override
	public FingerPrintPOJO getFingerprint(int uId, int fingerNum) {
		String hql = "from FingerPrintPOJO where userId = "+uId+" and fingerNum = "+fingerNum;
		List<?> res = HibernateUtilities.SelectQuery(hql);
		return getFingerPrintFromList(res);
	}
	
	@Override
	public void saveFingerprint(FingerPrintPOJO fp) {
		this.saveData(fp);
	}

	@Override
	public void saveFingerprints(List<FingerPrintPOJO> fps) {
		this.saveDataList(fps);
	}
	
	private FingerPrintPOJO getFingerPrintFromList(List<?> res) {
		FingerPrintPOJO fp = null;
		for (Iterator<?> iterator = 
					res.iterator(); iterator.hasNext();){
				fp = (FingerPrintPOJO) iterator.next(); 
			}
		return fp;
	}
}
