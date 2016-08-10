package com.excep;

public class OddNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String msg;
	public OddNumberException(){
		msg = "OddNumberException occurred... even no was expected";
	}
	@Override
	public String toString(){
		return msg;
	}
}
