package com.excep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		//this is an example of a checked exception
		try {
			FileInputStream fis = new FileInputStream("apple.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				myMethod();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	static void myMethod() throws NumberFormatException{
		Scanner scanner = new Scanner(System.in);
		String a = null;
		String b = null;
		int c = 0;
		//example of unchecked exception (compiler doesn't force u to use try/catch or throws statement)
		try {
			System.out.println("a = ");
			a = scanner.nextLine();
			System.out.println("b = ");
			b = scanner.nextLine();
			c = Integer.parseInt(a)/Integer.parseInt(b);
			System.out.println("a/b="+c);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}catch(Exception e){
			throw new NumberFormatException();
		}finally{
			System.out.println("Finally executed");
		}
		System.out.println("Program ended successfully");
		scanner.close();
	}

}
