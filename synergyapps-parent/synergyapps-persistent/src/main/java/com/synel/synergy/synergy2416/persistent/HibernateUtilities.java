package com.synel.synergy.synergy2416.persistent;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtilities {
	
	private static SessionFactory mSessionFactory;
	private static ServiceRegistry mServiceRegistry;
	private static Configuration mConf;
	private static Session msession;
	
	static 
	{
		try
		{
			mConf = new Configuration().configure();
			mServiceRegistry = new StandardServiceRegistryBuilder().applySettings(mConf.getProperties()).build();
			mSessionFactory = mConf.buildSessionFactory(mServiceRegistry);
			//createSchema();
		} catch (HibernateException ex) {
			System.out.println("Problem creating hibernate db session factory! "+ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return mSessionFactory;
	}
	
	public static List<?> SelectQueryList(String hql) {
		if (msession == null || !msession.isOpen()){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		List<?> results;
		Transaction tx = null;
		Query qry = msession.createQuery(hql);
		try {
			tx = msession.beginTransaction();
			results = qry.list();

		}catch (Exception ex){
			ex.printStackTrace();
			return null;
		}finally {
			msession.close();
		}
		tx.commit();
		return results;
	} 
	
	public static int SelectQueryUniqueInt(String hql) {
		if (msession == null || !msession.isOpen()){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		Query qry = msession.createQuery(hql);
		int res = -1;
		try {
			res = ((Number) qry.uniqueResult()).intValue();
		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			msession.close();
		}
		return res;
	}
	
	public static int ExecUpdateQuery(String hql) {
		if (msession == null || !msession.isOpen()){
			msession = HibernateUtilities.getSessionFactory().openSession();
		}
		int result;
		Transaction tx = null;
		Query qry = msession.createQuery(hql);
		try {
			tx = msession.beginTransaction();
			result = qry.executeUpdate();

		}catch (Exception ex){
			ex.printStackTrace();
			return -1;
		}finally {
			msession.close();
		}
		tx.commit();
		return result;
	}
	
	public static void createSchema(){
		//Session session = mSessionFactory.openSession();
		//create database schema if not exists:
		SchemaExport schema = new SchemaExport(mConf);
		schema.execute(false,true,false,true);
		//session.close();
	}
	
	public static void closeDbSession() {
		if (msession != null && msession.isOpen()) {
			msession.close();
		}
	}

}
