package com.sourcemantra.multithread.example1;

public class OverLoadingRiding {

	public static void main(String[] args) {
		
	}

}


class Methods1{
	/*public static void dothing(){
		System.out.println("Stuff1");
	}*/
	
	public void dothing(){
		System.out.println("Stuff12");
	}
}

class Methods2 extends Methods1{
	public void dothing(){
		System.out.println("Stuff2");
	}
}