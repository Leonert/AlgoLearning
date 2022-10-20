package house;

import cars.Car;

import java.util.Objects;

public class House {
	private final int length;      // длина дома (целочисленное)
	private int floors;      // количество этажей (целочисленное)
	private String color;  // цвет дома (строка)

	private Car car;

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
		//this.car = new Car();
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
				"length=" + length +
				", floors=" + floors +
				", color='" + color + '\'' +
				", car=" + car +
				'}';
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println("END");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		House house = (House) o;
		return length == house.length && floors == house.floors && Objects.equals(color, house.color);
	}

	@Override
	public int hashCode() {
		return Objects.hash(length, floors, color, car);
	}



	/*
	Реализовать два класса Car Engine
	Полем класса Car является класс Engine
    Поля класса Engine придумать самим (2 постоянных одно переменное)
    Написать конструкторы сеттеры(где нужно) геттеры.
    Переопределять equals hashcode toString
    В мейне вызвать
	 */
}
