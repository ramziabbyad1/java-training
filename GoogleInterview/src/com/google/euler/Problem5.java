package com.google.euler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem5 {

	public static void main(String[] args) {
		int smallest = 1;
		int largestPossible = 1;
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for(int i =1; i <= 20; i++){
			for(int j = 1; j <= 20; j++){
				largestPossible = i*j;
				if(largestPossible <= 20){
					max = largestPossible;
				}else{
					set.add(max);
					break;
				}
			}
			
		}
		System.out.println(set);
		int answer = 1*2*2*2*2*3*3*5*7*11*13*17*19;
		System.out.println("Answer : " + answer);
		
		for(long i= 1; i <= 20; i++){
			long temp = answer%i;
			boolean divisible = temp==0;
			System.out.println("divisible by " + i + " " + divisible);
		}

	}

}
