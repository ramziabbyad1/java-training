package com.examples.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateApp4 {

	public static void main(String[] args) {
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("Ramzi Abbyad");
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(ssr);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
