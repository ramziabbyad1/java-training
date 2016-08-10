package com.multithread;

public class TestApp {

	public static void main(String[] args) {
		MyPrinter target = new MyPrinter();
		PrintCaller obj1 = new PrintCaller(target, "Hello", 10);
		PrintCaller obj2 = new PrintCaller(target, "Source", 10);
		PrintCaller obj3 = new PrintCaller(target, "Mantra", 1);
	
	}

}
