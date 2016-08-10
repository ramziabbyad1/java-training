package com.sourcemantra.multithread.example1;

public class ThreadTest {

	public static void main(String[] args) {
		
		Thread t2 = new Thread("GoodBye"){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
				//super.run();
			}
		};
		Thread t1 = new Thread("Hello"){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t2.wait();
				System.out.println(Thread.currentThread().getName());
				//super.run();
			}
		};
		
		t1.start();
		//t1.start();

	}

}
