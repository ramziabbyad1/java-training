package com.oops;

public class PersonApp {
		// TODO Auto-generated method stub
		public int i = 0;
		public static int j = 0;
		public PersonApp(){
			i++;
			j++;
		}
		void show(){
			System.out.println("i= " + i);
			System.out.println("j= " + j);
		}
		public static void main(String args[]){
			PersonApp obj1 = new PersonApp();
			System.out.println("---obj1----");
			obj1.show();
			PersonApp obj2 = new PersonApp();
			System.out.println("----obj2---");
			obj2.show();
			System.out.println("-----obj1----");
			obj1.show();
		}

}
