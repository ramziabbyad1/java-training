package com.examples.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.test.cache.infinispan.functional.Customer;

public class HibApp {

	public static void main(String[] args) {
		/*Employee emp = new Employee();
		emp.setName("John Doe");
		RegularEmployee remp = new RegularEmployee();
		remp.setName("John Doe");
		remp.setSalary(5000.0f);
		remp.setBonus(2000);
		
		ContractEmployee cemp = new ContractEmployee();
		cemp.setName("Java Guru");
		cemp.setPayPerHouse(40.0f);
		cemp.setContractPeriod("3 months");*/
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(ssr);
		Session session = sf.openSession();
		session.beginTransaction();
		/*session.save(emp);
		session.save(remp);
		session.save(cemp);*/
		//write the attribute name not column name
		//Query query = session.createQuery("select firstName, lastName, state, creditLimit from Customers where state='NJ'");
//		Query query = session.createQuery("select CAST(avg(creditLimit)) TO DECIMAL(7,2) from Customers");
	/*	Query query = session.createQuery("select firstName,lastName, creditLimit, state from Customers where"
				+ " customerId IN (select customerId from Customers group by state having max(creditLimit))");*/
		//SQLQuery sql = session.createQuery();
		//query.setString(0, "PA");
		DetachedCriteria maxCreditLimit = DetachedCriteria.forClass(Customers.class);
		
		List<?> list = query.list();
		//List<Object[]> objList = new ArrayList<>();
		//castList(objList,list);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("size : " + list.size());
		//homework display this from the list of list format
		//
		//System.out.println("Avg creditLimit : "+list.get(0));
		for(int i = 0; i < list.size(); i++){
			Object[] objArr = (Object[])list.get(i);
			for(Object o:objArr){
				String elem = String.valueOf(o);
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	/*	for(Object o: list){
			Object[] obj = (Object[]) o;
			String n = (String)
		}*/
		/*Customers c = null;
		for(Object o:list){
			c = (Customers) o;
			System.out.println(c.getFirstName()+"  " + c.getState());
		}*/
		

	}
	
	public static void castList(List<Object[]> objList, List<?> list){
		for(Object o:list){
			objList.add((Object[]) o);
		}
	}

}
