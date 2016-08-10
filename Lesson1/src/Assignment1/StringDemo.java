package Assignment1;

public class StringDemo {

	public static void main(String[] args) {
		// JVM uses "string interning" to optimize memory allocation, this is fine since strings are immutable
		String str1 = "Hello";
		String str2 = "Hello";
		if(str1 == str2){
			System.out.println("str1 == str2");
		}
		else{
			System.out.println("str1 != str2");
		}
		
		str1 = "Hello";
		str2 = new String("World");
		
		if(str1 == str2){
			System.out.println("str1 == str2");
		}
		else{
			System.out.println("str1 != str2");
		}
		if(str1.equals(str2)){
			System.out.println("str1==str2");
		}
		else{
			System.out.println("str1!=str2");
		}
		str1 += str2;
		System.out.println(str1);
		//equivalent to str1.concat(str2)
		String str = str1 + str2;
		System.out.println(str1);
		
		System.out.println(str1.charAt(4));
		System.out.println(str1.indexOf("e"));
		//uses valueOf() method from string class to cast to a String
		int i =10;
		System.out.println("i="+i);
		//can create null string
		StringBuilder sb1 = new StringBuilder();
		System.out.println(sb1);
		sb1 = new StringBuilder("Source Mantra");
		System.out.println(sb1.length());
		StringBuilder sb2 = new StringBuilder("South Plainfield");
		sb1.append(sb2);
		System.out.println(sb1.length());
		
		sb1.

	}

}
