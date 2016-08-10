package Assignment1;

public class ArrayDemo {

	public static void main(String[] args) {
		String[][] states = new String[3][2];
		states[0][0] = "New Jersey";
		states[0][1] = "Trenton";
		states[1][0] = "California";
		states[1][1] = "sacramento";
		states[2][0] = "New York";
		states[2][1] = "Albany";
		int k = 0;
		for(String[] i:states){
			System.out.println();
			System.out.print("The capital city of ");
			for(String j:i){
				k++;
				System.out.print(j);
				if((k+1)%2 == 0){
					System.out.print(" is ");
				}
			}
			
		}

	}

}
