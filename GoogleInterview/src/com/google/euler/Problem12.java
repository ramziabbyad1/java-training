package com.google.euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem12 {

	public static void main(String[] args) {
		int numDivisors = 2;
		BigInteger divisor = new BigInteger("1");
		BigInteger triangleNumber = new BigInteger("3");
		int i = 3;
		while(numDivisors < 500 && i < 15){
			numDivisors = 2;
			String iString = i+"";
			triangleNumber = triangleNumber.add(new BigInteger(iString));
			/*for(int j = 1; j <= Math.sqrt(triangleNumber); j++){
				if(triangleNumber%j == 0){
					numDivisors++;
				}
			}*/
			int j = 2;
			divisor = new BigInteger(triangleNumber.toString());
			/*Set<Integer> set = new HashSet<>();
			set.add(1);
			set.add(triangleNumber);*/
			String jString = j+"";
			BigInteger bigJ = new BigInteger(jString);
			//System.out.println("BigJ : " + bigJ);
			//System.out.println(sqrt(divisor));
			System.out.println();
			while(bigJ.compareTo(sqrt(divisor)) <= 0){
				jString = j+"";
				bigJ = new BigInteger(jString);
				if(divisor.mod(bigJ).equals(new BigInteger("0"))){
					//System.out.println("hello?");
					//set.add(j);
					divisor =new BigInteger(divisor.divide(bigJ).toString());
					System.out.print(divisor+ " ");
					//set.add(divisor);
					numDivisors+=2;
					j=2;
				}else{
					j++;
				}
			}
			System.out.println();

			//numDivisors = set.size();
			System.out.println("Triangle number : " + triangleNumber);
			System.out.println("Number divisors : " + numDivisors);
			i++;
		}
		
	}
	static BigInteger sqrt(BigInteger n) {
		  BigInteger a = BigInteger.ONE;
		  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		  while(b.compareTo(a) >= 0) {
		    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
		    if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
		    else a = mid.add(BigInteger.ONE);
		  }
		  return a.subtract(BigInteger.ONE);
	}

}
