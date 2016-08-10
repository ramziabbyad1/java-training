package com.inner;

public class AnonymousDemo {

	public static void main(String[] args) {
		Ball b = new Ball(){//AnonymousDemo$1.class

			@Override
			public void hitme() {
				System.out.println("You hit it.");
				
			}
			
		};
		b.hitme();
		new Thread(){//AnonymousDemo$2.class
			public void run() {
				System.out.println("run executed");
			};
		}.start();
		Runnable r = new Runnable(){

			@Override
			public void run() {
				System.out.println("Runnable run executed");
			}
			
		};
		Thread t = new Thread(r);
		t.start();
	}
	
	
}

interface Ball{
	void hitme();
}