package com.tutorials.springaop;

import org.apache.log4j.Logger;

public class CalculationServiceImpl implements CalculationService {
	
	private static final Logger logger_c = Logger.getLogger(CalculationServiceImpl.class); 

	@Override
	public void dummyServiceMethod() {
		logger_c.debug("doing some service stuff here...");
		randomSleep();
	}

	private void randomSleep() {
		try{
			Thread.sleep((long)(Math.random()*1000));
		}catch(InterruptedException ie_p){
			logger_c.error("error occured sleeping thread...",ie_p);
		}
		
	}

}
