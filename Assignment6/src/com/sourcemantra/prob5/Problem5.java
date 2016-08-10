package com.sourcemantra.prob5;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Problem5 {

	public static void main(String[] args) {
		String ext = "src\\com\\sourcemantra\\prob4\\";
		String filename = "mydata.dat";
		try(
				DataInputStream dis = new DataInputStream(
												new BufferedInputStream(
														new FileInputStream(ext+filename))
											)
				){
			int first = dis.readInt();
			double second = dis.readDouble();
			float third = dis.readFloat();
			System.out.println("First number (int): " + first);
			System.out.println("Second number (double): " + second);
			System.out.println("Third number (float): " + third);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Done writing..");

	}

}
