public class Cat {

	private final int size;
	private final String color;

	public Cat(int size, String color) {
		this.size = size;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"size=" + size +
				", color='" + color + '\'' +
				'}';
	}
}
