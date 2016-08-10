package com.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;





import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Attendee;
import com.entity.Event;
import com.entity.Location;
import com.entity.Speaker;
import com.util.HibernateUtils;

public class DetailsDao {
	private SessionFactory sf;
	public DetailsDao(){
		sf = HibernateUtils.getSessionFactory();
	}
	public int getAttendeesSize(int id){
		Set<Attendee> attendees = new HashSet<>();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Query q = sess.createSQLQuery("select a.id,a.name,a.telephone from attendee AS a JOIN event_attendee AS ea on a.id=attendee_id WHERE event_id=?");
		q.setInteger(0, id);
		List<?> l = q.list();
		int size = l.size();
		/*
		for(Object o:l){
			attendees.add((Attendee)o);
		}*/
		tx.commit();
		sess.close();
		return size;
	}
	public Set<Speaker> getSpeakers(int id){
		Set<Speaker> speakers = new HashSet<>();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Speaker where event_id=?");
		q.setInteger(0, id);
		List<?> l = q.list();
		for(Object o:l){
			
			speakers.add((Speaker)o);
		}
		tx.commit();
		sess.close();
		return speakers;
	}
	//get the event list then cast it back to event then you get use the get speakers function
	public Event getEvent(int id){
		Session session = sf.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Event result = (Event)session.get(Event.class, id);
		tx.commit();
		session.flush();
		session.close();
		return result;
	}
	public Location getLocation(int id){
		Session session = sf.openSession();
		Location result = null;
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			result = (Location)session.get(Location.class, id);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return result;
	}
	
}
