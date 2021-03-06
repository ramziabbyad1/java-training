package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class ManageUsers {
	private static SessionFactory factory;
	private static StandardServiceRegistry ssr;
	public static void main(String[] args) throws ParseException {
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(ssr);
			 
		}catch(Throwable ex){
			System.err.println("Failed to build new session factory. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageUsers mu = new ManageUsers();
		//Calendar cal = Calendar.getInstance();
		//CalendarDate dob = new Date();
		////dob.g
		//dob.setTime(time);
		/*Date dob = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		try {
			dob = sdf.parse("1986-10-29");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Calendar cal = Calendar.getInstance();
		cal.set(1986, 9, 29);
		Date dob = cal.getTime();
		//Date dob = new D
		//Date dob = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		//dob = sdf.parse("1999-10-10");
		
		//dob = cal.getTime().getTime();
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address("3601 Flamevine Cove","Austin", "TX", "78735"));
		addresses.add(new Address("3610 Flamevine Cove","Sacramento", "CA", "78736"));
		
		Integer userId1 = mu.addUserDetails("Ramzi Abbyad", dob, addresses);
		
		
		List<Address> addresses2 = new ArrayList<>();
		addresses2.add(new Address("1029 October Lane", "Georgetown", "Washington D.C", "11206"));
		
		Integer userId2 = mu.addUserDetails("John Smith", dob,addresses2);
		
		mu.listUserDetails();
		
		

	}
	public void listUserDetails(){
		Session session = factory.openSession();
		Transaction tx =null;
		try{
			tx= session.beginTransaction();
			List uds = session.createQuery("FROM UserDetails").list();
			for(Iterator iterator=uds.iterator(); iterator.hasNext();){
				UserDetails ud = (UserDetails) iterator.next();
				List<Address> adds = ud.getAddresses();
				System.out.print("Name : " + ud.getUserName());
				System.out.println("---Addresses---");
				for(Address a:adds){
					System.out.println(a.getStreet()+"  "+a.getCity() +"  " + a.getState()+"  "+a.getZip());
				}
				
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public Integer addUserDetails(String userName, Date dob, List<Address> addresses){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userId = null;
		try{
			tx = session.beginTransaction();
			UserDetails ud = new UserDetails(userName, dob, addresses);
			userId = (Integer) session.save(ud);
			tx.commit();
		}catch(HibernateException e){
			if(tx !=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return userId;
		
	}


}
