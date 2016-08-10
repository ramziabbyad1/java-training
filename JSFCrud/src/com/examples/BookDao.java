package com.examples;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookDao {
	private SessionFactory sf=null;
	public BookDao(){
		sf = HibernateUtils.getSessionFactory();
	}
	public List<Book> getAllBooks() {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Query q = sess.createQuery("from Book");
		List<Book> books = q.list();
		sess.getTransaction().commit();
		sess.close();
		return books;
	}
	public void addBook(Book book) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.flush();
		sess.save(book);
		sess.getTransaction().commit();
		sess.close();
	}

}
