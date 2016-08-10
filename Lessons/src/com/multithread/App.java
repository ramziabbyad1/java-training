package com.multithread;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread3 mt1 = new MyThread3();
		MyThread3 mt2 = new MyThread3();
		Thread t1 = new Thread(mt1, "Maintainence");
		Thread t2 = new Thread(mt2, "Report");
		//in this case report will finish last even though it has a higher priority because it calls sleep first.
		t2.setPriority(Thread.NORM_PRIORITY-1);
		t2.setPriority(Thread.NORM_PRIORITY+2);
		t1.start(); //could write t1.run() but in this case it wouldn't be multithreaded.  start calls the native run method on machine to start threads. new stacks for each thread.
		t2.start();
	}

}
