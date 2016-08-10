package com.tutorials.springaop;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTest {
	private static final Logger logger_c = Logger.getLogger(RunTest.class);
	
	public static void main(String[] args) {
		logger_c.debug("loading spring application context...");
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		CalculationService calculationService = (CalculationService) applicationContext.getBean("calculationService");
		
		for(int i = 0; i < 50; i++){
			calculationService.dummyServiceMethod();
		}
		
		applicationContext.close();

	}

}
