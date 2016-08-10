package com.multithread;

public class MyThread1 extends Thread {
	public MyThread1(String string) {
		super(string);
	}

	@Override
	public void run(){
		try{
			for(int j =10; j >=1; j--){
				System.out.println("j= " + j +" : " + Thread.currentThread().getName());
				Thread.sleep(500);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +" finished executing.");
		
	}
}
