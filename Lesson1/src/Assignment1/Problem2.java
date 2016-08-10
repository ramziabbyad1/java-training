package Assignment1;
import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		//input 3 grades
		Scanner scanner = new Scanner(System.in);
		
		double grades[] = new double[3];
		//String str;
		boolean fail = false;
		double total = 0;
		double avg = 0;
		
		for(int i = 0; i < 3; i++){
			System.out.println("Enter grade for subject " + (i+1) + ": ");
			//str = scanner.next();
			grades[i] = scanner.nextDouble();
			if(grades[i] < 35){
				fail = true;
			}
			total += grades[i];
		}
		
		avg = total/3;
		System.out.println("Total marks: " + total);
		System.out.println("Average marks: " + avg);
		
		if(fail){
			System.out.println("You failed.");
		}else{
			//System.out.println("You passed.");
			if(avg > 80){
				System.out.println("You passed with an A!");
			}else if(avg > 70){
				System.out.println("You passed with an B!");
			}else if(avg > 60){
				System.out.println("You passed with an C!");
			}else if(avg > 50){
				System.out.println("You passed with an D!");
			}else if(avg >= 35){
				System.out.println("You passed with an E!");
			}
		}
		
		
		
		
		
		

	}

}
