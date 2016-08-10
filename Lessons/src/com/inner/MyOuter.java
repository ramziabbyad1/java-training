package com.inner;

public class MyOuter {
	static int a = 1000;
	static int b = 2000;
	//
	static class MyInner{
		private int i = 100;
		static int j = 200;
		void myInnerMethod1(){
			System.out.println("i = " + i);
			System.out.println("j = " + j);
			System.out.println("a = " + a);
			System.out.println("b = " + b);
		}
		static void myInnerMethod2(){
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
