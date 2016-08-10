package com.examples;

public class CheckOutException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg = null;
	public CheckOutException(String name){
		msg = "Sorry, " + name + " has been checkout already.";
	}
	@Override
	public String toString(){
		return msg;
	}
}
