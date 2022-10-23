package test;

public class Ball {
	private String name;

	public Ball(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ball{" +
				"name='" + (name != null ? name.toString() : "null")  + '\'' +
				'}';
	}
}
