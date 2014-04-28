package com.synel.synergy.synergy2416.persistent;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	
	private static SessionFactory mSessionFactory;
	private static ServiceRegistry mServiceRegistry;
	
	static 
	{
		try
		{
			Configuration conf = new Configuration().configure();
			mServiceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			mSessionFactory = conf.buildSessionFactory(mServiceRegistry);
		} catch (HibernateException ex) {
			System.out.println("Problem creating hibernate db session factory! "+ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return mSessionFactory;
	}

}
