package com.multithread;

public class Consumer implements Runnable {
	Queue2 q;
	public Consumer(Queue2 q){
		this.q = q;
		new Thread(this).start();
	}
	@Override
	public void run() {
		
			while(true){
					q.get();
		
		}

	}

}
