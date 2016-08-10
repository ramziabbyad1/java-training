package com.google.euler;

public class Problem1 {

	public static void main(String[] args) {
		int mult1 = 3;
		int i = 1;
		int sum = 0;
		while(mult1 < 1000){
			if(mult1%5 != 0){
				System.out.println(mult1);
				sum += mult1;
			}
			if( mult1%5==0 && mult1%3 == 0){
				sum += mult1;
			}
		
			i++;
			mult1 = 3*i;
		}
		int mult2 = 5;
		int j = 1;
		while(mult2 < 1000){
			if(mult2%3 != 0){
				System.out.println(mult2);
				sum += mult2;
			}
			j++;
			mult2 = 5*j;
		}

		
		System.out.println("Result : " + sum);
	}

}
