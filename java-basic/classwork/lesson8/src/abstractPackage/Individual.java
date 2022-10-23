package abstractPackage;

public abstract class Individual {
	private String name;

	public String getName() {
		return name;
	}

	public Individual(String name) {
		this.name = name;
	}

	public abstract void display();
}
