package com.google.euler;

import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger("100");
		for(int i =99; i >= 1; i--){
			bi = bi.multiply(new BigInteger(String.valueOf(i)));
		}
		System.out.println(bi);
		String bigN = bi.toString();
		System.out.println(bigN);
		long sum = 0;
		int stringLength = bigN.length();
		for(int i = 0; i < stringLength; i++){
			
			sum += Integer.parseInt(String.valueOf(bigN.charAt(i)));
			
		}
		System.out.println(sum);
		
	}
	

}
