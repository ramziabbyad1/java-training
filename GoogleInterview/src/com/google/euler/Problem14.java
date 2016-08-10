package com.google.euler;

public class Problem14 {

	public static void main(String[] args) {
		long maxChainLength = 0;
		long currentChainLength = 1;
		long currentTerm = 0;
		long startingTerm = 1;
		for(long i = 1; i <= 1e6; i++){
			currentTerm = i;
			currentChainLength = 1;
			while(currentTerm != 1){
				//System.out.print(currentTerm + " -> ");
				if(currentTerm%2 == 0){
					currentTerm /= 2;
				}else{
					currentTerm = 3*currentTerm + 1;
				}
				
				currentChainLength++;
			}
			//System.out.println("Chain length : " + currentChainLength);
			if(currentChainLength > maxChainLength){
				maxChainLength = currentChainLength;
				startingTerm = i;
				System.out.println("New Max : " + maxChainLength);
				System.out.println("Starting number = " +startingTerm);
			}
			//System.out.println(i);
		}
		System.out.println("Max chain length : " + maxChainLength);
	}

}
