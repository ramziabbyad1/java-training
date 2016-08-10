package com.multithread;

public class Queue {
	private int no;
	boolean valueSet;
	public void put(int i){
		while(valueSet){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		no = i;
		System.out.println("Put : " +no);
		valueSet = true;
		notify();
	}
	public int get() {
		while(!valueSet){
			try{
				wait();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got : " + no);
		valueSet = false;
		notify();
		return no;
		
	}
}