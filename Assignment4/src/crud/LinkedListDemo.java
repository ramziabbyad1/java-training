package crud;

import java.util.LinkedList;
//import java.util.Random;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<Double> ll = new LinkedList<Double>();
		for(int i = 0; i < 10000; i++){
			ll.add((double)i);
		}
		
		int size = ll.size();
		while(ll.size() > 0){
			double rn = Math.random();
			double range = ll.size()-1;
			System.out.println("Range: " +range);
			int randomIndex = (int)(rn*range);
			System.out.println("RandomIndex: " +randomIndex);
			ll.remove(randomIndex);
		}
		

	}

}
