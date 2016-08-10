package Assignment1;
import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		//factorial of a number
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int key = scanner.nextInt();
		int i = 1;
		int factorial = 1;
		while(i <= key){
			factorial = i*factorial;
			i++;
		}
		
		System.out.println("The factorial of " + key + " is " + factorial);
	}

}
