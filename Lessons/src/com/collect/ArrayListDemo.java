package com.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		//<E> is called diamond operator and is a property of generics.  note also collections store only 
		//objects not primitive types  
		ArrayList<String> arrList = new ArrayList<>(); //ArrayList<>() only works for >= JDK 1.7, otherwise use <String>() 
		System.out.println(arrList.size());
		arrList.add("One");
		arrList.add("Two");
		arrList.add("Four");
		System.out.println("size : "+arrList.size());
		System.out.println(arrList);
		arrList.add(2, "Three");
		System.out.println(arrList);
		//CRUD c-create/add r-retrieve u-update d-delete
		String s = arrList.get(1);
		System.out.println(s);
		arrList.set(3, "Fourty");
		System.out.println(arrList);
		arrList.remove(1);
		System.out.println(arrList);
		for(String str:arrList){
			System.out.print(str + " ");
		}
		System.out.println();
		Iterator<String> itr = arrList.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next() + " ");
		}
		System.out.println("------");
		//this type only available to ordered collection/ can only be done with ListIterator class (forward and backwards)
		ListIterator<String> listIterator = arrList.listIterator(arrList.size());
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
		
		System.out.println("before sorting");
		System.out.println(arrList);
		Collections.sort(arrList);
		System.out.println("after sorting");
		System.out.println(arrList);
		
		ArrayList<Integer> intArr = new ArrayList<>();
		intArr.add(25);  //auto-boxing, don't have to manually convert
		//intArr.add("Two"); //can't add different types
		//String s = (String) intArr.get(0); //can't do this
		int ss = intArr.get(0); //auto-unboxing
		
	}

}
