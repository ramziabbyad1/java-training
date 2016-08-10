package com.google.euler;

public class Problem10 {

	public static void main(String[] args) {
		boolean prime = false;
		long primeSum = 2+3;
		for(int i = 5; i < 2e6; i++){
			for(int j =2; j <= Math.sqrt(i); j++){
				if(i%j == 0){
					prime = false;
					break;
				}else{
					prime = true;
				}
			}
			if(prime){
				System.out.println("Prime : " + i);
				primeSum += i;
			}
		}
		System.out.println("Prime sum : " + primeSum);
	}

}
