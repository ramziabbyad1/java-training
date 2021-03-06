package com.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo3 {

	public static void main(String[] args) {
		Path path = Paths.get("bananas");
		Charset cs = Charset.forName("US-ASCII");
		try(
			BufferedReader br = Files.newBufferedReader(path, cs);	
				){
			String line;
			while((line=br.readLine()) != null){
				System.out.println(line);
			}
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
