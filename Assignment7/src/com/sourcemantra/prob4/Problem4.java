package com.sourcemantra.prob4;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Problem4 {

	public static void main(String[] args) {
		Setup s = new Setup();
		s.main();

	}

}

class Producer implements Runnable {
	   private final BlockingQueue<Double> queue;
	   Producer(BlockingQueue<Double> q) { queue = q; }
	   public void run() {
	     try {
	       while (true) { queue.put(produce()); }
	     } catch (InterruptedException ex) { ex.printStackTrace();}
	   }
	   double produce() {return 1000*Math.random();  }
	 }

	 class Consumer implements Runnable {
	   private final BlockingQueue<Double> queue;
	   Consumer(BlockingQueue<Double> q) { queue = q; }
	   public void run() {
	     try {
	       while (true) { consume(queue.take()); }
	     } catch (InterruptedException ex) { ex.printStackTrace();}
	   }
	   void consume(double x) { System.out.println("Mmm thanks for the delicious double, her is an int " +Math.ceil(x)); }
	   
	 }

	 class Setup {
	   void main() {
	     BlockingQueue<Double> q = new ArrayBlockingQueue<>(1024);
	     Producer p = new Producer(q);
	     Consumer c1 = new Consumer(q);
	     Consumer c2 = new Consumer(q);
	     new Thread(p).start();
	     new Thread(c1).start();
	     new Thread(c2).start();
	   }
	 }
