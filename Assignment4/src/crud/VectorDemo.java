package crud;

import java.util.Vector;
import java.util.concurrent.*;

public class VectorDemo {
	
	public static double dot(Vector<Double> v1, Vector<Double> v2) throws InterruptedException{
		int v1Length = v1.size();
		System.out.println("v1Length: "+v1Length);
		int v2Length = v2.size();
    	if(v1Length == v2Length){
    		Dot dot1 = new Dot(v1, v2, 0, v1Length/2);
    		Dot dot2 = new Dot(v1, v2, v1Length/2, v1Length);
    		dot1.start();
    		dot2.start();
    		dot1.join();
    		dot2.join();
    		//System.out.println(dot1.getValue());
    		//double sum = dot2.getValue()+dot1.getValue();
    		//System.out.println(sum);
    		return dot1.getValue() + dot2.getValue();
    	}
    	else{
    		System.out.println("Size mismatch.");
    		return -1.0;
    	}
		
	}
	
	static class Dot extends Thread{
		private Vector<Double> v1 = new Vector<Double>();
		private Vector<Double> v2= new Vector<Double>();
        private int low;
        private int high;
        private double value = 0;
        
        Dot(Vector<Double> v1, Vector<Double> v2, int low, int high){
        	//(this.v1).addAll(v1);
        	//(this.v2).addAll(v2);
        	this.v1 = v1;
        	this.v2 = v2;
        	this.low = low;
        	this.high = high;
        }
        
        double getValue(){
        	return value;
        }
        
        public void run() {
            for (int i = low; i < high; i++) {
            	//System.out.println("v1: " + v1.get(i) + " v2: " +v2.get(i));
                value += v1.get(i)*v2.get(i);
                //System.out.println("partial sum: " + value);
            }

        }
        
        
	}

	public static void main(String[] args) {
		Vector<Double> v1 = new Vector<Double>();
		Vector<Double> v2 = new Vector<Double>();
		double n = 10000;
		for(int i = 0; i <=n; i++){
			v1.add((double)i);
		}
		
		for(int i =0; i <= n; i++){
			v2.add((double)(n - i));
		}
		
		try{
			double dot = dot(v1, v2);
			System.out.println("Lengthv1: " + v1.size() + " Lengthv2: " + v2.size());
			System.out.println("Result: " + dot);
			double cmpt = ((n*n*(n+1))/2) - (((n+1)*(n)*(2*n +1))/6);
			System.out.println("The product computed precisely: " + cmpt);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}

		for(int i = 0; i <=n; i++){
			v1.remove((double)i);
		}
		
		for(int i =0; i <= n; i++){
			v2.remove((double)(n - i));
		}
		
		System.out.println("Length after remove v1: " + v1.size());
		System.out.println("Length after remove v2: " + v2.size());
	}
}
		
