//input process output
import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		//Out is an object of PrintStream class
		//System is a class
		//declaration
		//datatype variable name;
		int i = 10;
		byte b = 25;
		short s= 1020;
		float f = 10.25f;
		double d = 100.50;
		System.out.println("Hello World");
		//operator overloading
		System.out.println("i=" + i);
		System.out.println("b=" + b);
		System.out.println("f=" + f);
		System.out.println("d=" + d);
		s = b;
		System.out.println("s="+s);
		s = 255;
		b = (byte) s;
		System.out.println("b=" + b);
		System.out.println(i);
		
		byte b1 = 0;
		short s1= 0;
		float f1 = 0;
		double d1 = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("input byte b1 = ");
		b1 = scanner.nextByte();
		
		char c1 = ' ';
		System.out.println("Input char c: ");
		String str = scanner.next();
		c1 = str.charAt(0);
		System.out.println("c = " + c1);
		i = b+s;
		
		
	}
	
	/*1)Write a program to calculate the commission of a salesman when sale amount is 
	 * given as input.  If the sale amount is greater than 10000 then commission is 
	 * 20% of sale amount else the commission is 10% of sale amount (use simple if/else)
	 * 2)Write a program to calculate the total marks and average of a student appearing
	 * for test in 3 subjects.  The program should display the result "Pass" if marks in
	 * all 3 subjects are above 35 else "Fail".  The program should also display the 
	 * grade as follows:
	 * 
	 * Avg	>80		>70		>=60	>=50	>=35	<35
	 * Grade	A	B	C	D	E	F
	 * Grade is F if the student has marks <35 in any one or more subjects.
	 * (use else if)
	 * 
	 * 3)Write a program to display the name of the day when a number (1to7) is input
	 * from keyboard using switch statement.
	 * 
	 *  4)Write a program to display the multiplication table of a given number using 
	 *  for loop.
	 *  
	 * 5)Write a program to display the factorial of a given number using while loop
	 * 
	 *6) Write a program to idsplay the first 10 elements of a fibonacci series using
	 * do...while loop (0,1,1,2,3,5,8,13,21,34).
	 * */
}
