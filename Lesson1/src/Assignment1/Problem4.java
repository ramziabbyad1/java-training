package Assignment1;
import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		//
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number for the table");
		int key = scanner.nextInt();
		
		for(int i = 0; i < key; i++){
			for(int j = 0; j < key; j++){
				System.out.print((i+1)*(j+1) + " ");
			}
			System.out.println();
		}
		
	}

}
