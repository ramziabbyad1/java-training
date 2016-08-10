package com.multithread;

public class Producer implements Runnable {
	Queue2 q;
	public Producer(Queue2 q){
		this.q = q;
		new Thread(this).start();
	}
	@Override
	public void run() {
		int i = 0;
			while(true){
					q.put(i++);
					
			}

	}

}
