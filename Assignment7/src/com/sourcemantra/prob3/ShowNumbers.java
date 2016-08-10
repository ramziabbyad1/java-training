package com.sourcemantra.prob3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ShowNumbers {

	public static void main(String[] args) {
		String ext = "src\\com\\sourcemantra\\prob3\\";
		try(
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new	FileInputStream(ext+"averages.dat")));
				){
			for(int i =0; i < 5; i++)
				System.out.println(dis.readDouble());
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
