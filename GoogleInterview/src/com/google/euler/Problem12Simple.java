package com.google.euler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem12Simple {
	final static BigInteger zero = new BigInteger("0");
	BigInteger z = BigInteger.ZERO;
	public static void main(String[] args) {
		BigInteger triangleNumber = new BigInteger("3");
		int numDivisors = 0;
		int i = 3;
		Map<Integer,Integer> map = new HashMap<>();
		while(numDivisors < 500){
			numDivisors = 0;
			BigInteger bi = new BigInteger(String.valueOf(i));
			triangleNumber = triangleNumber.add(bi);
			int j = 1;
			BigInteger bj = new BigInteger(String.valueOf(j));
			while(bj.compareTo(triangleNumber) <= 0){
				if(triangleNumber.mod(bj).equals(BigInteger.ZERO)){
					numDivisors++;
				}
				j++;
				bj = new BigInteger(String.valueOf(j));
			}
			//System.out.println("Triangle number : " + triangleNumber);
			//System.out.println("Number divisors : " + numDivisors);
			i++;
		}
		System.out.println("Triangle number : " + triangleNumber);

	}

}
