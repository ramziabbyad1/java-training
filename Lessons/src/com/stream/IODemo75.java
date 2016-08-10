package com.stream;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class IODemo75 {
	public static void main(String[] args){
		File file = new File("C:\\Users\\Owner\\Downloads");
		OnlyExt ext = new OnlyExt("zip");
		String[] list = file.list(ext);
		for(String s:list){
			System.out.println(s);
		}
		File myFile = new File("newApple.txt");
		System.out.println("Name: " + myFile.getName());
		System.out.println("Parent: " + myFile.getParent());
		System.out.println("Path: " + myFile.getPath());
		System.out.println("Absolute Path: " + myFile.getAbsolutePath());
		long l = myFile.lastModified();
		System.out.println("Last modified: " +new Date(l));
		System.out.println("Can execute: " + myFile.canExecute());
		System.out.println("Can read: " + myFile.canRead());
		System.out.println("Can write: " + myFile.canWrite());

		/*File myDir = new File("myfolder");
		boolean b = myDir.mkdir();
		if(b){
			System.out.println("myfolder created!");
		}*/
		File yourFile = new File("myfolder\\orange.txt");
		try {
			boolean b = yourFile.createNewFile();
			if(b){
				System.out.println("yourfile created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yourFile.delete();
		//File yourFile = new File("");
	}
	
}
