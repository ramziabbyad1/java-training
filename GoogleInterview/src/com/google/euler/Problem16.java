package com.google.euler;

import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		//long l =(long) Math.pow(2, 100);
		BigInteger bn = new BigInteger("2");
		bn = bn.pow(1000);
		String big = bn.toString();
		long n = big.length();
		long sum = 0;
		for(int i = 0; i < n; i++){
			sum += Integer.parseInt(String.valueOf(big.charAt(i)));
		}
		System.out.println(sum);
		//BigNumber bn = BigNumber
	}

}
