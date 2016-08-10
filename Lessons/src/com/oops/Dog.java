package com.oops;

public class Dog {
	private String name;
	int age;
	private boolean hungry = true;
	private int time = 0;
	
	public Dog(){
		
	}
	
	public Dog(String name){
		this.name = name;
		this.age = 1;
	}
	
	public Dog(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void addTime(){
		time++;
	}
	
	public void eat(String food){
		addTime();
		
		if(time%3 == 0){
			setHungry(false);
			System.out.println("Thanks for the " + food);
		}else{
			setHungry(true);
			System.out.println("No, I'm full");
		}
	}
	
	public void eat(){
		addTime();
		
		if(time%3 == 0){
			setHungry(false);
			System.out.println("Thanks for the food.");
		}else{
			setHungry(true);
			System.out.println("No, I'm full");
		}
	}
	
	public boolean isHungry(){
		if(hungry) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	private void setHungry(boolean hungry){
		this.hungry = hungry;
	}
	
	public void setName(String name){
		this.name = name;
	}
		
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " " + getAge();
	}

	void show(){
		System.out.println("Name : " + getName());
		System.out.println("Age : " + getAge());
	}
}
