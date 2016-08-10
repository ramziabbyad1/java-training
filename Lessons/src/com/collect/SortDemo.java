package com.collect;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("John", "Doe", 28));
		students.add(new Student("Jane", "Doe", 26));
		students.add(new Student("Java", "Guru", 30));
		students.add(new Student("Carol", "Smith", 37));
		students.add(new Student("Carol", "Taylor", 23));
		System.out.println("---------Unsorted---------");
		for(Student s:students){
			System.out.println(s);
		}
		System.out.println("---------Sorted---------");
		Collections.sort(students);
		for(Student s:students){
			System.out.println(s);
		}
		
		System.out.println("--------firstNameSorted--------");
		Collections.sort(students, new FirstNameComparator());
		for(Student s:students){
			System.out.println(s);
		}
		
		System.out.println("--------lastNameSorted--------");
		Collections.sort(students, new LastNameComparator());
		for(Student s:students){
			System.out.println(s);
		}
	}

}
