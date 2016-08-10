package com.examples;

import javax.naming.InitialContext;



public class MyClient {
	public static void main(String args[]){
		double bal = 0;
		try{
			InitialContext context = new InitialContext();
			context.addToEnvironment("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
			context.addToEnvironment("org.omg.CORBA.ORBInitialPost", "3700");
			AccountBeanRemote bean = (AccountBeanRemote)context.lookup("java:global/EJBStatefulRemote/AccountBean");
			bal = bean.deposit(100);
			System.out.println("Balance = " + bal);
			bal = bean.deposit(200);
			System.out.println("Balance = " + bal);
			bal = bean.withdraw(50);
			System.out.println("Balance = " + bal);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
