package inheritance;

import java.util.Objects;

public class Animal {

	int size;  // inheritance
	private int sizePrivate;  // in class
	protected int sizeProtected;  //
	final int a = 10;

	public Animal() {

	}

	public void sound() {
		System.out.println("SOUND");
	}

}
