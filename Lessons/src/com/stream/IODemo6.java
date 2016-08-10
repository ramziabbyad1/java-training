package com.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo6 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			fis = new FileInputStream("Desert.jpg");
			fos = new FileOutputStream("newDesert.jpg");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			int c=0;
			while((c=fis.read())!=-1){
				bos.write(c);
			}
			fis.close();
			fos.close();
			bis.close();
			bos.close();
			System.out.println("Files copied.");
		}catch(IOException io){
			io.printStackTrace();
		}

	}

}
