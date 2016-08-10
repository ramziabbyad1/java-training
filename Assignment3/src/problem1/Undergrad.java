package problem1;

class Undergrad extends Student{
	Undergrad(final String name, final int age, final double grade, final String address){
		super(name, age, grade, address);
	}
	@Override
	boolean isPassed(double grade) {
		if(grade >= 70){
			return true;
		}
		else{
			return false;
		}
		
	}

}
