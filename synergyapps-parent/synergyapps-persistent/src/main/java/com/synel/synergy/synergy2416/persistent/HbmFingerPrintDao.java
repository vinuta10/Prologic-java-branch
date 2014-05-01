package com.synel.synergy.synergy2416.persistent;

import java.util.Iterator;
import java.util.List;

public class HbmFingerPrintDao extends HbmBaseDao<FingerPrintPOJO> implements FingerPrintDao {

	@Override
	public FingerPrintPOJO getFingerprint(int uId, int fingerNum) {
		String hql = "from FingerPrintPOJO where userId = "+uId+" and fingerNum = "+fingerNum;
		List<?> res = HibernateUtilities.SelectQueryList(hql);
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

	@Override
	public int updateFingerPrint(int uId, int fingerNum, String template) {
		//TODO test
		int res = 0;
		String hql = "update FingerPrintPOJO f set f.template=template where f.uId = uId and f.fingerNum = fingerNum";
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@Override
	public int deleteFingerPrint(int uId, int fingerNum) {
		//TODO test
		int res = 0;
		String hql = "delete FingerPrintPOJO f where f.uId = uId and f.fingerNum = fingerNum";
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@Override
	public int deleteFingerPrints(int uId) {
		//TODO test
		int res = 0;
		String hql = "delete FingerPrintPOJO f where f.uId = uId";
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@Override
	public int getFingerPrintCount() {
		//TODO test
		int res = 0;
		String hql = "select count(f) from FingerPrintPOJO f";
		res = HibernateUtilities.SelectQueryUniqueInt(hql);
		return res;
	}
}
