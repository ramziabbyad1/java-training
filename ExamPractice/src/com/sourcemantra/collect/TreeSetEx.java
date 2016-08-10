package com.sourcemantra.collect;

import java.util.ArrayDeque;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet<Integer> ts = new TreeSet<>();
		NavigableSet<Integer> ts2 = new TreeSet<>();
		ts.add(1);
		ts.add(-3);
		ts.add(20);
		ts.add(5);
		ts.add(3);
		
		ts.stream().forEach(e -> System.out.println(e));
		
		Queue<Integer> q = new ArrayDeque();
		q.r
	}

}
