import java.io.Serializable;

public class Person implements Serializable {
	public final String name;
	public final int age;
	public final double weight;
	public final boolean married;

	public Family family;

	public Person(String name, int age, double weight, boolean married, Family family) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.married = married;
		this.family = family;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", weight=" + weight +
				", married=" + married +
				", family=" + family +
				'}';
	}
}
