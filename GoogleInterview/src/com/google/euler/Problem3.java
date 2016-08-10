package com.google.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Problem3 {

	public static void main(String[] args) {
		//List<Long> list = new ArrayList<>();
		long largest = 2;
		long num = 600851475143l;
		long i = 2;
		while(i < Math.sqrt(num)){
			if(num%i == 0){
				largest = i;
				num = num/i;
				i = 2;
			}
			i++;
		}
		//Set<Long> set = map.keySet();
		
		System.out.println("Largest prime factor : " + Math.max(largest, num));
		System.out.println(600851475143l/largest);

	}

}
