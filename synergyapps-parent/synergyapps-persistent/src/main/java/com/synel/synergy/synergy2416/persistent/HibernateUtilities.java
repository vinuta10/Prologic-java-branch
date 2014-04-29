package com.synel.synergy.synergy2416.persistent;

import org.hibernate.HibernateException;
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
	
	public static void createSchema(){
		//Session session = mSessionFactory.openSession();
		//create database schema if not exists:
		SchemaExport schema = new SchemaExport(mConf);
		schema.execute(false,true,false,true);
		//session.close();
	}

}
