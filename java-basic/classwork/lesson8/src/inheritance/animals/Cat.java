package inheritance.animals;

import inheritance.Animal;

public class Cat extends Animal {

	public Cat() {
		super();
	}

	public void liveCat() {

		System.out.println("CAT");
	}

	@Override
	public void sound() {
		super.sound();
		System.out.println("MYAu");
	}
}
