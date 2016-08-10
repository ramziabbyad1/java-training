package com.sortedset;

import java.util.Comparator;

public class MyClass implements Comparator<Certificate> {

	@Override
	public int compare(Certificate o1, Certificate o2) {
		final int BEFORE = -1;
		final int AFTER = 1;
		if(o2==null)	return BEFORE*-1;
		
		String thisCertificate = o1.getName();
		String thatCertificate = o2.getName();
		
		if(thisCertificate==null){
			return AFTER*-1;
		}else if(thatCertificate==null){
			return BEFORE*-1;
		}else{
			return thisCertificate.compareTo(thatCertificate)*-1;
		}
	}
	
}
