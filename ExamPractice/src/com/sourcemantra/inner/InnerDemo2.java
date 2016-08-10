package com.sourcemantra.inner;

import java.util.ArrayList;
import java.util.List;

public class InnerDemo2 {

	public static void main(String[] args) {
		List<? super Quadrillateral> list = new ArrayList<>();
		Rectangle rect1 =  new Rectangle();
		Rectangle rect2 = new Rectangle();
		Rectangle rect3 = new Rectangle();
		System.out.println(rect1.area);
		//list.add(rect1);
		list.add(rect2);
		list.add(rect3);
		
		for(int i =0; i<2;i++){
			System.out.println(list.get(i));
		}
		
		Shape s = new Shape();
		Shape r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		List<Shape> l = new ArrayList<>();
		l.add(r1);
		l.add(s);
		l.add(r2);
		show(l);
		//show(l,1);
		//show(l,2);
		

	}
	
	public static <T> void show(List<T> list){
		//System.out.println(list.get(i).getClass());
		for(Object o:list){
			System.out.println(o);
		}
	}

}
class Shape{}

class Quadrillateral extends Shape{
	protected double angle1;
	protected double angle2;
	protected double angle3;
	protected double angle4;
	protected double area =200;
}

class Rectangle extends Quadrillateral{
	protected double area = 100;
	Rectangle(){
		angle1 = 90;
		angle2 = 90;
		angle3 = 90;
		angle4 = 90;
	}
}