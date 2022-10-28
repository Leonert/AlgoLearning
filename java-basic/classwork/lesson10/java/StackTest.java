package main.java;

public class StackTest {
	private int arr[];
	private int top;
	private int capacity;

	// Constructor to initialize the stack
	public StackTest(int size) {
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	// Utility function to add an element `x` to the stack
	public void push(int x) {
		if (isFull()) {
			System.out.println("Stack is full");
			System.exit(-1);
		}
		top += 1;
		arr[top] = x;
	}

	// 4 2 1 6 7

	// Utility function to pop a top element from the stack
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack empty");
			System.exit(-1);
		}

		return arr[top--];
	}

	// Utility function to return the top element of the stack
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack empty");
			System.exit(-1);
		}

		return arr[top];
	}

	// Utility function to return the size of the stack
	public int size() {
		return top + 1;
	}

	// Utility function to check if the stack is empty or not
	public boolean isEmpty() {
		return top == -1;
	}

	// Utility function to check if the stack is full or not
	public boolean isFull() {
		return top == capacity - 1;
	}

	@Override
	public String toString() {

		for (int i = 0; i < size(); i++) {
			System.out.printf("%d ", arr[i]);
		}
		return "";
	}
}
