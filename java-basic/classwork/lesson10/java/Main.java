package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {

		Man man1 = new Man();
		man1.imMan();
		man1.imHuman();

		// Upcasting
		Human man = new Man();
		Human human = man1;

		//Human human2 = new Human();
		// Downcasting
		Man man2 = (Man) human;
		man2.imMan();


		Human human2 = returnChild(2);
		System.out.println(returnChild(2).getClass());
		((Woman) human2).imWoman();




		// Map
		Random random = new Random();
		Map<Man, String> map = new HashMap<>();

		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			map.put(new Man(i++), "abc");
		}

		for (int i = 0; i < 10000; i++) {
			map.get(random.nextInt(10000));
		}
		System.out.println(System.currentTimeMillis() - time);




		// Stack
		Stack<String> stack = new Stack<>();

		stack.push("first book");
		stack.push("second book");
		stack.push("third book");
		stack.push("last book");

		System.out.println(stack);

		System.out.println(stack.search("third book"));

		System.out.println(stack.empty());

		System.out.println(stack.peek());
		System.out.println(stack);

		System.out.println(stack.pop());
		System.out.println(stack);

		System.out.println(stack.pop());
		System.out.println(stack);

		System.out.println(stack.pop());
		System.out.println(stack);

		System.out.println(stack.pop());
		System.out.println(stack);

		if (!stack.empty()) {
			stack.pop();
		} else {
			System.out.println("Stack is empty");
		}




		// Task stack
		StackTest stc = new StackTest(5);
		System.out.println(stc);

		stc.push(13);
		stc.push(11);
		stc.push(12);
		stc.push(10);
		stc.push(15);
		stc.push(15);

		System.out.println(stc);

		System.out.println(stc.pop());
		System.out.println(stc.pop());
		System.out.println(stc.pop());
		System.out.println(stc);
		System.out.println();

		stc.push(100);
		System.out.println(stc.peek());
		System.out.println(stc);




		// Set
		Set<Man> set = new HashSet<>();

		set.add(new Man(5));
		set.add(new Man(1));
		set.add(new Man(123));
		set.add(new Man(12341));
		set.add(new Man(12356));

		for (Man man4 : set) {
			System.out.println(man4);
		}

		System.out.println(set);


		Set<Man> set1 = new LinkedHashSet<>();
		set1.add(new Man(5));
		set1.add(new Man(1));
		set1.add(new Man(123));
		set1.add(new Man(12341));
		set1.add(new Man(12356));

		for (Man man3 : set1) {
			System.out.println(man3);
		}

		System.out.println(set1);


		TreeSet<Integer> set2 = new TreeSet<>();
		set2.add(1);
		set2.add(5);
		set2.add(3);
		set2.add(7);
		set2.add(2);

		for (Integer integer : set2) {
			System.out.println(integer);
		}

		System.out.println(set2);






		// Queue
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(4, null);

		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);

		System.out.println(queue);

		queue.remove();
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		queue.remove();

		System.out.println(queue);


		// создать очередь из 10 чисел которые могу повторяться
		// получить коллекцию без повторяемых чисел


		Queue<Integer> que2 = new PriorityQueue<>(5);

		que2.add(1);
		que2.add(2);
		que2.add(2);
		que2.add(3);
		que2.add(3);
		que2.add(3);
		que2.add(4);
		que2.add(4);
		que2.add(5);
		que2.add(5);

		System.out.println(que2);
		System.out.println(new HashSet<>(que2));





		// Deque
		Deque<Integer> deque = new ArrayDeque<>();

		deque.add(100);
		deque.add(123);
		deque.add(250);

		System.out.println(deque);

		deque.removeFirst();
		System.out.println(deque);

		deque.removeLast();
		System.out.println(deque);
	}


	public static Human returnChild(int i) {
		return i < 1 ? new Man() : new Woman();
	}

}