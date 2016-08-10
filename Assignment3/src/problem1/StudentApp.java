package problem1;

class StudentApp {

	public static void main(String[] args) {
		Grad grad = new Grad("Ramzi", 27, 100, "132 Scholes Street Apartment 1B");
		Undergrad undergrad = new Undergrad("Philip", 21, 60, "12 5th Avenue");
		
		System.out.println("Graduate Student Info: ");
		System.out.println(grad);
		System.out.println("Passed? " + grad.isPassed(grad.getGrade()));
		
		System.out.println("Undergraduate Student Info: ");
		System.out.println(undergrad);
		System.out.println("Passed? " + undergrad.isPassed(undergrad.getGrade()));
	}

}
