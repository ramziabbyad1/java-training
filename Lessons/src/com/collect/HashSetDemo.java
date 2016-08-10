package com.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Collections;

public class HashSetDemo {

	public static void main(String[] args) {
		/*@SuppressWarnings("rawtypes")
		ArrayList arrList = new ArrayList();
		arrList.add("1");
		arrList.add(2);*/
		
		//doesn't maintain the insertion order
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("One");
		hashSet.add("Two");
		hashSet.add("Four");
		System.out.println("Size: " + hashSet.size());
		System.out.println(hashSet);
		hashSet.add("Three");
		hashSet.add("Five");
		System.out.println(hashSet);
		boolean b = hashSet.add("Four");
		System.out.println(hashSet);
		
		for(String s: hashSet){
			if(s.equals("Four")){
				System.out.println(s);
			}
		}
		
		//update set
		hashSet.remove("Four");
		System.out.println(hashSet);
		hashSet.add("Thirty");
		System.out.println(hashSet);
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//Collections.sort(hashSet);  //won't work
		
		//maintains the insertion order, however you can not insert at arbitrary locations, always insert at end
		//for this reason we say it is partially ordered.  Note also it is unsorted
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("orange");
		lhs.add("grapes");
		lhs.add("mango");
		lhs.add("watermelon");
		lhs.add("apple");
		
		System.out.println(lhs);
		
		TreeSet<String> ts = new TreeSet<>();
		ts.add("John");
		ts.add("Carol");
		
		
		System.out.println(ts);
		
		ts.add("Jane");
		ts.add("Brian");
		
		System.out.println(ts);
		

	}

}
