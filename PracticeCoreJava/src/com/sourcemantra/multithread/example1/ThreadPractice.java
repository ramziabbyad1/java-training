package com.sourcemantra.multithread.example1;

public class ThreadPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyThread1());
		Thread t2 = new Thread(new MyThread2());
		t1.start();	
		t2.start();
		
		
	}

}

class MyThread1 extends SuperThread implements Runnable{
	private static int count;
	private int even;
	private boolean ready = false;
	MyThread1(){
		super();
	}
	@Override
	public void run() {
		while(true){
			int count = getCount();
			if(count%2 == 0){
				System.out.println("Even: " + count);
			}
		}
		
	}
	
	public int getEven(){
		boolean isEven = false;
		while(!isEven){
			setCount();
			int count = getCount();
			if(count%2 == 0){
				even = count;
				isEven = true;
			}
		}
		return even;
	}

	public boolean isReady() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}	
}

class MyThread2 extends SuperThread implements Runnable{
	private static int count;
	private int odd;
	private boolean ready;
	MyThread2(){
		super();
	}
	@Override
	public void run() {
		while(true){
			int count = getCount();
			if(count%2 == 1){
				System.out.println("Odd: " + count);
			}
		}
	}
	
	public int getOdd(){
		return getCount();
	}

	public boolean isReady() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
}

class SuperThread{
	//make count atomic?
	private static int count = 0;
	SuperThread(){
		while(true){
			setCount();
		}
	}

	public static int getCount() {
		return count;
	}

	public static void setCount() {
		count++;
	}
	
}
