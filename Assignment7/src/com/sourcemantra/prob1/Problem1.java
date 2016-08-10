package com.sourcemantra.prob1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		List<Path> list = new ArrayList<>();
		MyThread[] threads = null;
		String ext = "src\\com\\sourcemantra\\prob1\\";
		//Scanner scanner = new Scanner(Syste;m.in);
		System.out.println("Enter multiple filenames on each line... terminate = @");
		try(
				BufferedReader br = new BufferedReader(
										new InputStreamReader(System.in));									
				){
			String c = "";
			while(!(c=br.readLine()).equals( "@")){
				list.add(Paths.get(ext+c));
			}
			int no_files = list.size();
			threads = new MyThread[no_files];
			for(int i = 0; i < no_files; i++){
				threads[i] = new MyThread(list.get(i));
			}
			for(Thread t:threads){
				t.start();
			}
			for(Thread t:threads){
				t.join();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list
			.stream()
			.forEach(s -> System.out.println(s));
		int result = 0;
		for(MyThread t:threads){
			result += t.getNumWords();
		}
		
		System.out.println("Result: " + result);
	}

}

class MyThread extends Thread{
	private List<String> list = new ArrayList<>();
	private int num_words;
	protected MyThread(Path p){
		Charset cs = StandardCharsets.US_ASCII;
		try(
				 BufferedReader br = new BufferedReader(
						 				new FileReader(p.toFile()) 
						 			);
				){
		list = Files.readAllLines(p, cs); 
		String file = "";
		for(String line: list){
			file += line;
		}
		String regex = " ";
		int num_words = file.split(regex).length;
		this.num_words = num_words;
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	 }
	public int getNumWords(){
		return num_words;
	}
}