package com.multithread;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		try{
			for(int j =100; j >=10; j-=10){
				System.out.println("k= " + j/10 +" : " + Thread.currentThread().getName());
				Thread.sleep(500);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +" finished executing.");

	}

}
