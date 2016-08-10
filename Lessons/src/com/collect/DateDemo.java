package com.collect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		Date date2 = new Date(15364L);
		System.out.println(date2);
		
		Scanner scanner = new Scanner(System.in);
		
		Date d = null;
		String s = null;
		System.out.println("Enter Date (mm-dd-yyyy): ");
		s = scanner.nextLine();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		d = df.parse(s);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(dateFormat.format(d));
		System.out.println(d);
		DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(dateFormat2.format(d));
		
		scanner.close();
		
		
				

	}

}
