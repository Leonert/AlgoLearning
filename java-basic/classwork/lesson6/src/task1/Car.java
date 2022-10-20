package task1;

import java.util.Objects;

public class Car {
	private final Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(engine, car.engine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(engine);
	}

	@Override
	public String toString() {
		return "Car{" +
				"engine=" + engine +
				'}';
	}
}
