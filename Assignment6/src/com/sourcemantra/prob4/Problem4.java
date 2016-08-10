package com.sourcemantra.prob4;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Problem4 {

	public static void main(String[] args) {
		String ext = "src\\com\\sourcemantra\\prob4\\";
		String filename = "mydata.dat";
		try(
				DataOutputStream dos = new DataOutputStream(
												new BufferedOutputStream(
														new FileOutputStream(ext+filename))
											)
				){
			dos.writeInt(10);
			dos.writeDouble(1e-9);
			dos.writeFloat(50.00025f);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Done writing..");

	}

}
