package problem1;

class Grad extends Student{
	Grad(final String name, final int age, final double grade, final String address){
		super(name, age, grade, address);
	}
	@Override
	boolean isPassed(double grade) {
		if(grade >= 80){
			return true;
		}
		else{
			return false;
		}
	}
	
}
