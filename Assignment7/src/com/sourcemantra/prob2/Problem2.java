package com.sourcemantra.prob2;

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

public class Problem2 {

	public static void main(String[] args) {
		List<Path> list = new ArrayList<>();
		MyThread[] threads = null;
		String ext = "src\\com\\sourcemantra\\prob1\\";
		String searchWord = null;
		System.out.println("Enter multiple filenames on each line... terminate = @");
		try(
				BufferedReader br = new BufferedReader(
										new InputStreamReader(System.in));									
				){
			String c = "";
			while(!(c=br.readLine()).equals( "@")){
				list.add(Paths.get(ext+c));
			}
			System.out.println("Enter a search word: ");
			searchWord = br.readLine();
			
			int no_files = list.size();
			threads = new MyThread[no_files];
			for(int i = 0; i < no_files; i++){
				threads[i] = new MyThread(list.get(i), searchWord);
			}
			for(Thread t:threads){
				t.start();
			}
			for(Thread t:threads){
				t.join();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(MyThread t:threads){
			System.out.println("Lines from " +t.getName() +" and file " + t.getP());
			for(String s: t.getList())
			System.out.println(s);
		}
	}

}

class MyThread extends Thread{
	private List<String> list = new ArrayList<>();
	private Path p;
	
	public Path getP() {
		return p;
	}
	//private int num_words;
	protected MyThread(Path p, String word){
		this.p = p;
		//System.out.println("Hello from " + MyThread.currentThread().getName());
		Charset cs = StandardCharsets.US_ASCII;
		try(
				 BufferedReader br = new BufferedReader(
						 				new FileReader(p.toFile()) 
						 			);
				){
		List<String> listTemp = Files.readAllLines(p, cs); 
		//String s = word;
		for(String line: listTemp){
			//System.out.println(line);
			if(line.contains(word)){
				list.add(line);
				//System.out.println(MyThread.currentThread().getName() +" "+ line);
			}
		}
		 } catch (Exception e) {
			e.printStackTrace();
		} 
		
	 }
	public List<String> getList(){
		return list;
	}
}