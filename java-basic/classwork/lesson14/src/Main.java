import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface Converter<T, R> {
	R convert(T from);
}

@FunctionalInterface
interface HumanFactory<Human> {
	Human create(String name, List<String> friends);
}

public class Main {
	public static void main(String[] args) throws InterruptedException {

		Human human1 = new Human(null, Collections.emptyList());

		// Exception handling
		try {
			human1.getName2();
		} catch (MyException ex) {
			//log.write(WARNING)
			System.out.println("LITTLE ERROR");
		} finally {
			System.out.println("final");
		}


		// method reference
		// nameOfClass::nameOfMethod
		// pointerOnObject::nameOfMethod
		// name of class::new

		Converter<Integer, String> conv = String::valueOf;
		HumanFactory<Human> humanHumanFactory = Human::new;

		Human human2 = humanHumanFactory.create("asdnf", Collections.emptyList());
		System.out.println(human2);

		List<Human> humans = Arrays.asList(
				new Human("Sara", Arrays.asList("Archy", "Tom", "Buddy", "Tom2")),
				new Human("Artem", Arrays.asList("Sam", "Tom")),
				new Human("Maria", Arrays.asList("Archy", "Tom", "Buddy")));


		// removing
		humans.stream()
				.filter(human -> human.getName2().equals("Sara"))
				.map(human -> human.removeFriend(friend -> friend.startsWith("Tom")))
				.collect(Collectors.toList());

		System.out.println(humans);


		// 	{human - human - human}
		//	{list - list - list}   -> {list}
		List<String> friends = humans.stream() // создали поток людей
				.map(Human::getFriends)        // преобразовали поток из списка людей в список списков их друзей
				.flatMap(Collection::stream)   // развернули каждый список и соеднили с предыдущим (Stream<list<friends>> ---> Stream<friends>)
				.collect(Collectors.toList());


		List<Human> newList = humans.stream()
				.filter(human -> human.name.equals("Artem"))
				.map(human -> human.addFriend("NewName").addFriend("new NAME2"))
				.collect(Collectors.toList());

		newList.stream().forEach(System.out::println);


		Map<String, List<String>> mapFriendsOfCurrent = humans.stream()
				.collect(Collectors.toMap(human -> human.name, human -> human.getFriends()));

		List<String> friendsOfCurrent = mapFriendsOfCurrent.get("Artem");
		System.out.println(friendsOfCurrent);

		friendsOfCurrent = mapFriendsOfCurrent.get("Maria");
		System.out.println(friendsOfCurrent);

		friendsOfCurrent.add("newName");
		friendsOfCurrent.add(1, "NewFriend");
		System.out.println(friendsOfCurrent);


		// reduce
		String[] arr3 = new String[]{"a", "B", "B", "d", "d"};
		String product = Arrays.stream(arr3).reduce(String::concat).get();
		String uppers = Arrays.stream(arr3).reduce("", (acc, element) -> acc + element.toUpperCase());

		// distinct
		Arrays.stream(arr3).distinct().forEach(System.out::println);

		// findFirst
		System.out.println(Arrays.stream(arr3).findFirst());


		//Optional
		Human human = new Human("Name23", Arrays.asList("Archy", "Tom", "Buddy"));
		System.out.println(human.getName());
		String ourName = human.getName().orElse("stadnrt");
		//.ifPresent(value -> System.out.println("Found: " + value))

		if (human.getName().isPresent()) {
			String name = human.getName().get();
			System.out.println(name);
		}


		// findAny
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(8);
		lst.add(2);
		lst.add(6);
		System.out.println(lst.stream().filter(x -> x % 2 == 0).findAny().orElse(100));

		// 12 2 7 9   +   49 01  1   +    -9481 81247 12345
		// обработать поток интеджеров паралельно и не пралельно сравнив их время выполнения
		// внутри потока отфильтровать непарные и умножить каждый елемент на 2

		Random random = new Random();
		List<Integer> lstInt = new ArrayList<>();

		for (int i = 0; i < 100_000; i++) {
			lstInt.add(0, random.nextInt(1000));
		}

		timeCheckParallel(lstInt);
		timeCheck(lstInt);

		// parallel
		final List<Integer> integers = new ArrayList<>();
		IntStream.range(0, 100)
				.parallel()
				.forEach(i -> integers.add(i));  // error can be here

		Main main = new Main();
		main.doWork();


	}

	int counter = 0;

	// thread problem
	public void doWork() throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter = counter + 1;   // 101  // 102 103 104
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter = counter + 1;   // 101 // 102
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println(counter);
	}

	static void timeCheckParallel(List<Integer> lst) {
		long curr = System.nanoTime();
		lst.stream().parallel()
				.filter(x -> x % 2 == 0)
				.map(x -> x * 2)
				.collect(Collectors.toList());
		System.out.println("parallel:" + (System.nanoTime() - curr));
	}

	static void timeCheck(List<Integer> lst) {
		long curr = System.nanoTime();
		lst.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * 2)
				.collect(Collectors.toList());
		System.out.println("seq:" + (System.nanoTime() - curr));
	}
}