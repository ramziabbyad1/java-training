package com.multithread;

public class MyThread3 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(Thread.currentThread().getName().equals("Maintainence"))
			 maintainence();
		if(Thread.currentThread().getName().equals("Report"))
			report();
	}
	public void maintainence(){
		try{
			for(int j =10000; j >=1; j--){
				System.out.println("k= " + j +" : " + Thread.currentThread().getName() +" pri: " + Thread.currentThread().getPriority());
				Thread.sleep(1);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +" finished executing.");
	}
	public void report(){
		try{
			for(int j =10000; j >=1; j--){
				System.out.println("j= " + j +" : " + Thread.currentThread().getName()+" pri: " + Thread.currentThread().getPriority());
				Thread.sleep(1);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +" finished executing.");
	}

}
