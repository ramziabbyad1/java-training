package com.sourcemantra.misc;

import java.util.ArrayList;
import java.util.Collection;

public class StaticClass extends Object{

	public static void main(String[] args) {
		String s = "hello";
		char c = 's';
		s += c;
		System.out.println(s);
		//o is automatically downcast to string
		Object o = s;
		System.out.println(o.getClass());
		String t = "dassd";
		o = o +t;
		int n = 40;
		o = 40;
		Object s2 = "hello2";
		s2 = 40;
		Object s3 = 20;
		Integer i1 = 10;
		Integer i2 = 20;
		int i3 = i1+i2;
		
		Integer i4 = i1+i2;
		i1 = (int) i1;
		System.out.println("Type of i1 after cast " + i1.getClass());
		//s3 = s3+s2;
		//double d = (double)s3+s2.intValue();
		Integer s4 = 10;
		int s5 = s4.intValue();
		//can't do this
		//Double d = 2;
		Integer i = 10;
		Integer res = i + i;
		System.out.println(o.getClass());
		System.out.println();
		Object o5 = "Hello";
		//Object o6 = ((Integer)o5).intValue();
		Object o7 = new Object();
		//o7 = (Student) o7;
		//interestingly you can automatically cast to Double from input
		System.out.println("Result of generic add with w/o explicit type: " + StaticClass.add(2, 1.2));
		System.out.println("Result of generic add with explicit type: " + StaticClass.<Double>add(1.2, 2.0));
		
		OtherClass oc = new OtherClass();
		oc.printInfo("hello", 2, (Integer) 3);
		
		//doesn't compile
		//Collection<? extends String> c2 = new ArrayList<>();
		//c2.add("c");

	}

	@Override
	public String toString() {
		return "StaticClass [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public static <T> double add(T num1, T num2){
		System.out.println("num1 type: " + num1.getClass());
		System.out.println("num2 type: " + num2.getClass());

//		double result = num1.doubleValue() +num2.doubleValue();
		return 1;
	}

}

class OtherClass{
	<T> void printInfo(T first, T second, T third){
		System.out.println("------PrintInfoMethod-----");
		System.out.println(first.getClass());
		System.out.println(second);
		System.out.println(second.getClass());
		System.out.println(third);
		System.out.println(third.getClass());
		System.out.println(first);
	}
}