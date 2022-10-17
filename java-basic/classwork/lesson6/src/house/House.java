package house;

public class House {
	private int length;      // длина дома (целочисленное)
	private int floors;      // количество этажей (целочисленное)
	private String color;    // цвет дома (строка)

	public House() {
		this(10, 10, "white");
	}

	// secondary
	public House(String color) {
		this(10, 10, color);
	}

	// primary
	public House(int length, int floors, String color) {
		this.length = length;
		this.floors = floors;
		this.color = color;
	}

	public void printSomething(String name) {
		System.out.println(name);
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		if (floors == 0) {
			System.out.println("0 этажей не бывает");
			// error;
			return;
		}
		this.floors = floors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "House{" +
				", length=" + length +
				", floors=" + floors +
				", color='" + color + '\'' +
				'}';
	}
}
