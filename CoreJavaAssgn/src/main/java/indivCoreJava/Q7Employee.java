package indivCoreJava;

public class Q7Employee {
	int age;
	String name;
	String department;
	
	public Q7Employee(int age, String name, String department) { //This constructs the Employee objects for Q7.
		this.age = age;
		this.name = name;
		this.department = department;
	}
	public String toString() { //This prints details to driver.
		return this.age + ", " + this.name + ", " + this.department + ".";
	}
}
