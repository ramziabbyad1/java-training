package com.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtils;

public class InitEvents {

	public static void main(String[] args) {
		Event event = new Event();
		event.setName("Lollapalooza");
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 29);
		Date date = cal.getTime();
		System.out.println(cal);
		event.setStartDate(date);
		Location l = new Location("Barclays Center","132 Scholes Street Brooklyn,NY");
		event.setLocation(l);
		event.addSpeaker(new Speaker("Uncle Alber","123-456-7891"));
		event.addSpeaker(new Speaker("Uncle Albert2","124-556-6891"));
		Set<Speaker> test = new HashSet<>();
		test.add(new Speaker("Uncle Alber","123-456-7891"));
		test.add(new Speaker("Uncle Albert2","124-556-6891"));
		System.out.println("LOOK:" +event.getSpeakers());
		System.out.println("TEST:"+test);
		System.out.println("Helloooooo!");
		Set<Attendee> set1 = new HashSet<>();
		
		Attendee attendee1 = new Attendee("Santa Clause", "999-999-9999");
		Attendee attendee2 = new Attendee("Santa Clause2", "109-777-9999");
		Attendee attendee3 = new Attendee("Santa Clause3", "666-767-9696");
		set1.add(attendee1);
		set1.add(attendee2);
		set1.add(attendee3);
		System.out.println("set1: " +set1 );
		event.setAttendees(set1);
		
		Event event2 = new Event();
		event2.setName("Christmas Lecture");
		cal.set(Calendar.YEAR, 2222);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 26);
		event2.setStartDate(cal.getTime());
		event2.setLocation(l);
		event2.addSpeaker(new Speaker("Uncle Albert2","124-556-6891"));
		event2.addSpeaker(new Speaker("Uncle Albert4","222-101-6221"));
		Set<Attendee> set2 = new HashSet<>();
		set2.add(attendee1);
		set2.add(attendee3);
		event2.setAttendees(set2);
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		//Event event2 = (Event)session.get(Event.class, 14);
		//session.delete(event2);
		//session.(new Speaker("Uncle Alber","123-456-7891"));
		session.save(event);
		session.save(event2);
		
		tx.commit();
		session.flush();
		session.close();
		sf.close();
		
		

	}

}
