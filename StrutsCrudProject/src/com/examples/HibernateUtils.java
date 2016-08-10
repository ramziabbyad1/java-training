package com.examples;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		if(sf!=null) return sf;
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
		.applySettings(config.getProperties()).build();
				sf =config.buildSessionFactory(ssr);
		return sf;
	}
}
