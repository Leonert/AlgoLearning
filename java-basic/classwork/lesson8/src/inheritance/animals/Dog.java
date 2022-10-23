package inheritance.animals;

import inheritance.Animal;

public class Dog extends Animal {
	final public void live() {
		System.out.println("Dog alive");
	}

	@Override
	public void sound() {
		System.out.println("GAV");
	}
}


// Human   -> Boss  ->   Manager  ->   Employee

// live()   work()     documents()    writeCode()

// in main check all 4 objects