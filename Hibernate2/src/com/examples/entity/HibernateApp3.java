package com.examples.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateApp3 {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("John Doe");
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(ssr);
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("Customers.byState");
		//Query query = session.getNamedQuery("Customers.byFirstName");
		//query.setString(0, "A%");
		query.setString(0, "PA");
		List<?> list = query.list();
		
		
		//session.getTransaction().commit();
		session.close();
		sf.close();
		System.out.println("Rows returned : " + list.size());
		Customers c = null;
		for(Object o:list){
			c = (Customers) o;
			System.out.println(c.getFirstName()+"\t"+c.getLastName()+"\t"+c.getState());
		}
		



	}

}
