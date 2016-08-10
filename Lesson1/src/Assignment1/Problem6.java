package Assignment1;
import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scanner = new Scanner(System.in);
		//int num = scanner.nextInt();
		int curr = 1;
		int prev = 0;
		int fib = 0;
		int i = 0;
		System.out.print(fib + " ");
		System.out.print(curr + " ");
		do {
			fib = curr+ prev;
			System.out.print(fib + " ");
			//System.out.print(prev + " ");
			prev = curr;
			curr = fib;
			i++;
		} while (i < 8);
		
	}

}
//prev = 0
//curr = 1


