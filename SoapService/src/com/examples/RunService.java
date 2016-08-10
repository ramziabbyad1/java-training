package com.examples;

import javax.xml.ws.Endpoint;

public class RunService {

	public static void main(String[] args) {
		
		System.out.println("My converter started...");
		Endpoint.publish("http://localhost:8081/SoapService", new MyConverter());
		

	}

}
