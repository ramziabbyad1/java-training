package com.multithread;

public class ThreadDemo1 {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		MyThread1 t1 = new MyThread1("T1");
		t1.start();
		MyThread2 myThread2 = new MyThread2();
		//t1.setName("abc");
		Thread t2 = new Thread(myThread2, "T2");
		t2.start();
		System.out.println("T1 is alive: " + t1.isAlive());
		try{
			//Thread.currentThread().setName("source mantra");
			for(int i =1; i <= 10; i++){
				System.out.println("i= " + i + " " + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("T1 is alive: " + t1.isAlive());
		long end = System.currentTimeMillis();
		
		System.out.println("Program ended in " + (end-start) + " milisecs.");

	}

}
