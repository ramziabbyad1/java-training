package com.inputoutput;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.oops.Employee;

public class DeserializeEmployee {

	public static void main(String[] args) {
		List<?> list = null;
		try(
				FileInputStream fis = new FileInputStream("emp.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				){
			list = (ArrayList<?>) ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee e = null;
		for(Object o:list){
			e = (Employee) o;
			System.out.println(e);
		}
	}

}
