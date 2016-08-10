package com.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Queue2 {

		private AtomicInteger no = new AtomicInteger(0);
		//private int no;
		//boolean valueSet;
		public void put(int i){				
			no.set(i);
			//no = i;
			System.out.println("Put : " +no.get());
			//System.out.println("Put : " +no);
		}
		public int get() {
			System.out.println("Got : " + no.get());
			return no.get();
			//System.out.println("Got : " + no);
			//return no;
			
		}
}
