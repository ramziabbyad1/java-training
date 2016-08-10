package com.examples;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ConverterBean
 */
@Stateless
public class ConverterBean implements ConverterBeanRemote {

    /**
     * Default constructor. 
     */
    public ConverterBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public double farenheightToCelcius(double fah) {
    	double cel = 0.0;
    	cel = (fah-32)*5/9;
    	return cel;
    }

}
