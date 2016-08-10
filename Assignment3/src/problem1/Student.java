package problem1;

abstract class Student {
	private String name;
	private int id;
	private int age;
	private double grade;
	private String address;
	private static int count = 0;
	Student(final String name, final int age, final double grade, final String address){
		count++;
		this.name = name;
		this.id = count;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}
	
	final protected String getName() {
		return name;
	}

	final protected void setName(String name) {
		this.name = name;
	}

	final protected int getId() {
		return id;
	}

	final protected void setId(int id) {
		this.id = id;
	}

	final protected int getAge() {
		return age;
	}

	final protected void setAge(int age) {
		this.age = age;
	}

	final protected double getGrade() {
		return grade;
	}

	final protected void setGrade(double grade) {
		this.grade = grade;
	}

	final protected String getAddress() {
		return address;
	}

	final protected void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age
				+ ", grade=" + grade + ", address=" + address + "]";
	}

	abstract boolean isPassed(double grade);
}
