package Assignment1;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		//Accept a dollar amount from StdIn
		//try{
		Scanner scanner = new Scanner(System.in);
		//}catch()
		System.out.println("Enter the sale amount: ");
		//String str = scanner.next();
		
		double sale = scanner.nextDouble();
		double comish;
		
		if(sale >= 10000){
			comish = .2*sale;
		}else{
			comish = .1*sale;
		}
		
		System.out.println("Your comission is: " + comish);
		
		//System.out.println("Read back sale... " + sale);
		
		

	}

}
