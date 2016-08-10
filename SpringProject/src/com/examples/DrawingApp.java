package com.examples;
import org.apache.catalina.core.ApplicationContextFacade;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.examples.beans.*;

public class DrawingApp {

	public static void main(String[] args) {
		//Triangle t = new Triangle();
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//ApplicationContext c =  new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		AbstractApplicationContext c =  new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		//ApplicationContext context = (ApplicationContext) new DrawingApp(); 
		//t.draw();
		//Triangle t =beanFactory.getBean(Triangle.class); this one is better :)
		//example of constructor injection
		//Triangle t =(Triangle) beanFactory.getBean("triangle");
		Triangle t =(Triangle) c.getBean("triangle");
		//Triangle t =(Triangle) c.getBean("new-triangle");
		//Triangle t =(Triangle) c.getBean("abc");
		t.draw();
		
		Circle c1 = c.getBean("circle", Circle.class);
		System.out.println("-----c1-------");
		c1.draw();
		Circle c2 = c.getBean("circle", Circle.class);
		System.out.println("-----c2-------");
		c2.setName("Eclipse");
		c2.draw();
		System.out.println("-----c1-------");
		c1.draw();
		/*c.registerShutdownHook();
		Student s =c.getBean("student", Student.class);
		System.out.println(s);
		c.close();//only required for standalone applications*/
	}

}
