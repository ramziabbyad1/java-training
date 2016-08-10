import java.util.Set;


public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private float salary;
	private Set<Certificate> certificates;
	public Employee(){}
	public Employee(String firstName, String lastName,
			float salary, Set<Certificate> certificates) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.certificates = certificates;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Set<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}
}
