package com.oops;



public class Employee extends Person implements MyInterface2, MyInterface1, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * If the ID has changed the receiving handler will not deserialize the object
	 */
	//private static final long serialVersionUID = 2L;
	private int empID;
	private String desig;
	private transient float salary;
	public Employee(){}
	public Employee(int empId, String desig, float salary){
		//super();
		this.empID = empId;
		this.desig = desig;
		this.salary = salary;
	}
	public Employee(int empId, String name, float salary, String desig){
		super(name);
		this.empID = empId;
		this.salary = salary;
		this.desig = desig;
	}
	public Employee(int empId, String desig, float salary, String name, int age, String phone){
		super(name, age, phone);
		this.empID = empId;
		this.desig = desig;
		this.salary = salary;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString(){
		return getEmpID() + " " + super.toString() + " " + getDesig();
	}
	//when you override a method in the subclass you cannot narrow down the visibility,
	//for instance changing to public will work but not changing to private
	
	@Override
	protected void xyz(){
		super.xyz();
	}
	@Override
	public void calcTax() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
