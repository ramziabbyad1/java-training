package com.stream;

import java.io.FileInputStream;
import java.io.IOException;


public class IODemo3 {

	public static void main(String[] args) {
		try(
				FileInputStream fis = new FileInputStream("apple.txt");
				){
			int c = 0;
			while((c=fis.read()) != -1){
				System.out.println((char)c);
			}
		}catch(IOException io){
			io.printStackTrace();
		}

	}

}
