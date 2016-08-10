package com.excep;

public class NegativeNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static String msg;
	public NegativeNumberException(){
		msg = "NegativeNumberException occurred... positive no was expected";
	}
	@Override
	public String toString(){
		return msg;
	}
}
