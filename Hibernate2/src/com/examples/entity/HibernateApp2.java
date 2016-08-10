package com.examples.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateApp2 {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("John Doe");
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(ssr);
		Session session = sf.openSession();
		session.beginTransaction();
		Employee e1 = (Employee) session.get(Employee.class,1);
		//session.save(emp);
		//session.getTransaction().commit();
		/*
		 * In this case hibernate only performs one query
		 * it does this buy saving this in the first level cache (i.e. session)
		 * */
		System.out.println("Name [e1]= " + e1.getName());
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Employee e2 = (Employee) session2.get(Employee.class,1);
		System.out.println("Name [e2] = " + e2.getName());
		session2.getTransaction().commit();
		session2.close();
		sf.close();
	}

}
