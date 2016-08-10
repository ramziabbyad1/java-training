package com.stream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathDemo2 {

	public static void main(String[] args) {
		Path path = Paths.get("bananas");
		Scanner scanner = new Scanner(System.in);
		String line = null;
		Charset cs = Charset.forName("US-ASCII");
		try(
				BufferedWriter bw = Files.newBufferedWriter(path, cs);
				){
			line = scanner.nextLine();
			while(line.length() != 0){
				bw.newLine();
				bw.write(line);
				line = scanner.nextLine();
			}
		
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		

	}

}
