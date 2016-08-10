package com.google.euler;

public class Problem9 {

	public static void main(String[] args) {
		//a+b+c == 1000 && a < b < c && a^2 + b^2 = c^2
		int as = 0;
		int bs = 0;
		int cs= 0;
		int c = 0;
		for(int b = 0; b < 1000; b++){
			for(int a=0; a < b; a++){
				c = 1000 - a -b;
				if(c*c == b*b + a*a && c >b){
					as = a; bs = b; cs = c;
				}
				
			
			}
		}
		int lhs = as*as + bs*bs;
		int rhs = cs*cs;
		int prod = as*bs*cs;
		System.out.println("a*a + b*b = " + lhs);
		System.out.println("c*c = " + rhs);
		System.out.println("a : " + as+" b: " + bs + " c: " +cs);
		System.out.println("prod : " + prod);
	}

}
