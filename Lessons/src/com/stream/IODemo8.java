package com.stream;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class IODemo8 {

	public static void main(String[] args) throws IOException {
		File source = new File("apple.txt");
		File dest = new File("grape.txt");
		FileUtils.copyFile(source, dest);
		System.out.println("File copied");

	}

}
