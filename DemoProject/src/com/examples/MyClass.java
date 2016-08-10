//no diamond operator is used because of jdk version 1.4  this class demonstrates difference between not using generics
package com.examples;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {
		ArrayList arrList = new ArrayList();
		arrList.add("One");
		arrList.add("Two");
		arrList.add(new Integer(25)); //not allowed 
		System.out.println(arrList);
		String s = (String) arrList.get(2);
		Integer ss = (Integer) arrList.get(2);
		int sss = ss.intValue();
		System.out.println(s);
	}

}
