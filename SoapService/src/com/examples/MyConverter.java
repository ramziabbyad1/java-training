package com.examples;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MyConverter {
	@WebMethod
	public double fahToCelsius(double fah){
		double celsius = 0.0;
		celsius = (5/9)*fah+32;
		return celsius;
	}
}
