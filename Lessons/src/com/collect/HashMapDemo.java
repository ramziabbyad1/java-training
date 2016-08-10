package com.collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(4, "Four");
		
		System.out.println(hm);
		
		//can only have one null key
		hm.put(null, "Three");
		System.out.println(hm);
		hm.put(null, "Five");
		System.out.println(hm);
		
		//can have as many null values as you want
		hm.put(3, null);
		hm.put(5, null);
		System.out.println(hm);
		
		String s = hm.get(4);
		System.out.println(s);
		
		hm.remove(2);
		System.out.println("Using foreach loop on hashMap");
		for(String str:hm.values()){
			System.out.println(str);
		}
		
		//can not go in both directions of the map, there is no ListIterator
		Iterator<String> itr = hm.values().iterator();
		System.out.println("Using iterator on hashMap");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		//Alternative method using keyset iterator, BEWARE of null pointer exceptions
		//Set<Integer> set = hm.keySet();
		Iterator<Integer> itr2 = hm.keySet().iterator();
		System.out.println("Null index:");
		System.out.println(hm.get(null));
		while(itr2.hasNext()){
			try{
				int key = itr2.next();
				System.out.println("Key: " + key);
				System.out.println(hm.get(key));
			}catch(NullPointerException e){
				System.out.println("Key: " + null);
				System.out.println(hm.get(null));
			}
		}
		
	}

}
