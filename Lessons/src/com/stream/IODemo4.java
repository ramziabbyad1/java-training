package com.stream;
//These are not very efficient so seldomly used because they do it one byte at a time.
import java.io.FileWriter;
import java.io.IOException;

public class IODemo4 {

	public static void main(String[] args) {
		String[] arr = {"mango","banana","pear"};
		try(
				FileWriter fw = new FileWriter("oranges.txt");
				){
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
