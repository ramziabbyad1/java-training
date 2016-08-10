package com.google.euler;

public class Problem4 {

	public static void main(String[] args) {
		int max = 0;
		int a_0;
		int a_1;
		int a_2;
		int b_0;
		int b_1;
		int b_2;
		boolean check_1 = false;
		boolean check_2 = false;
		int num = 0;
		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
			/*	a_0 = i%10;
				a_1 = (i%100)/10;
				a_2 = i/100;
				b_0 = j%10;
				b_1 = (j%100)/10;
				b_2 = j/100;*/
				num = i*j;
				String s =String.valueOf(num);
				
				int len = s.length();
				boolean flag = false;
				for(int k = 0; k < len/2; k++){
					int index = len-k-1;
					if(s.charAt(k) == s.charAt(len-k -1)){
					//	System.out.println("char at: " + k + " char: " + s.charAt(k));
						//System.out.println("char at: " +index  + " char: " + s.charAt(index));
						flag = true;
					}else{
						flag = false;
						break;
					}
				}
				
				//check_1 = a_2*b_2 == b_0*a_0;
				//check_2 = (b_1*a_2 + b_2*a_1) == (b_1*a_0 + b_0*a_1);
				if(flag && num > max){
					//System.out.println("num : " + num);
					max = num;
					//System.out.println(max);
					//System.out.println("a_2:"+a_2+" a_1:"+a_1+" a_0:"+a_0);
					//System.out.println("b_2:"+b_2+" b_1:"+b_1+" b_0:"+b_0);
				}
				
				
			}
		}
		System.out.println("max : " + max);

	}

}
