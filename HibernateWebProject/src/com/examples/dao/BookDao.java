package com.examples.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.examples.util.HibernateUtils;

public class BookDao {
	private SessionFactory sf;
	public BookDao(){
		sf = HibernateUtils.getSessionFactory();
	}
	public List<?> getAllBooks(){
		List<?> books = new ArrayList<>();
		Session session = sf.openSession();
		session.getTransaction();
		Query query = session.createQuery("from Books");
		books = query.list();
		session.getTransaction().commit();
		return books;
	}
}
