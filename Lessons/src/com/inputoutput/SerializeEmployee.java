package com.inputoutput;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.oops.Employee;

public class SerializeEmployee {

	public static void main(String[] args) {
		Employee john = new Employee(1, "John Doe", 5000.0f, "Sales");
		Employee jane = new Employee(2, "Jane Doe", 6000.0f, "Purchase");
		Employee java = new Employee(3, "Java Guru", 7000.0f, "Admin");
		Employee neha = new Employee(4, "Neha Shah", 8000.0f, "IT"); //ENUM introduced in jdk1.5;
		Employee steffi = new Employee(5, "Steffi Smith", 8500.0f, "Administration");
		
		List<Employee> employees = new ArrayList<>();
		employees.add(john);
		employees.add(jane);
		employees.add(java);
		employees.add(neha);
		employees.add(steffi);
		
		try(
			FileOutputStream fos = new FileOutputStream("emp.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(employees);
			System.out.println("Employees serialized.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
