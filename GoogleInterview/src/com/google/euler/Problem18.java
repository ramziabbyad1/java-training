package com.google.euler;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem18 {

	public static void main(String[] args) {
		int[][] e = getElems();
		
		getMaxSum(e);
		for(int i = 0; i < e.length; i++){
			for(int j = 0; j < e[i].length; j++)
				System.out.print(e[i][j] + " ");
			System.out.println();
		}
		
	}
	
	private static int[][] getElems(){
		int[][] out = new int[15][];
		String[] temp;
		
		try(BufferedReader br = new BufferedReader(new FileReader("triangle.txt"));){
			String in = null;
			int rowIndex = 0;
			while((in=br.readLine()) != null){
				temp = in.split("\\s");
				out[14-rowIndex] = new int[temp.length];
				for(int i=0; i < temp.length; i++) out[14-rowIndex][i] = Integer.parseInt(temp[i]); 
				rowIndex++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	private static void getMaxSum(int[][] e){
		long maxSum = 0;
		for(int i = 0; i < e.length; i++){
			for(int j = 0; j < e[i].length-1; j++){
				int max = Math.max(e[i][j], e[i][j+1]);
				e[i+1][j] += max;
			}
		}
		maxSum = e[e.length-1][0];
		System.out.println("Max sum : " + maxSum);
	}
}
