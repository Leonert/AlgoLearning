import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// functional interface
interface Executable {
	int execute(double asd, int cad);
}


class Runner {
	public void run(Executable e) {
		System.out.println(e.execute(1, 1));
	}
}

public class Main {
	public static void main(String[] args) {
		Runner runner = new Runner();

		final int temp = 5;

		runner.run(new Executable() {
			@Override
			public int execute(double asd, int cad) {
				int temp = 10;
				return (int) asd + cad + temp;
			}
		});

		runner.run((a, b) -> {
			//int temp2 = 10;
			return (int) a + b + temp;
		});


		// написать сет который сортирует строки по длинне

		Set<String> set = new TreeSet<>();
		set.add("abcde");
		set.add("bcdd");
		set.add("cdedde");
		System.out.println(set);

		TreeSet<String> set2 = new TreeSet<>((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		set2.addAll(set);
		System.out.println(set2);

		List<String> lst = new ArrayList<>();
		lst.add("abcde");
		lst.add("bcdd");
		lst.add("cdedde");

		System.out.println(lst);
		lst.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(lst);




		// Stream API
		int[] arr = new int[10];
		List<Integer> list = new ArrayList<>();

		fillArray(arr);
		fillArray(list);

		System.out.println(Arrays.toString(arr));
		System.out.println(list);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 2;
		}

		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i) * 2);
		}
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.entrySet().stream().map(entry -> entry.getKey());



		// map
		arr = Arrays.stream(arr).map(element -> element * 2).toArray();
		list = list.stream().map(element -> element * 3).collect(Collectors.toList());

		arr = Arrays.stream(arr).map(element -> 3).toArray();
		list = list.stream().map(element -> element + 1).collect(Collectors.toList());


		int[] arr1 = new int[10];
		List<Integer> list1 = new ArrayList<>();
		fillArray(arr1);
		fillArray(list1);

		// filter
		arr1 = Arrays.stream(arr1).filter(element -> element % 2 == 0).toArray();
		long resultSize = list1.stream().filter(element -> element % 2 != 0).count();

		System.out.println(resultSize);


		// for each
		list1.stream().forEach(x -> {
			if (x % 2 != 0) System.out.println(x);
		});


		// Array -> 1 2 3 4 5 6 7 8 9 10  -> 1 3 5 7 9 -> 5 15 25 35 45

		list1.stream()
				.filter(e -> e % 2 != 0)
				.map(e -> e * 5)
				.forEach(System.out::println);


		// List<String> -> колво строк начинающихся на "ab"

		List<String> strLst = new ArrayList<>();
		strLst.add("abcde");
		strLst.add("xscde");
		strLst.add("abcdasd");
		strLst.add("asdfgcde");
		strLst.add("absdfg");

		System.out.println(strLst.indexOf("abcde"));

		long sizeOfAb = strLst.stream()
				.filter(str -> str.startsWith("ab"))
				.count();

		strLst.stream()
				.filter(str -> str.startsWith("ab"))
				.forEach(System.out::println);

		// strLst.stream().forEach(el -> System.out.println(strLst.indexOf(el) + " " + el));

		System.out.println(sizeOfAb);


		List<User> users = new ArrayList<>();

		users.add(new User(1, 24, "Sara", "Lara"));
		users.add(new User(2, 11, "Masha", "Pasor"));
		users.add(new User(3, 41, "Dara", "Dominut"));
		users.add(new User(4, 11, "Artem", "Lori"));
		users.add(new User(5, 99, "Sasha", "Okay"));
		users.add(new User(6, 31, "Katya", "Some"));

		// вывести с помощью стримов юзеров по возрастанию возраста

		users.stream()
				.sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
				.forEach(System.out::println);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();


		// добавить к каждому имени в конец возраст "Sara24" и вывести
		// количество людей у которых новое имя больше 6 символов

		System.out.println(users
				.stream()
				.map(u -> new User(u.getId(), u.getAge(), u.getName() + u.getAge(), u.getSurname()))
				.filter(u -> u.getName().length() > 6)
				.count());


		User user = new User(10, 10, "Name", "Surname");
		System.out.println(user);


		// fluent interface
		user.setId(11).setAge(12).setName("Name2").setSurname("Name2");
		System.out.println(user);

	}

	static void fillArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}

	static void fillArray(List<Integer> lst) {
		for (int i = 0; i < 10; i++) {
			lst.add(i + 1);
		}
	}

	// (int a) -> { return a + 4; };

	static int method(int a) {
		return a + 4;
	}


	static void a() {
		System.out.println("a");
		b();
	}

	static void b() {
		System.out.println("b");
		a();
	}

}