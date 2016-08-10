package com.multithread;

public class PrintCaller implements Runnable {
	MyPrinter target;
	String msg;
	Thread t;
	public PrintCaller(MyPrinter target, String msg, int p){
		this.target = target;
		this.msg = msg;
		t = new Thread(this);
		t.setPriority(p);
		t.start();
	}
	@Override
	public void run() {
		synchronized(target){
			target.print(msg);
		}
		
	}
	

}
