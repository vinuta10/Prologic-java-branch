package com.synel.synergy.synergy2416.persistent;

import java.util.Iterator;
import java.util.List;

public class HbmFingerPrintDao extends HbmBaseDao<FingerPrintPOJO> implements FingerPrintDao {

	@Override
	public FingerPrintPOJO getFingerprint(int uId, int fingerNum) {
		String hql = "FROM FingerPrintPOJO F WHERE F.uId = "+uId+" AND F.fingerNum = "+fingerNum;
		List<?> res = HibernateUtilities.SelectQuery(hql);
		return getFingerPrintFromList(res);
	}
	
	@Override
	public void saveFingerprint(FingerPrintPOJO fp) {
		this.saveData(fp);
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
