package com.google.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Problem13 {

	public static void main(String[] args) {
		try (
			BufferedReader br = new BufferedReader(new FileReader("problem12"));
			){
			String in = null;
			String[] row = new String[100];
			long sum = 0;
			int i =0;
			BigInteger bi = new BigInteger("0");
			while((in=br.readLine())!=null){
				//row[i] = in;
				bi = bi.add(new BigInteger(in));
				//sum +=Long.parseLong(in);
				System.out.println(bi);
				i++;
			}
			System.out.println(bi);
			/*int[][] cols = new  int[100][53];
			int[] result = new int[53];
			for(i =0; i < 100; i++){
				for(int j =0; j < 50; j++){
					cols[i][j] = Integer.parseInt(String.valueOf(row[i].charAt(j)));
				}
			}
			//results = sum(cols);
			System.out.println(sum);*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static int[] sum(int[][] cols){
		int[] result = new int[53];
		for(int j =0; j < 53;j++ ){
			for(int i =0; i < 100; i++)
				result[j] += cols[i][j];
		}
		for(int k =0; k < 53; k++){}
		
		return result;
	}

}
