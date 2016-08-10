package com.sourcemantra.prob6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

public class Problem6 {

	public static void main(String[] args) throws IOException {
		String ext = "src\\com\\sourcemantra\\prob6\\";
		String filename = "apple.txt";
		Path path = Paths.get(ext + filename);
		
		Charset cs = StandardCharsets.UTF_8;
		List<String> lines = Files.readAllLines(path, cs);
		String string = null;
		//string.
		//Files.
		int size = lines.size();
		ListIterator<String> li = lines.listIterator(size);
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}

	}

}
