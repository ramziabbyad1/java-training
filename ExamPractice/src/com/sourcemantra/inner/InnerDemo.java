package com.sourcemantra.inner;

public class InnerDemo {

	public static void main(String[] args) {
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass ic = oc.new InnerClass();
		

	}

}

class AnotherClass{
	final String name = "AnotherClass";
	private int memberId = 0;
	public String getName() {
		return name;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}

class OuterClass{
	static AnotherClass another = new AnotherClass();
	static private String ocMember = "OuterClass Member"; 
	private final int var = 0;
	int getVar(){
		return var;
	}
	static class StaticInnerClass{
		private String name ="static inner class";
		StaticInnerClass(){
			//System.out.println(var);
			System.out.println("Hello from "+name+" got the name for " + another.name + " in a static class.");
			another.setMemberId(10);
			dothing(10);
			System.out.println(name +" set the member id of " +another.name+" to " + another.getMemberId());
			System.out.println(name + " has access to " + ocMember);
		}
		public void dothing(int x){
			OuterClass oc = new OuterClass();
			System.out.println("Static reference through instantiation: " +oc.getVar());
		}
	}
	
	class InnerClass{
		private String name = "inner class";
		InnerClass(){
			System.out.println("variable " + var);
			System.out.println("Hello from "+name +" got the name for "+ another.name +" in an inner class.");
			another.setMemberId(50);
			dothing(0);
			System.out.println(name +" set the member id of "+another.name+" to " + another.getMemberId());
			//System.out.println();
		}
		
		public void dothing(int x){
			System.out.println(var);
			
		}
}
	
}
