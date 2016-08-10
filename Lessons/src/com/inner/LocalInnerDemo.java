package com.inner;

public class LocalInnerDemo {
	private int a = 1000;
	private int b = 2000;
	void myMethod(){
		final int i = 10;
		//such a class must always be declared default
		class MyLocal{		//LocalInnerDemo$1MyLocal.class 
			//the 1 represents the first copy of MyLocal, but there can also be other MyLocal declarations
			private int j = 100;
			//won't work
			//static int k = 200;
			void localMethod(){
				System.out.println("j = " + j);
				//i is out of scope
				System.out.println("i = " + i);
				System.out.println("a = " + a);
				System.out.println("b = " + b);
			}
			
		}
		MyLocal local = new MyLocal();
		local.localMethod();
	}
	
	public static void main(String[] args) {
		LocalInnerDemo local = new LocalInnerDemo();
		local.myMethod();
		local.local.localMethod();

	}

}
