package com.google.euler;

public class Problem2 {

	public static void main(String[] args) {
		int a_0 = 1;
		int a_1 = 2;
		int sum = a_1;
		while(a_1 <= 4e6){
			int temp = a_1;
			a_1 = a_1 + a_0;
			a_0 = temp;
			if(a_1 %2 == 0){
				if(a_1 <= 4e6){
					sum += a_1;
					System.out.println(a_1);
				}
			}
		}
			//System.out.println(2e6);
			int result = sum;
			System.out.println("Result : " + result);
	}

}
