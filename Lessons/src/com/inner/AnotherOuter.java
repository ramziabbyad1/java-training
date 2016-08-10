package com.inner;

public class AnotherOuter {
	private int a = 1000;
	static int b = 2000;
	///note you cannot declare main in this inner class
	//no static methods allowed
	class AnotherInner{
		private int i = 100;
		//static memebers not allowed in an inner class
		//static int j = 200;
		void anotherMethod(){
			System.out.println("i = " + i);
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			abc();
		}
		
	}
	
	public static void main(String[] args) {
		/*AnotherOuter outer = new AnotherOuter();
		AnotherInner inner = outer.new AnotherInner();*/
		AnotherInner inner = new AnotherOuter().new AnotherInner();
		System.out.println("i = " + inner.i);
		inner.anotherMethod();
		
		
		}
	private void abc(){
		System.out.println("outer abc method");
	}

}
