import java.io.Serializable;

public class Family implements Serializable {
	String name;

	Family(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Family{" +
				"name='" + name + '\'' +
				'}';
	}
}
