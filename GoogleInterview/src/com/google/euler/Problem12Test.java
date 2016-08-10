package com.google.euler;

import java.math.BigInteger;

public class Problem12Test {

	public static void main(String[] args) {
		/*BigInteger x= new BigInteger("31764223176");
		BigInteger y;
		y =x.add(x);
		System.out.println(y);*/
		int x = 105;
		int count = 0;
		for(int i =1; i <=x; i++){
			if(x%i == 0){
				count++;
				System.out.println(i);
			}
		}
		System.out.println(count);
	}

}
