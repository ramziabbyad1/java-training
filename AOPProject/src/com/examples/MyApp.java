package com.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.beans.ShapeService;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		ShapeService ss = context.getBean("shapeService",ShapeService.class);
		ss.getTriangle().setName("Isoceles");
		
		System.out.println(ss.getTriangle().getName());
		System.out.println(ss.getCircle().getName());
		ss.draw();
		

	}

}
