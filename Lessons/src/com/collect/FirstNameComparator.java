package com.collect;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getLastName().equals(s2.getLastName())){
			return 0;
		}
		else{
			return s1.getLastName().compareTo(s2.getLastName());
		}
		
	}



}
