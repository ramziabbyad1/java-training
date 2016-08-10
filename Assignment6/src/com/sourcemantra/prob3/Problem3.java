package com.sourcemantra.prob3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Problem3 {

	public static void main(String[] args) {
		String ext = "src\\com\\sourcemantra\\prob3\\";
		Path path = Paths.get(ext + "myfile.txt");
		Charset charset = StandardCharsets.US_ASCII;
		
		try {
			String content = new String(Files.readAllBytes(path), charset);
			content = content.replaceAll("CSharp", "Java");
			Files.write(path, content.getBytes(charset));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done writing..");
	}

}
