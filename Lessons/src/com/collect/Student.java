package com.collect;

import java.util.Comparator;

public class Student implements Comparable<Student>/*, Comparator<Student>*/{
	private String firstName;
	private String lastName;
	private int age;
	public Student(){}
	public Student(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}
	@Override
	public int compareTo(Student student) {
		return (this.age - student.age);
	}
/*	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	
}
