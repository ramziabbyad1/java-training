package com.examples;

import javax.ejb.Local;

@Local
public interface MyEjbLocal {
	public int addInteger(int a, int b);
}
