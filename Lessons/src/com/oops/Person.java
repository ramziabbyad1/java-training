package com.oops;

import java.io.Serializable;

public abstract class Person implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	public class Student {

		public class ArtStudent {

		}

	}
	private String name;
	protected int age;
	public String phone;
	public Person(){}
	//Note if you only keep this constructor the default constructor will not be called.
	//This is a problem because whenever you create a child object, the default constructor
	//of the parent object is called.  If no default constructor then it is an error.
	public Person(String name, int age, String phone){
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public Person(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString(){
		return getName() +" " +getAge() + " "+getPhone();
	}
	protected void xyz(){
		
	}
	//public void calcTax(); This won't work, use abstract instead.
	//public abstract void calcTax();
	public abstract void calcTax();

}
