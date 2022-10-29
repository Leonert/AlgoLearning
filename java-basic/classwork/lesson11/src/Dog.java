import java.util.Objects;

class Dog implements Comparable<Dog> {
	private final int size;

	Dog(int size) {
		this.size = size;
	}


	public int getSize() {
		return size;
	}


	public static void print() {
		System.out.println("dog");
	}

	@Override
	public String toString() {
		return "Dog{" +
				"size=" + size +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dog dog = (Dog) o;
		return size == dog.size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(size);
	}

	@Override
	public int compareTo(Dog o) {
		if (o.getSize() > size) return -1;
		if (o.getSize() < size) return 1;
		return 0;
	}
}
