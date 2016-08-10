package com.sortedset;

import java.util.SortedSet;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private float salary;
	private SortedSet<Certificate> certificates;
	public Employee(){}
	public Employee(String firstName, String lastName, float salary, SortedSet<Certificate> certificates){
		this.firstName = firstName;
		this.lastName=  lastName;
		this.salary = salary;
		this.certificates = certificates;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public SortedSet<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(SortedSet<Certificate> certificates) {
		this.certificates = certificates;
	}
	
}
