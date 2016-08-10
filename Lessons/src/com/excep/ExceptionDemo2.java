package com.excep;

import java.util.Scanner;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		
		try {
			myMethod();
		} catch (OddNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void myMethod() throws OddNumberException{
		Scanner scanner = new Scanner(System.in);
		int no = 0;
		System.out.println("Enter a positive even no :");
		no = scanner.nextInt();
		//System.out.println(no%2);
		if(no%2 == 1){
			throw new OddNumberException();
		}
		if(no < 0){
			throw new NegativeNumberException();
		}
		System.out.println("no = " + no);
	}

}

