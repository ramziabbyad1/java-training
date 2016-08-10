package com.examples;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf=null;
	public static SessionFactory getSessionFactory(){
		if(sf!=null){
			return sf;
		}else{
			Configuration config = new Configuration().configure();
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
											.applySettings(config.getProperties()).build();
			sf = config.buildSessionFactory(ssr);
		}
		return sf;
	}
	
}
