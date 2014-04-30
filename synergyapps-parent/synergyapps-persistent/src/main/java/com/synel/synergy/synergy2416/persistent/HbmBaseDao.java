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
	
	protected Session msession;
	protected static final int BATCH_NUM = 50;
	
	@SuppressWarnings("unchecked")
	protected Class<T> g() throws Exception {
		ParameterizedType superclass = (ParameterizedType)getClass().getGenericSuperclass();
		return (Class<T>) superclass.getActualTypeArguments()[0];
	}

	public Session getMySession() {
		return msession;
	}

	public void setMySession(Session msession) {
		this.msession = msession;
	}
	
	public void saveData(T data) {
		if (msession == null || !msession.isOpen()){
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
	
	public void saveDataList(List<T> lldata)
	{
		if (msession == null || !msession.isOpen()){
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
	public T getData(int id)
	{
		if (msession == null || !msession.isOpen()){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		T data = null;
		try {
			data = (T) msession.get(g(), id); //notice the difference between 'session.get' and 'session.load'
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			msession.close();
		}
		return data;
	}
	
}