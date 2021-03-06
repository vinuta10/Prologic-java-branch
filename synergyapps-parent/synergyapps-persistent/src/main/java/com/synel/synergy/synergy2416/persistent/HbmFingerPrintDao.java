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
		this.saveOrUpdateData(fp);
	}

	@Override
	public void saveFingerprints(List<FingerPrintPOJO> fps) {
		this.saveOrUpdateDataList(fps);
	}

	@Override
	public int updateFingerPrintTemplate(int uId, int fingerNum, String template) {
		
		int res = 0;
		String hql = "update FingerPrintPOJO f set f.template = "+"\'"+template+"\'"+" where f.userId = "+ uId +" and f.fingerNum = "+ fingerNum;
		System.out.println("updating..."+hql);
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@Override
	public int deleteFingerPrint(int uId, int fingerNum) {
		
		int res = 0;
		String hql = "delete FingerPrintPOJO f where f.userId = "+uId+" and f.fingerNum = "+ fingerNum;
		System.out.println("updating..."+hql);
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@Override
	public int deleteFingerPrints(int uId) {
	
		int res = 0;
		String hql = "delete FingerPrintPOJO f where f.userId = "+ uId;
		System.out.println("updating..."+hql);
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@Override
	public int getFingerPrintCount() {
	
		int res = 0;
		String hql = "select count(f) from FingerPrintPOJO f";
		res = HibernateUtilities.SelectQueryUniqueInt(hql);
		return res;
	}

	@Override
	public int updateFingerPrintSyncStatus(int uId, int fingerNum,
			boolean isSynced) {
		int res = -1;
		String hql = "update FingerPrintPOJO f set f.synced= "+"\'"+isSynced+"\'"+" where f.userId = "+uId+" and f.fingerNum = "+ fingerNum;
		System.out.println("now updating ..."+hql);
		res = HibernateUtilities.ExecUpdateQuery(hql);
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FingerPrintPOJO> getDirtyFingerPrints() {
		
		String hql = "from FingerPrintPOJO where synced = 'false' ";
		List<FingerPrintPOJO> res = (List<FingerPrintPOJO>)HibernateUtilities.SelectQueryList(hql);
		return res;
	}

	@Override
	public List<FingerPrintPOJO> getAllFingerPrints() {
		String hql = "from FingerPrintPOJO ";
		@SuppressWarnings("unchecked")
		List<FingerPrintPOJO> res = (List<FingerPrintPOJO>)HibernateUtilities.SelectQueryList(hql);
		return res;
	}
	
	//Private section
		private FingerPrintPOJO getFingerPrintFromList(List<?> res) {
			FingerPrintPOJO fp = null;
			for (Iterator<?> iterator = 
						res.iterator(); iterator.hasNext();){
					fp = (FingerPrintPOJO) iterator.next(); 
				}
			return fp;
		}
}
