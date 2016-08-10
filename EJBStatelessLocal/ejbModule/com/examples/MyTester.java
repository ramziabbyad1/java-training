package com.examples;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class MyTester
 */
@Singleton
@LocalBean
@Startup
public class MyTester {
	@EJB
	MyEjbLocal bean;
    public MyTester() {
        
    }
    @PostConstruct
    void myMain(){
    	int i = bean.addInteger(20, 30);
    	System.out.println("Ans : " + i);
    }
}
