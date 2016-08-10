package com.stream;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IODemo {

	public static void main(String[] args) {

		try(FileOutputStream fos = new FileOutputStream("apple.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
				){
			
			char c = ' ';
			System.out.println("Start Typing ... @ to save and close");
			c =(char)br.read();
			while(c != '@'){
				fos.write(c);
				c=(char)br.read();
			}
		}catch(IOException io){
			io.printStackTrace();
		}

	}

}
