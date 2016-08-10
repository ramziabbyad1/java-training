package com.sourcemantra;

public class Calculator {

	public static void main(String[] args) {
		//no return, no args
		//add must be static since 
		add();
		//add = 30
		//2) no return, with args
		sub(50, 25); //sub = 25
		//3) with return, no args
		int ans = multi(10,30);
		System.out.println("multi = " + ans);
		//4)with return, with args
		ans = div(10, 5);
		System.out.println("div = " + ans);

	}
	
	public static void add(){
		int first = 10;
		int second = 20;
		int ans = 10 + 20;
	}

}
