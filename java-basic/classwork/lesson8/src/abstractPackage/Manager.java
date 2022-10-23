package abstractPackage;

public class Manager extends Individual {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void display() {
		System.out.println("Manager");
	}
}
