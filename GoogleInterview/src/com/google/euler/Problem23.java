package com.google.euler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem23 {
	private final static int MAX_SUM = 28124;

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		//int arr[] = int[10000];
		//int primes[] = int[10000];
		for(int i =0; i <= MAX_SUM; i++){
			list.add(i);
			//arr[i] = i;
			//primes[i] = i;
		}
		
		//List<Integer> primes = new LinkedList<>(list);
		
		//primesOf(primes);
		//list.removeAll(primes);
		//showList(primes);
		//primes.remove(0);
		//primes.remove(0);
		//nonPrimePowersOf(list, primes);
		List<Integer> sums = getPrimeSums(list);
		List<Integer> abundantNums = getAbunNums(sums,list);
		abundantNums.remove(0);
		//List<Integer> abunList = new LinkedList<>(abundantNums);
		//showList(abundantNums);
		Set<Integer> sumsOfTwo = getAllSumsOfTwo(abundantNums);
		//showList(sumsOfTwo);
		
		list.removeAll(sumsOfTwo);
		showList(list);
		int sum = getSum(list);
		
		System.out.println("Final sum : " + sum);
		
		//showList(list);
		//System.out.println("size of abundant numbers list : " + abundantNums.size());
		//showLists(sums, list);
		//Set<Integer> amicableNumbers = getAmics(sums,list);
		//System.out.println(amicableNumbers);
		//int sum = getSum(amicableNumbers);
		//System.out.println("final sum = " + sum);
		//System.out.println(list.size());
	}
	
	public static int getSum(List<Integer> list){
		int sum = 0;
		for(int i = 0; i < list.size(); i++)
			sum += list.get(i);
		return sum;
	}
	
	public static Set<Integer> getAllSumsOfTwo(List<Integer> abunNums){
		Set<Integer> sums = new HashSet<>();
		int size = abunNums.size();
		for(int i = 0; i < size; i++){
			int j = i;
			int abunNums_i = abunNums.get(i);
			int abunNums_j = abunNums.get(j);
			while(abunNums_i + abunNums_j <= MAX_SUM && j < size-1){
				sums.add( abunNums_i + abunNums_j);
				abunNums_j = abunNums.get(++j);
			}
		}
		
		return sums;
	}
	
	public static List<Integer> getAbunNums(List<Integer> sums, List<Integer> list){
		List<Integer> abunNums = new LinkedList<>();
		int sumSize= sums.size();
		int listSize= list.size();
		//System.out.println("sumsize = " + sumSize);
		//System.out.println("listsize = " + listSize);
		if(sumSize != listSize)	{System.out.println("Lists arent's the same size"); return null;}
		for(int i = 0; i < listSize; i++){
			int list_i = list.get(i);
			if(sums.get(i) > list_i){
				abunNums.add(list_i);
			}
		}
		
		return abunNums;
	}
	
	public static int getSum(Set<Integer> set){
		int sum = 0;
		for(int s:set){
			sum += s;
		}
		return sum;
	}
	public static Set<Integer> getAmics(List<Integer> sums, List<Integer> list){
		Set<Integer> amicableNums = new HashSet<>();
		int sumSize= sums.size();
		int listSize= list.size();
		System.out.println("sumsize = " + sumSize);
		System.out.println("listsize = " + listSize);
		if(sumSize != listSize)	{System.out.println("Lists arent's the same size"); return null;}
		for(int i = 0; i < sumSize; i++){
			Integer sum = sums.get(i);
			if(list.contains(sum)){
				int listIndex = list.indexOf(sum);
				//if(i < 300)
					//System.out.println("list contains sum = " + sums.get(i) +" i : " +i );
				if(sums.get(listIndex).equals(list.get(i)) && !sums.get(i).equals(list.get(i))){
					//System.out.println("sum = " + sums.get(i));
					//System.out.println("list = " + list.get(i));
					amicableNums.add(sums.get(i));
					amicableNums.add(list.get(i));
				}
			}
		}
		
		return amicableNums;
	}
	
	public static void showLists(List<Integer> sums, List<Integer> primes){
		int i = 0;
		for(Iterator<Integer> s = sums.iterator(), p = primes.iterator(); s.hasNext() && p.hasNext() && i < 300; i++){
			System.out.println("sum : " + s.next() + " number : " + p.next() +" i : " + i);
		}
	}
	
	public static Map<Integer,Integer> getPrimes(int num){
		Map<Integer,Integer> primes = new HashMap<>();
		int i = 2;
		int divisor = num;
		//System.out.println("number : " + num);
		while( i <= Math.sqrt(divisor)){
			if(divisor%i == 0){
				divisor /= i;
				if(primes.containsKey((Integer)i)){
					int power = primes.get(i);
					primes.put(i, ++power);
					//System.out.println("i : " + i);
					//System.out.println("power : " + power);
				}else{
					primes.put(i, 1);
					//System.out.println("i : " + i);
					//System.out.println("power : " + 1);
				}
				i=1;
			}
			i++;
		}
		if(primes.containsKey((Integer)divisor)){
			int power = primes.get(divisor);
			primes.put(divisor, ++power);
		}else{
			primes.put(divisor, 1);
		}
		//System.out.println("primes : "+ primes);
		
		return primes;
	}
	
	public static int divisor(int num){
		Map<Integer, Integer> primes = getPrimes(num);
		
		int prod = 1;
		int size = primes.size();
		Set<Integer> keys = primes.keySet();
		for(int k:keys){
			int sum = 0;
			for(int j = 0; j <= primes.get(k); j++){
				
				sum += Math.pow(k, j);
				//System.out.println("k : " + k + " j : "+j + " num : " + num +" sum : "+ sum);
			}
			
			prod *= sum;
			//System.out.println("product : " +prod);
		}
		prod -= num;
		//System.out.println("primes : " + primes);
		//System.out.println("prod : " + prod + " num : " + num);
		return prod;
	}
	
	public static List<Integer> getPrimeSums(List<Integer> list){
		List<Integer> sums = new LinkedList<>();
		int size = list.size();
		for(int i = 0; i < size; i++){
			sums.add(divisor(list.get(i)));
		}
		return sums;
	}
	
	public static void nonPrimePowersOf(List<Integer> list, List<Integer> primes){
		for(int i =0; i < primes.size(); i++){
			int power = 2;
			int iter = 0;
			while(iter <=  list.get(list.size()-1)){
				iter = (int)Math.pow(primes.get(i), power);
				//System.out.println("iter : " + iter +" pow : " + power + " prime : " + primes.get(i));
				power++;
				list.remove(new Integer(iter));
			}
		}
	}
	
	public static void primesOf(List<Integer> list){
		int size = list.size();
		int max = list.get(size-1);
		int currentElem = 2;
		int i = 2;
		while(i <= max/i){
			int factor = 2;
			while(i*factor <= max){
				
				list.remove(new Integer(i*factor));
				factor++;
			}
			i++;
		}
		
		
	}
	
	/*public static void primesOf(List<Integer> list){
		int start = list.get(2);
		int size = list.size();
		int max = list.get(size-1);
		int index = 1;
		List<Integer> factors = new LinkedList<>();
		for(int i =1; i <= max/2; i++)
			factors.add(i);
		while(start <= max/2){
			Iterator<Integer> iter = factors.iterator();
			while(iter.hasNext()){
				int next = iter.next();
				System.out.println("factor : " + next + " Start : " + start);
				System.out.println("Removed : " + next*start);
				System.out.println(start*next);
				list.remove(new Integer(start*next));
			}
			factors.remove(new Integer(start));
			start++;
			size = factors.size();
			max = factors.get(size-1);
		}
	}*/
	
	public static void getPrimes(int[] arr){
		//Iterator iter = list.iterator();
		//int start = list.get(2);
		//int size = list.size();
		//int max = list.get(size-1);
		int start = arr[2];
		int size = arr.length;
		int max = arr[size-1];
		int index = 1;
		while(start <= max/2){
			while(index*start < max){
				//System.out.println("Index : " + index + " Start : " + start);
				//System.out.println("Removed : " + arr[index*start]);
				//list.remove(index*start);
				index++;
				//max = 
				//max = list.get(list.size()-1);
			}
			//start = list.get(0);
			index = 1;
			//max = list.get(list.size()-1);
		}
	}
	
	public static void showList(List<Integer> list){
		for(Integer i:list){
			System.out.println(i);
		}
	}

}



