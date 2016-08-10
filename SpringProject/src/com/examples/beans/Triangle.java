package com.examples.beans;

public class Triangle {
	private String name;
	private int height;
	private Point A;
	private Point B;
	private Point C;
	public Point getA() {
		return A;
	}
	public void setA(Point a) {
		A = a;
	}
	public Point getB() {
		return B;
	}
	public void setB(Point b) {
		B = b;
	}
	public Point getC() {
		return C;
	}
	public void setC(Point c) {
		C = c;
	}
	public Triangle(){System.out.println("1");}
	public Triangle(String name, int height){
		this.name = name;
		this.height = height;
		System.out.println("2");
	}
	public Triangle(String name){
		this.name=name;
		System.out.println("3");
	}
	public Triangle(int height){
		this.height=height;
		System.out.println("4");
	}
	public Triangle(Point A, Point B, Point C, int height, String name){
		this.A=A;
		this.B=B;
		this.C=C;
		this.height = height;
		this.name = name;
	}
	public void draw(){
		System.out.println(getName()+" triangle drawn with height "+getHeight()+ " points : " );
		System.out.println("Point A: " +getA().getX()+", "+getA().getY());
		System.out.println("Point B: " +getB().getX()+", "+getB().getY());
		System.out.println("Point C: " +getC().getX()+", "+getC().getY());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
