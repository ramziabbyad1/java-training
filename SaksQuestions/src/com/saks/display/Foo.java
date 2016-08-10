package com.saks.display;

public class Foo {
	private int x;
	
	public static void main(String[] args) {
		Foo a = new Foo();
		Foo b = a;
		a.setX(5);
		b.setX(10);
		System.out.println(a.getX());
		System.out.println(b.getX());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
