package com.inner;

public class App {

	public static void main(String[] args) {
		MyOuter.MyInner inner = new MyOuter.MyInner();
		inner.myInnerMethod1();
		//doesn't work
		//inner.i
	}

}
