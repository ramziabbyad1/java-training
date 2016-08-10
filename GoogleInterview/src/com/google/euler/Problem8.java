package com.google.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem8 {

	public static void main(String[] args) {
		String ext = "src\\com\\google\\euler\\";
		try(
				BufferedReader br = new BufferedReader(
										new FileReader(ext+"largeNumber.txt"));
				){
			String in;
			String str = "";
			while((in=br.readLine()) != null){
				str += in;
			}
			str = str.replaceAll(System.lineSeparator(), "");
			//System.out.println(str);
			String[] arr = str.split("");
			int[] arr2 = new int[1000];
			//for(String s:arr){
				
			//}
			for(int i = 0; i < 1000; i++){
				arr2[i] = Integer.parseInt(arr[i]);
			}
			//System.out.println(arr.length);
			int max = 0;
			int five = 0;
			for(int i = 0; i < 996; i++){
				five = arr2[i]*arr2[i+1]*arr2[i+2]*arr2[i+3]*arr2[i+4];
			//	System.out.println(i); 
				if(five > max){
					max = five;
				}
			}
			
			System.out.println("Max prod: " + max);	
				
			//System.out.println(arr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
