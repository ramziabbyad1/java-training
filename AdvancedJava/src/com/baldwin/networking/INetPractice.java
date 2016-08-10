package com.baldwin.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.lang.model.type.NullType;

public class INetPractice {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www2.austin.cc.tx.us");
			byte[] bytes = address.getAddress();
			for (byte b: bytes) {
				System.out.println("signed " + b);
				System.out.println("unsigned " + (b < 0 ? b << 8 : b));
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Is an Integer primitive? " + Integer.TYPE.isPrimitive());
		System.out.println("Is an Integer primitive? " + Integer.TYPE);
	}

}
