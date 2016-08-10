package com.examples;


import javax.ejb.Remote;

@Remote
public interface ConverterBeanRemote {
	public double farenheightToCelcius(double fah);
}
