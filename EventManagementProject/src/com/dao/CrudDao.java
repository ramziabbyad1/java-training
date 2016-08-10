package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Attendee;
import com.entity.Event;
import com.entity.Location;
import com.entity.Speaker;
import com.util.HibernateUtils;

public class CrudDao {
	private SessionFactory sf;
	public CrudDao(){
		sf = HibernateUtils.getSessionFactory();
	}
	//Merge Speaker(Add/update)
	//Merge Attendee(add/update)
	//Delete Speaker
	//Delete Attendee
	
	public void mergeAttendee(Attendee a, int id, int event_id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//System.out.println(s);
		//Query c
		//q.setInteger(0, id);
		//List<?> l = q.list();
		String aName  =a.getName();
		String aTel  =a.getTelephone();
		Query q = null;
		//q = session.createSQLQuery("select * from attendee where id=?");
		//q.setString(0, aName);
		//q.setString(1, aTel);
		//q.setInteger(0, id);
		
		//List<?> l = q.list();
		if(id<0){
			//if attendee not in table update both tables
			q = session.createSQLQuery("insert into attendee (name,telephone) values(?,?)");
			q.setString(0, aName);
			q.setString(1, aTel);
			q.executeUpdate();
			q = session.createSQLQuery("select id from attendee where name=? and telephone=?");
			q.setString(0, aName);
			q.setString(1, aTel);
			List<?> l2 = q.list();
			id = (Integer)l2.get(0);
			q = session.createSQLQuery("insert into event_attendee (event_id,attendee_id) values(?,?)");
			q.setInteger(0, event_id);
			q.setInteger(1, id);
			q.executeUpdate();
		}else{
			//attendee is in the table so need to check if pair is in event_attendee table
			q = session.createSQLQuery("select event_id, attendee_id from event_attendee where"
					+ " event_id=? and attendee_id=?");
			q.setInteger(0, event_id);
			q.setInteger(1, id);
			List<?> l2 = q.list();
			q = session.createSQLQuery("update attendee set name=?, telephone=? where id=?");
			q.setString(0, aName);
			q.setString(1, aTel);
			q.setInteger(2, id);
			q.executeUpdate();
			
			if(l2.isEmpty()){
				q = session.createSQLQuery("insert into event_attendee (event_id,attendee_id) values(?,?)");
				q.setInteger(0, event_id);
				q.setInteger(1, id);
				q.executeUpdate();
			}/*else{
				//attendee event pair already in event_attendee so just update that table
				q = session.createSQLQuery("update event_attendee set event_id=?, attendee_id=?");
				//Query q = session.createQuery("update speaker set name=?, telephone=?, event_id=? where id=?");
				q.setInteger(0, event_id);
				q.setInteger(1, id);
				q.executeUpdate();
			}*/
		}
		
		tx.commit();
		session.flush();
		session.close();
	}
	
	public void updateLocation(Location l, int event_id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Event e = (Event)session.get(Event.class, event_id);
		e.setLocation(l);
		session.update(e);
		tx.commit();
		session.flush();
		session.close();
	}
	
	public void mergeSpeaker(Speaker s, int id, int event_id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//System.out.println(s);
		//Query q = session.createSQLQuery("select id from speaker where id=?");
		//q.setInteger(0, id);
		//List<?> l = q.list();
		Query q = null;
		if(id < 0){
			q = session.createSQLQuery("insert into speaker (name,telephone,event_id) values(?,?,?)");
			q.setString(0, s.getName());
			q.setString(1, s.getTelephone());
			q.setInteger(2, event_id);
		}else{
			q = session.createSQLQuery("update speaker set name=?, telephone=?, event_id=? where id=?");
			//Query q = session.createQuery("update speaker set name=?, telephone=?, event_id=? where id=?");
			q.setString(0, s.getName());
			q.setString(1, s.getTelephone());
			q.setInteger(2, event_id);
			q.setInteger(3, id);
		}
		q.executeUpdate();
		tx.commit();
		session.flush();
		session.close();
	}
	
	public Speaker fetchSpeaker(Class<Speaker> c, int id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Speaker s = (Speaker)session.get(c, id);
		tx.commit();
		session.flush();
		session.close();
		return s;
	}
	public void deleteSpeaker(Class<Speaker> c, int id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Speaker s = (Speaker)session.get(c, id);
		//System.out.println("HELOLLLOOOOOOOOO?>>????");
		//System.out.println(s);
		session.delete(s);
		tx.commit();
		session.flush();
		session.close();
	}
	public Attendee fetchAttendee(Class<Attendee> c, int id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Attendee a = (Attendee)session.get(c, id);
		tx.commit();
		session.flush();
		session.close();
		return a;
	}
	public void deleteAttendee(int e_id, int a_id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Attendee a = (Attendee)session.get(Attendee.class, id);
		Query q = null;
		//Query q = session.createQuery("select count(id) from event_attendee where ");
		q = session.createSQLQuery("delete from event_attendee where event_id=? and attendee_id=?");
		q.setInteger(0, e_id);
		q.setInteger(1, a_id);
		q.executeUpdate();
		//e.getAttendees().remove(a);
		//session.update(e);
		//session.delete(a);
		tx.commit();
		session.flush();
		session.close();
	}
	
	public void mergeSpeaker(Object o){
		//int result = -1;
		Speaker s = (Speaker)o;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(s);
		tx.commit();
		session.flush();
		session.close();
		//return result;
	}
	public void mergeAttendee(Object o){
		//int result = 0;
		Attendee a = (Attendee)o;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(a);
		tx.commit();
		session.flush();
		session.close();
		//return result;
	}
}
