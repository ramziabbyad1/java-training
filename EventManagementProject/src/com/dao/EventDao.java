package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Event;
import com.util.HibernateUtils;

public class EventDao {
	private SessionFactory sf;
	public EventDao(){
		sf = HibernateUtils.getSessionFactory();
	}
	public List<?> getAllEvents(){
		List<?> list = new ArrayList<>();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from event");
		list = query.list();
		tx.commit();
		session.flush();
		session.close();
		return list;
	}
	
	
}
