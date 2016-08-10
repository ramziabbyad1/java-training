package com.inputoutput;

import com.oops.Employee;

public class DemoClass {
	public static void main(String[] args){
		Employee john = new Employee(1, "John", 6000.0f, "Sales");
		System.out.println(john);
		Employee jane = (Employee) john.clone();
		System.out.println(jane);
		jane.setEmpID(2);
		jane.setName("Jane Doe");
		jane.setSalary(6000.0f);
		
		
	}
}
