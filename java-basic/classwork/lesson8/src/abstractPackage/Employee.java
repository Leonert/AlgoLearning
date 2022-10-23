package abstractPackage;

public class Employee extends Individual {

	public Employee(String name) {
		super(name);
	}

	@Override
	public void display() {
		System.out.println("Employee");
	}
}
