package com.google.euler;

public class Problem17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] numbers = new String[1001];
		numbers[0] = "";
		numbers[1] = "one"; numbers[2] = "two"; numbers[3] = "three"; numbers[4] = "four";
		numbers[5] = "five"; numbers[6] = "six"; numbers[7] = "seven"; numbers[8] = "eight";
		numbers[9] = "nine"; numbers[10] = "ten"; numbers[11] = "eleven"; numbers[12] = "twelve";
		numbers[13] = "thirteen"; numbers[14] = "fourteen"; numbers[15] = "fifteen"; numbers[16] = "sixteen";
		numbers[17] = "seventeen"; numbers[18] = "eighteen"; numbers[19] = "nineteen"; numbers[20] = "twenty";
		numbers[30] = "thirty"; numbers[40] = "forty"; numbers[50] = "fifty"; numbers[60] = "sixty"; numbers[70] = "seventy";
		numbers[80] = "eighty"; numbers[90] = "ninety"; /*numers[100] = "one hundred"; numbers[200] = "two hundred";numbers[300]="three h"*/
		String hundred = "hundred";
		String thousand = "thousand";
		long length = 0;
		int k =0;
		for(int i = 20; i <1000; i++){
			if(i < 100){
				if(i%10 != 0)
					numbers[i] = numbers[(i/10)*10] +" "+numbers[i%10];
				else
					numbers[i] = numbers[(i/10)*10];
			}
			else{
				if(i%100 != 0)
					numbers[i] = numbers[(i/100)] +" hundred "+" and "+numbers[i%100];
				else
					numbers[i] = numbers[(i/100)] +" hundred ";
			}
		}
		numbers[1000] = "one thousand";
		
		for(String s:numbers){
			length += s.replaceAll(" ", "").length();
			System.out.println("Word : ");
			System.out.println(s.replaceAll(" ", ""));
			System.out.println("Length :");
			System.out.println(s.replaceAll(" ", "").length());
		}
		System.out.println("Total length : " + length);
	}

}
