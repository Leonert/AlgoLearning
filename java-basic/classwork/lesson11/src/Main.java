import monitoring.Monitoring;
import patternDaoServiceController.User;
import patternDaoServiceController.UserController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {

		// TreeSet
		// "abcde" "cdef" "bcd"

		// Создать три сет заполнить его этими данными и написать второй три сет который отсортирует по длинне
		// bcd cdef abcde

		// Использовать анонимный класс (не лямбду)
		Set<String> ourSet = new TreeSet<>();

		ourSet.add("abcde");
		ourSet.add("cdef");
		ourSet.add("bcd");

		System.out.println(ourSet);

		TreeSet<String> ourSet2 = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o2.length(), o1.length());
			}
		});

		ourSet2.addAll(ourSet);
		System.out.println(ourSet2);


		TreeSet<Dog> set = new TreeSet<>();

		set.add(new Dog(6));
		set.add(new Dog(2));
		set.add(new Dog(2));
		set.add(new Dog(1));

		System.out.println(set);

		for (Dog dog : set) {

			System.out.println(dog);
		}


		// Anonymous classes
		Monitoring general = new Monitoring() {
			@Override
			public void startMonitoring() {
				System.out.println("General monitoring");
				endMonitoring();
			}

			private void endMonitoring() {
				System.out.println("End monitoring");
			}
		};


		Monitoring local = new Monitoring() {
			@Override
			public void startMonitoring() {
				System.out.println("Local monitoring");
			}
		};

		general.startMonitoring();
		local.startMonitoring();


		// Generics Wildcards
		List<Pet> pets = new ArrayList<>();
		pets.add(new Pet());
		pets.add(new Pet());
		pets.add(new Pet());

		List<Cat> cats = new ArrayList<>();
		cats.add(new Cat(2));
		cats.add(new Cat(3));
		cats.add(new Cat(2));

		printList(pets);
		printList(cats);

		List<Cat> cats2 = new ArrayList<>();
		List<Animal> animals = new ArrayList<>();
		List<Kitty> kitties = new ArrayList<>();
		//cats.addAll(animals);


		// Unmodifiable
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);

		lst = Collections.unmodifiableList(lst);
		// lst.add(5);
		// lst.remove(2);
		System.out.println(lst);

		List<Integer> lst2 = new ArrayList<>(lst);
		lst2.add(4);
		System.out.println(lst2);


		// DAO SERVICE CONTROLLER
		UserController userController = new UserController();

		System.out.println(userController.getUsers());
		userController.addUser(new User(1, "Ivan", "Petro"));
		System.out.println(userController.getUsers());

	}


	public static <T> void copy(List<? super T> where, List<? extends T> from) {
		for (int i = 0; i < from.size(); i++) {
			where.set(i, from.get(i));
		}
	}

	private static void printList(List<? extends Animal> list) {
		System.out.println(list);
	}

}