package com.saks.display;

class ConditionalPrinter {
	static String FOO = "foo";
	static String BAR = "bar";
	static String FOOBAR = FOO + BAR;
	static int MULTIPLE3 = 3;
	static int MULTIPLE5 = 5;
	static boolean isMultiple(int number, int multiple) { 
		return number % multiple == 0;
	}
	static String valueOf(int number) {
		StringBuilder out = new StringBuilder();
		if ( isMultiple(number, MULTIPLE3) ){
			out.append(FOO);
		}
		if ( isMultiple(number, MULTIPLE5) ) {
			out.append(BAR);
		}
		return out.length() == 0 ? String.valueOf(number) : out.toString();
	}
}
