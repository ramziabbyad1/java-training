package com.sourcemantra.prob3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Problem3 {

	public static void main(String[] args) {
		MyThread1 mt1 = new MyThread1();
		MyThread2 mt2 = new MyThread2(mt1);
		MyThread3 mt3 = new MyThread3(mt2);
		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt2);
		Thread t3 = new Thread(mt3);
		t1.start();
		t2.start();
		t3.start();

	}

}

class MyThread1 implements Runnable{
	private double num1;
	private double num2;
	public double getNum1() {
		return num1;
	}
	public double getNum2() {
		return num2;
	}
	@Override
	public void run() {
		String ext = "src\\com\\sourcemantra\\prob3\\";
		try(
				DataInputStream dis = new DataInputStream(
										new BufferedInputStream(
												new	FileInputStream(ext+"numbers.dat")));
				){
			for(int i = 0; i < 10; i+=2){
				num1 = dis.readDouble();
				num2 = dis.readDouble();
				notifyAll();
				System.out.println("num1 " +num1);
				System.out.println("num2 " +num2);
				this.wait();
				System.out.println("Hello 12");
			}
		}catch(Exception e){
					e.printStackTrace();
		}
		
	}
}

class MyThread2 extends MyThread1 implements Runnable{
	MyThread1 t1;
	private double avg;
	public MyThread2(){}
	public MyThread2(MyThread1 t1){
		this.t1 = t1;
	}
	@Override
	public void run()  {
		try {
			t1.wait();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		double num1 = t1.getNum1();
		double num2 = t1.getNum2();
		System.out.println("hello2");
		notifyAll();
		setAvg((num1+num2)/2);
		try {
			t1.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}

class MyThread3 extends MyThread2 implements Runnable{
	MyThread2 t2;
	public MyThread3(MyThread2 t2){
		this.t2 = t2;
	}
	
	@Override
	public void run() {
		try {
			t2.wait();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		double result = t2.getAvg();
		System.out.println("Hello3");
		try {
			t2.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.notify();
		System.out.println("Result is " + result);
		
	}
	
	
	
}
