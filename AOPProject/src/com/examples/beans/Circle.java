package com.examples.beans;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void draw(){
		throw new RuntimeException();
	}
	
}
