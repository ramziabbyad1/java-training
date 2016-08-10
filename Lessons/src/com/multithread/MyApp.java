package com.multithread;

public class MyApp {

	public static void main(String[] args) {
		Queue2 q = new Queue2();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		

	}

}
