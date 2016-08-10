package com.stream;

import java.io.File;

public class IODemo7 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Owner\\Downloads\\");
		if(file.isDirectory()){
			System.out.println(file + " is a director.");
		}
		else{
			System.out.println(file + " is a file.");
		}
		String[] list = file.list();
		for(String s:list){
			File f = new File(file+"\\"+s);
			if(f.isDirectory()){
				System.out.println(f +" is a directory");
			}
			else{
				System.out.println(f + " is a file.");
			}
		}

	}

}
