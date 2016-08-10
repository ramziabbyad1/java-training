package com.google.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem11 {

	public static void main(String[] args) {
		String ext = "src\\com\\google\\euler\\";
		try(
				BufferedReader br = new BufferedReader(
										new FileReader(ext+"largeNumber2.txt"));
				){
			String in;
			String str = "";
			int rowLength = 0;
			//String row;
			String regex = " ";
			String arr[] = new String[400];
			//int i = 0;
			//br.read
			//br.read();
			while((in=br.readLine()) != null ){
				//System.out.println(in);
				str +=  in+" ";
			}
			System.out.println(str);
			int j = 0;
			for(int i =0; i < str.length(); i+=3){
				//if(i % 2 != 0 && i!=0)
				int index = i+1;
				//System.out.println("char at " + i + " = " + str.charAt(i));
				//System.out.println("char at " + index + " = " + str.charAt(i+1));
				String temp = String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1));
				arr[j] = temp;
				//System.out.println("arr["+j+"] = " + arr[j]);
				j++;
			}
			//str = str.replaceAll(System.lineSeparator(), "");
			//System.out.println(str);
			//String[] arr = str.split(" ");
			int[] a = new int[400];
			for(int i =0; i< 400; i++){
				a[i] = Integer.parseInt(arr[i]);
			}
			int maxProd = 0;
			int m =20;
			int n=m;
			int prod1,prod2,prod3,prod4,prod5,prod6;
			prod1=prod2=prod3=prod4=prod5=prod6=0;
			System.out.println("Prod1: "+ prod1);
			int limit = m*16 + 16 +1;
			int col = 0;
			int row = 0;
			for(int i = 0; i < 400; i++){
				col = i%20;
				row = i/20;
				if(col<17 && row<17 /*&& row%4 != 3 && col%4 != 3*/){
					System.out.println("row: " + row);
					System.out.println("col: " + col);
					prod1 = a[i]*a[i+1]*a[i+2]*a[i+3];
					prod2 = a[i]*a[i+n]*a[i+2*n]*a[i+3*n];
					prod3 = a[i]*a[i+n+1]*a[i+2*n+2]*a[i+3*n+3];
					prod4 = a[i+3]*a[i+n+3]*a[i+2*n+3]*a[i+3*n+3];
					prod5 = a[i+3*n]*a[i+1+3*n]*a[i+2+3*n]*a[i+3+3*n];
					prod6 = a[i+3]*a[i+2+n]*a[i+1+2*n]*a[i+3*n];
					int max =max(prod1,prod2,prod3,prod4,prod5,prod6); 
					System.out.println("Prod1 : " + prod1);
					System.out.println("Prod2 : " + prod2);
					System.out.println("Prod3 : " + prod3);
					System.out.println("Prod4 : " + prod4);
					System.out.println("Prod5 : " + prod5);
					System.out.println("Prod6 : " + prod6);
					System.out.println("Max : " + max);
					if( max > maxProd){
						maxProd=max;
					}
					System.out.println("Max prod : " + maxProd);
					if(max==maxProd)
						System.out.println("Changed max to " + maxProd);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int max(final int p1, final int p2, final int p3, final int p4, final int p5, final int p6){
		int max = 0;
		SortedSet<Integer> ts = new TreeSet<Integer>(){
			private static final long serialVersionUID = 1L;
		{
			add(p1);
			add(p2);
			add(p3);
			add(p4);
			add(p5);
			add(p6);
		}};
		return ts.last();
	}

}
