package com.synel.synergy.synergy2416.persistent;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This is the base class for the concrete Hibernate Data Access Object classes
 * @author chaol
 *
 */

public class HbmBaseDao<T> {
	
	protected static Session msession = HibernateUtilities.getSessionFactory().openSession() ;
	protected static final int BATCH_NUM = 42;
	
	@SuppressWarnings("unchecked")
	protected Class<T> g() throws Exception {
		ParameterizedType superclass = (ParameterizedType)getClass().getGenericSuperclass();
		return (Class<T>) superclass.getActualTypeArguments()[0];
	}

	public static Session getMySession() {
		return msession;
	}

	public static void setMySession(Session msession) {
		HbmBaseDao.msession = msession;
	}
	
	public <T> void saveData(T data) {
		if (msession == null){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		Transaction tx = null;
		try {
			tx = msession.beginTransaction();
			msession.save(data);
			msession.flush();
			msession.clear();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			ex.printStackTrace();
		} finally {
			msession.close();
		}
		return;	
	}
	
	public <T> void saveDataList(List<T> lldata)
	{
		if (msession == null){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		Transaction tx = null;
		try {
			tx = msession.beginTransaction();
			int i = 0;
			for(T data:lldata){
				msession.save(data);
				if (0 == ++i % BATCH_NUM) {
					msession.flush();
					msession.clear();
				}
			}
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) tx.rollback();
			ex.printStackTrace();
		} finally {
			msession.close();
		}
		return;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getData(int id)
	{
		if (msession == null){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		T data = null;
		try {
			data = (T) msession.load(g(), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}