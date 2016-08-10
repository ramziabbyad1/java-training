package com.examples;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyEjb
 */
@Stateless
public class MyEjb implements MyEjbLocal {

    /**
     * Default constructor. 
     */
    public MyEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addInteger(int a, int b) {
		return a+b;
	}

}
