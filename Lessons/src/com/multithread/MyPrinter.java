package com.multithread;

public class MyPrinter {
	public /*synchronized*/ void print(String msg){
		System.out.print("["+msg);
		try {
			Thread.sleep(1000);
			System.out.print("]");
			//System.out.println();
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
