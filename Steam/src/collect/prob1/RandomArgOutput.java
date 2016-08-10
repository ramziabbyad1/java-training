package collect.prob1;

import java.util.ArrayList;
import java.util.List;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.io.BufferedOutputStream;

public class RandomArgOutput {

	public static void main(String[] args, int e) throws IOException {
		int n = args.length;
		List<Integer> ll = new LinkedList<>();
		for(int i = 0; i < n; i++){
			ll.add(i);
		}
		
		List<Integer> indices = init(args, ll);
		//print using PrintStream
		/*for(int i:indices){
			System.out.println(args[i]);
		}*/
		//Integer i;
	
		/*indices
			.stream()
			.forEach(e -> System.out.println(e) );*/
		indices.stream().forEach((i) -> (System.out.println(i)));
		//DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(System.out));
		//OutputStream os = new OutputStream(System.out);
		//System.out.println(indices);

		init2(args);
		for(String s:args){
			System.out.println(s);
		}
		List<String> args2 = new ArrayList<>();
		//args.stream();
	}
	
	static List<Integer> init(String[] args, List<Integer> ll){
		List<Integer> ll2 = new LinkedList<>();
		int m = args.length;
		for(int i = 0; i < m; i++){
			int n = ll.size();
			int key;
			double rndm = n*Math.random();
			key =(int) Math.floor(rndm);
			int index = ll.get(key); 
			//System.out.println(args[index]);
			ll2.add(index);
			ll.remove(key);
		}
		
		return ll2;
	}
	
	static void init2(String[] args){
		int n = args.length;
		for(int i =0; i < n; i++){
			int m = n -i;
			double rndm = m*Math.random();
			int key = (int) Math.floor(rndm);
			int out = key+i;
			String key_val = args[key+i];
			args[key+i] = args[i];
			args[i] = key_val;
		}
	}

}

 
