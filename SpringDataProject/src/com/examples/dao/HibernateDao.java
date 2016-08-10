package com.examples.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDao {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public List<?> getAllBooks(){
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Book");
		List<?>listOfBooks = query.list();
		session.getTransaction().commit();
		session.close();
		return listOfBooks;
		
	}
	
	
}
