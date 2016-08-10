package com.stream;
//standardizes path retrieval 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathDemo {

	public static void main(String[] args) throws IOException {
		//abstract representation, file may or may not exist
		Path path = Paths.get("myfolder\\apple1.txt");
		System.out.println(path);
		System.out.println(path.getFileName());
		//returns 2 because the root is also counted
		System.out.println(path.getNameCount());
		System.out.println(path.getName(0));
		System.out.println(path.getName(1));
		//non-abstract, real path
		try {
			Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found.");
			//e.printStackTrace();
		}
		
		Path src = Paths.get("apple.txt");
		Path dest = Paths.get("mango.txt");
		Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		
		Path newDir = Paths.get("newDir");
		/*Files.createDirectory(newDir);*/
		
		Path f1 = Paths.get("orange.txt");
		Path f2 = Paths.get("grape.txt");
		Files.move(f2, newDir.resolve(f1), StandardCopyOption.REPLACE_EXISTING);
	}

}
