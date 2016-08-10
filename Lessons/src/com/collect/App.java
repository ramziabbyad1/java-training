package com.collect;

import com.oops.Employee;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGeneric<String> myGen1 = new MyGeneric<>();
		myGen1.setObj("Source Mantra");
		System.out.println(myGen1.getObj());
		myGen1.showType();
		
		MyGeneric<Integer> myGen2 = new MyGeneric<>();
		myGen2.setObj(100);
		System.out.println(myGen2.getObj());
		myGen2.showType();
		
		MyGeneric<Employee> myGen3 = new MyGeneric<>();
		myGen3.setObj(new Employee());
		System.out.println(myGen3.getObj());
		myGen3.showType();
		
		
		//Stats<String> stats1 = new Stats<>(); //won't compile
		Integer[] nums1 = {2, 8, 6, 4, 7, 3};
		Stats<Integer> stats1 = new Stats<>();
		stats1.setNums(nums1);
		double d = stats1.average();
		System.out.println("Average = " +d);
		
		Float[] fnums = {2.3f, 6.9f, 0.25f, 4.7f, 1.4f, 3.2f};
		Stats<Float> stats2 = new Stats<>();
		stats2.setNums(fnums);
		double d2 = stats2.average();
		System.out.println("Average= " + d2);
		
		
		
	}

}
