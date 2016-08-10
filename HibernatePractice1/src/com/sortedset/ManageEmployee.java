package com.sortedset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManageEmployee {
	private static SessionFactory factory;
	public static void main(String[] args) {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to build new session factory. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		ManageEmployee me = new ManageEmployee();
		SortedSet<Certificate> set1 = new TreeSet<>();
		set1.add(new Certificate("MBA"));
		set1.add(new Certificate("MBC"));
		set1.add(new Certificate("MBP"));
		Integer empID1 = me.addEmployee("John", "Doe", 12.16f, set1);
		SortedSet<Certificate> set2 = new TreeSet<>();
		set2.add(new Certificate("BA"));
		set2.add(new Certificate("BSc"));
		Integer empID2 = me.addEmployee("Jane", "Doe", 22.16f, set2);
		//Integer empID3 = me.addEmployee("Pete", "Celery", 32.16f);
		//Integer empID4 = me.addEmployee("Patricia", "Celery", 42.16f);
		
		me.listEmployees();
		
		me.updateEmployee(empID1, 60f);
		
		me.deleteEmployee(empID2);
		
		me.listEmployees();
	}
	
	public Integer addEmployee(String fname, String lname, float salary, SortedSet<Certificate> set){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeId = null;
		try{
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary, set);
			employeeId = (Integer) session.save(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx !=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employeeId;
		
	}

	public void listEmployees(){
		Session session = factory.openSession();
		Transaction tx =null;
		try{
			tx= session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			for(Iterator iterator=employees.iterator(); iterator.hasNext();){
				Employee employee = (Employee) iterator.next();
				Set<Certificate> set = employee.getCertificates();
				System.out.print("First name : " + employee.getFirstName());
				System.out.print(" Last name : " + employee.getLastName());
				System.out.println(" Salary : " +employee.getSalary());
				System.out.println("---Certificates---");
				for(Certificate c:set){
					System.out.println(c.getName());
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
	public void updateEmployee(Integer employeeId, float salary){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, employeeId);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)	tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	public void deleteEmployee(Integer employeeId){
		Session session=factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, employeeId);
			session.delete(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)	tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
