package com.example.manytomany;

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
		Address address1 =new Address("3601 Flamevine Cove","Austin", "TX", "78735");
		Address address2 =new Address("3601 Flamevine Cove","LALA", "NX", "12345");
		List<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);
		UserDetails ud1 = new UserDetails("Hala Abbyad", dob, addresses);
		
		
		Integer userId1 = mu.addUserDetails("Ramzi Abbyad", dob, addresses);
		
		
		List<Address> addresses2 = new ArrayList<>();
		addresses2.add(new Address("1029 October Lane", "Georgetown", "Washington D.C", "11206"));
		
		Integer userId2 = mu.addUserDetails("John Smith", dob,addresses2);
		UserDetails ud2 = new UserDetails("Carl Sanchez", dob, addresses2);
		List<UserDetails> users1= new ArrayList<>();
		users1.add(ud1);
		users1.add(ud2);
		address1.setUserDetails(users1);
		
		
		mu.listUserDetails();
	/*	Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Address a = (Address) session.get(Address.class, 1l);
		System.out.println("Address: " + a.getStreet());
		System.out.println("User : " + a.getUserDetails().getUserName());
		tx.commit();
		session.close();*/
		
		

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
			UserDetails ud = new UserDetails(userName, dob,addresses);
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
