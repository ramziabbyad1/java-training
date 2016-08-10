package com.sourcemantra.prob1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Problem1 {

	public static void main(String[] args) throws IOException {
		InputStream fis = null;
		OutputStream fos = null;
		int count;
		String ext = "src\\com\\sourcemantra\\prob1\\";
		Path path = Paths.get(ext).toAbsolutePath();
		String abpath = path.toString();
		fis = new FileInputStream(abpath+ "\\file1.txt");
		fos = new FileOutputStream(abpath+"\\file3.txt");
		while((count = fis.read()) != -1){
			fos.write(count);
		}
		fos.write(System.lineSeparator().getBytes());
		fis.close();
		fis = new FileInputStream(abpath+"\\file2.txt");
		while((count = fis.read()) != -1){
			fos.write(count);
		}
		fis.close();
		fos.close();
		System.out.println("Finished writing.");
	
	}

}
