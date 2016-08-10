package com.list;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private float salary;
	private List<Certificate> certificates;
	public Employee(){}
	public Employee(String firstName, String lastName, float salary, List<Certificate> certificates){
		this.firstName = firstName;
		this.lastName=  lastName;
		this.salary = salary;
		this.certificates = certificates;
	}
	@Id
	@GeneratedValue
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "salary")
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@OneToMany
	public List<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}
	
}
