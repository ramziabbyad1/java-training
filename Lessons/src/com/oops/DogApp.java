package com.oops;

public class DogApp {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("Ramdas");
		dog.setAge(10);
		dog.show();
		int i = 10;
		System.out.println(i);
		//below will by default call the toString() method
		System.out.println(dog);
		
		Dog dog2 = new Dog("Tommy", 7);
		System.out.println(dog2);
		
		Dog dog3 = new Dog("Moti");
		System.out.println(dog3);
		dog.age = 2;
		dog3.eat();
		dog3.eat("pizza");
		dog3.eat("fish");
		dog3.eat();
		dog3.eat();
		dog3.eat();
		
	}

}
