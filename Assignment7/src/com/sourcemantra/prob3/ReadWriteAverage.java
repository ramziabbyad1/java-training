package com.sourcemantra.prob3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Context{
	double value1;
	double value2;
	double avg;
	Lock l = new Lock();
	
	synchronized void read(double value1, double value2){
		try {
			while(l.t1ShouldBlock())
				wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value1 = value1;
		this.value2 = value2;
		l.t1counter++;
		notifyAll();
		//System.out.println(Thread.currentThread().getName() + " exiting method read");		
	}
	
	synchronized void average(){
		try {
			while(l.t2ShouldBlock())
				wait();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		avg = (value1 + value2)/2;
		l.t2counter++;
		notifyAll();
		//System.out.println(Thread.currentThread().getName() + " exiting method average with result = " +avg);		

	}
	
	synchronized void write(DataOutputStream dos){
		try {
			while(l.t3ShouldBlock())
				wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Average: " + avg);
			dos.writeDouble(avg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		l.t3counter++;
		notifyAll();
	}
}

class Lock{
	int t1counter = 0;
	int t2counter = 0;
	int t3counter = 0;
	
	boolean t1ShouldBlock(){
		if(t1counter > t2counter){
			return true;
		}
		return false;
	}
	boolean t2ShouldBlock(){
		if(t2counter > t3counter){
			return true;
		}
		return false;
	}
	boolean t3ShouldBlock(){
		if(t3counter == t2counter){
			return true;
		}
		return false;
	}
}

class Thread1 implements Runnable{
	Thread t1;
	Context c;
	public Thread1(Context c){
		this.c = c;
		new Thread(this, "Reader").start();
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
				c.read(dis.readDouble(), dis.readDouble());				
			}
		}catch(Exception e){
					e.printStackTrace();
		}
		
	}	
}

class Thread2 implements Runnable{
	Context c;
	Thread2(Context c){
		this.c = c;
		new Thread(this, "Averager").start();
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i+=2){
			c.average();
		}
		
	}
	
}

class Thread3 implements Runnable{
	Context c;
	Thread3(Context c){
		this.c = c;
		new Thread(this, "Writer").start();
	}
	@Override
	public void run() {
		String ext = "src\\com\\sourcemantra\\prob3\\";
		try(
				DataOutputStream dos = new DataOutputStream(
										new BufferedOutputStream(
												new FileOutputStream(ext+"averages.dat")));	
				){
			for(int i = 0; i < 10; i+=2){
				c.write(dos);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		//}
		
	}
	
}

public class ReadWriteAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Context c = new Context();
		Thread1 t1 = new Thread1(c);
		Thread2 t2 = new Thread2(c);
		Thread3 t3 = new Thread3(c);
		//System.out.println("Done");

	}
	
	static void init(){
		String ext = "src\\com\\sourcemantra\\prob3\\";
		try(
			DataOutputStream dos = new DataOutputStream(
									 new BufferedOutputStream(
											 new FileOutputStream(ext+"numbers.dat")))
			
				){
			dos.writeDouble(10);
			dos.writeDouble(20);
			dos.writeDouble(30);
			dos.writeDouble(40);
			dos.writeDouble(50);
			dos.writeDouble(60);
			dos.writeDouble(70);
			dos.writeDouble(80);
			dos.writeDouble(90);
			dos.writeDouble(100);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
