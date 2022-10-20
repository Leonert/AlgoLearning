package task1;

import java.util.Objects;

public class Engine {
	private final int size;
	private final int value;
	private String name;

	public Engine(int size, int value, String name) {
		this.size = size;
		this.value = value;
		this.name = name;
	}


	public int getSize() {
		return size;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Engine engine = (Engine) o;
		return size == engine.size && value == engine.value && Objects.equals(name, engine.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(size, value);
	}

	@Override
	public String toString() {
		return "Engine{" +
				"size=" + size +
				", value=" + value +
				", name='" + name + '\'' +
				'}';
	}
}
