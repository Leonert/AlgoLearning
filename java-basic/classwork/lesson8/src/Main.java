import abstractPackage.Employee;
import abstractPackage.Individual;
import inheritance.Animal;
import inheritance.animals.Cat;
import inheritance.animals.Dog;
import inheritance.animals.Pup;
import interfaces.Bird;
import interfaces.Flyable;
import interfaces.WithLegs;
import test.Ball;
import test.Foot;

// public PROTECTED package private

public class Main {
	public static void main(String[] args) {
//		BankAccount account = new BankAccount();
//
//		account.putMoney(1000);
//
//		account.showBalance();


//		Animal animal = new Animal();
//		animal.sound();
//		System.out.println(animal);
//
//		Dog dog = new Dog();
//		dog.sound();
//		dog.live();
//		System.out.println();
//
//		Cat cat = new Cat();
//		cat.liveCat();
//		cat.sound();
//
//
//		getAnimalSound(animal);
//		getAnimalSound(dog);
//		getAnimalSound(cat);

//		Pup pup = new Pup();
//		pup.puppy();
//		System.out.println();
//		pup.sound();
//		System.out.println();
//		pup.live();
//
//		Animal animal1 = new Pup();
//		Dog dog1 = new Dog();
//		Cat cat1 = new Cat();
//
//		System.out.println(animal1 instanceof Animal);
//		System.out.println(dog1 instanceof Dog);
//		System.out.println(cat1 instanceof Animal);
//

//		Individual individual = new Employee("jhon");
//		System.out.println(individual.getName());
//		individual.display();

		Bird bird = new Bird();
		bird.fly2();

		Flyable.staticFLy();


		Ball ball = new Ball("spelding");

		Foot foot = new Foot(ball);
		System.out.println(foot);


	}

	static void getAnimalSound(Animal animal) {
		animal.sound();
	}

	void add(int a, int b) {
		System.out.println(a + b);
	}

	void add(byte a, byte b) {
		System.out.println(a + b);
	}

	void add(double a, double b) {
		System.out.println(a + b);
	}
}