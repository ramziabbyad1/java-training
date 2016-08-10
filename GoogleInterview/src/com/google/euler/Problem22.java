package com.google.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem22 {

	public static void main(String[] args) {
		//List list = null;
		String[] namesArr = null;
		try(BufferedReader br = new BufferedReader(new FileReader("names.txt"))){
			String line= null;
			String fileString = "";
			while((line=br.readLine())!=null){
				fileString += line;
			}
			namesArr = fileString.replaceAll("\"", "").toLowerCase().split(",");
			//list = Arrays.asList(names);
		}catch(IOException e){
			e.printStackTrace();
		}
		Arrays.sort(namesArr);
		//Map<String, String> namesMap = new TreeMap<>();
		long score = 0;
		for(int i = 0; i < namesArr.length; i++){
			int sum = 0;
			for(int j = 0; j < namesArr[i].length(); j++){
				int pos = namesArr[i].charAt(j) - 'a' + 1;
				System.out.print(pos + " ");
				sum += pos;
			}
			score += (i+1)*sum;
			System.out.println();
		}
		System.out.println(Arrays.asList(namesArr));
		System.out.println(score);
	}

}
