package com.google.euler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem12v2 {

	public static void main(String[] args) {
		int numPrimeDivisors = 1;
		int numDivisors = 2;
		long divisor = 1;
		long triangleNumber1 = 0;
		long triangleNumber2 = 0;
		int i = 1;
		while(numDivisors <= 500){
			numPrimeDivisors = 1;
			if(i%2 == 0){
				triangleNumber1 = i/2;
				triangleNumber2 = (i+1);
			}else{
				triangleNumber1 = i;
				triangleNumber2 = (i+1)/2;
			}
			/*for(int j = 1; j <= Math.sqrt(triangleNumber); j++){
				if(triangleNumber%j == 0){
					numDivisors++;
				}
			}*/
			long j = 2;
			long[] tns = {triangleNumber1, triangleNumber2};
			Map<Long, Integer> map = new HashMap<>();
			for(long triangleNumber:tns){
				divisor = triangleNumber;
				/*Set<Integer> set = new HashSet<>();
				set.add(1);
				set.add(triangleNumber);*/
				//System.out.println("BigJ : " + bigJ);
				//System.out.println(sqrt(divisor));
				System.out.println();
				//System.out.print(j+ " ");
				//boolean prime = false;
				j=2;
				while(j <= Math.sqrt(divisor)){
	
					if(divisor%j == 0){
						int val = 1;
						if(map.containsKey(j)){
							val = map.get(j);
							val++;
						}
						map.put(j, val);
						//System.out.println("hello?");
						//set.add(j);
						divisor /= j;
						//for(int k = 0; k < Math.sqrt(divisor))
						//System.out.print(j+ " ");
						//set.add(divisor);
						//numPrimeDivisors++;
						j=2;
					}else{
						j++;
					}
				}
				int val = 1;
				if(map.containsKey(divisor)){
					val = map.get(divisor);
					val++;
				}
				map.put(divisor, val);
				//System.out.println();
				//numDivisors = set.size();
				//numDivisors =(int) Math.pow(2, numPrimeDivisors);
			}
			numDivisors = numDivisors(map);
			System.out.println("Triangle number1 : " + triangleNumber1);
			System.out.println("Triangle number2 : " + triangleNumber2);
			System.out.println(i+"'th Triangle number : " + triangleNumber1*triangleNumber2);
			System.out.println("Map : " + map);
			System.out.println("Num divisors : " + numDivisors);
			i++;
		}
		
	}
	
	static int numDivisors(Map<Long,Integer> m){
		//int size = m.size();
		int prod = 1;
		//int sum = 0;
		Iterator<Integer> iter = m.values().iterator();
		while(iter.hasNext()){
			int next = iter.next();
			prod *= (next+1);
			//sum += next;
		}
		System.out.println("Prod1 " + prod);
		//System.out.println("Sum " + sum);
		return prod;
	}

}
