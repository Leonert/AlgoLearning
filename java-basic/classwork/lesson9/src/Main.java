import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("name");
		System.out.println(arrayList.size());

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

		System.out.println();

		arrayList.add("surname");
		System.out.println(arrayList.size());

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println();

		arrayList.add("three");
		System.out.println(arrayList.size());

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

		arrayList.add(1, "one");
		System.out.println(arrayList.size());

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}


		LinkedList<String> linkedList = new LinkedList<>();

		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		linkedList.add(3, "123456");


		for (String i : linkedList) {
			System.out.println(i);
		}


//		 написать функцию которая возвращает время потраченное на доступ к рандомному индексу внутри списка из 100_000 елементов
//		 внутри функции проверить доступ к елементу 10000 раз


		ArrayList<Integer> arrayList1 = new ArrayList<>();
		LinkedList<Integer> linkedList1 = new LinkedList<>();
		Random random = new Random();


		final int n = 10000000;
		final int m = 1000;

		for (int i = 0; i < n; i++) {
			arrayList1.add(random.nextInt(100));
			linkedList1.add(random.nextInt(100));
		}

		getTime(arrayList1, m, n);
		getTime(linkedList1, m, n);

		LinkedList<Integer> lst = new LinkedList<>(arrayList1);


		LinkedList<String> linkedList3 = new LinkedList<>();

		linkedList3.add("1");
		linkedList3.add("1");
		linkedList3.add("1");
		linkedList3.add("1");
		linkedList3.add("1");
		System.out.println(linkedList3);

		HashSet<String> hashSet = new HashSet<>();

		hashSet.add("1");
		hashSet.add("1");
		hashSet.add("2");
		hashSet.add("1");
		hashSet.add("1");
		System.out.println(hashSet);


		Map<Integer, String> map = new HashMap<>();

		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");

		System.out.println(map.get(5));

		Cat cat = new Cat(10, "black");
		Integer a = new Integer(4);
		String str = "asdfg";

		Generics<Integer, Cat, String> generic = new Generics<>(a, cat, str);

		generic.show();

		List<Cat> cats = new ArrayList<>();

		cats.add(new Cat(10, "black"));
		cats.add(new Cat(5, "white"));
		cats.add(new Cat(2, "green"));

		System.out.println(cats);


		Map<Cat, String> map1 = new HashMap<>();

		map1.put(cat, "OUR CAT");

		System.out.println(map1.get(new Cat(10, "black")));


		String asdf = new String("asdf");
		String asdf1 = new String("asdf");

		System.out.println(asdf1 == asdf);
//
//		Integer i = new Integer(125);
//		Integer i2 = new Integer(125);
//
//		System.out.println(i == i2);


		Float f = 10.0f;
		Double d = 10.0;

		Integer integer = null;

		int b = integer == null ? 0 : integer.intValue();

		Integer integer2 = new Integer((int) (123.0));
		System.out.println(integer2);

	}

	public static void getTime(List<Integer> list, int m, int n) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < m; i++) {
			list.remove(50);
		}
		System.out.println(list.getClass() + ": " + (System.currentTimeMillis() - startTime));
	}


}