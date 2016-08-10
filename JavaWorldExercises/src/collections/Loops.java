package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Loops {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(){{
			add("one");
			add("two");
			add("three");
		}};
		System.out.println("list before");
		System.out.println(list);
		/*
		 * 
		for(String el: list){
			if(el.equals("one")) {
				list.remove(0);//runtime error!
			}
		}
		*/
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String next = it.next();
			if(next.equals("one")) {
				it.remove();//no error!
			}
		}
		System.out.println("list after remove");
		System.out.println(list);
		String one = "one";
		String one2 = "one";
		System.out.println("one == one ? " +(one == one2));
		String[] arrFromList = list.toArray(new String[0]);
		for(String s: arrFromList) {System.out.println(s);}
		List<Object> c = new ArrayList<>();
		c.add((Object)"two");
		c.add("three");
		System.out.println("c = "+c);
		System.out.println("list.containsAll(c) = "+list.containsAll(c));
		
	}

}
