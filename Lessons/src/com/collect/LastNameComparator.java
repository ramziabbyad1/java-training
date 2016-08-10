package com.collect;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getLastName().equals(s2.getLastName())){
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
		else{
			return s1.getLastName().compareTo(s2.getLastName());
		}
	}
	

}
