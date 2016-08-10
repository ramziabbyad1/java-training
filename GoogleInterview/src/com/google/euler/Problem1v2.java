package com.google.euler;

public class Problem1v2 {

	public static void main(String[] args) {
		int mult = 0;
		int sum = 0;
		for(int i = 0; i < 1000; i++){
			if(i%3 == 0 || i%5 == 0){
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println("Result sum : " + sum);

	}

}
