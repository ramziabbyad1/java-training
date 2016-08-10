package com.examples;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDao {
	private SessionFactory sf;
	public BookDao(){
		sf = HibernateUtils.getSessionFactory();
	}
	public List<Book> getAllBooks(){
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from books");
		List<Book> books = q.list();
		tx.commit();
		sess.close();
		return books;
	}
}
