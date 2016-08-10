package com.sourcemantra.prob2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Problem2 {

	public static void main(String[] args) {
		String ext = "src\\com\\sourcemantra\\prob2\\";
		//Path path = Paths.get(ext).toAbsolutePath();
		//String abpath = path.toString();
		try(
				BufferedReader br1 = new BufferedReader(new FileReader(ext+"\\file1.txt"));
				BufferedReader br2 = new BufferedReader(new FileReader(ext+"\\file2.txt"));
				//FileWriter fw = new FileWriter(ext+"\\file3.txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(ext+"\\file3.txt"));
				){
			String line1 = "";
			String line2 = "";
			while(line1 != null || line2 != null){
				line1 = br1.readLine();
				if(line1 != null){
					bw.write(line1);
					bw.newLine();
				}
				line2 = br2.readLine();
				if(line2 != null){
					bw.write(line2);
					bw.newLine();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Finished reading..");
	}

}
