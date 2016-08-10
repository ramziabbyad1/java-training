package com.google.euler;

public class Problem7 {

	public static void main(String[] args) {
		int i = 2;
		boolean flag = false;
		int prime = 0;
		int primeCount = 1;
		while(i < Double.POSITIVE_INFINITY && primeCount <= 10001){
			for(int j = 2; j <= Math.sqrt(i); j++){
				if(i%j == 0){
					flag = false;
					break;
				}
				else{
					flag = true;
					
				}
			}
			if(flag || i==3){
				primeCount++;
				prime = i;
				System.out.println("The " + primeCount+"th " + " prime is " +prime );
			}
			//System.out.println("The number being tested is " + i);
			i++;
			
			
		}

	}

}
