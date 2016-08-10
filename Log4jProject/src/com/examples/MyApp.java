package com.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp {
	private static final Logger logger = LoggerFactory.getLogger(MyApp.class);
	public static void main(String[] args) {
		logger.info("my app started");
		for(int i = 0;  i < 5; i++){
			System.out.println("i= "+i);
		}
		logger.info("my app ended");
	}

}
