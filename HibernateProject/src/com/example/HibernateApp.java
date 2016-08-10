package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.UserDetails;

public class HibernateApp {
	public static void main(String[] args) {
		UserDetails ud = new UserDetails();
		ud.setUserId(1);
		ud.setUserName("John Doe");
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
}
