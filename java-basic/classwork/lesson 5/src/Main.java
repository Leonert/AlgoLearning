import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		method("Name");
		method("Name", "Surname");
		method("Name", "Name", "Name", "Name", "Name", "Name");
		method();
	}


	static void method(Object... data) {  // String[] data
		System.out.println(Arrays.toString(data));
	}


	/*
	   Метод сортирует массив int и вы можете указать направление
	 */
	static void sort(int[] arr, boolean asc) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (compare(arr[j], arr[j + 1], asc)) {
					int a = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = a;
				}
			}
		}
	}

	static boolean compare(int num1, int num2, boolean asc) {
		return asc ? num1 > num2 : num1 < num2;
	}


//	ternary

//	if(true)
//		return
//	else
//		return

	static String tern(String a) {
		return a.equals("true") ? "true" : "false";
	}

	static void sort(int[] arr, String type) {
		if (type.equals("asc")) {
			sortAscending(arr);
		} else if (type.equals("desc")) {
			sortDescending(arr);
		} else {
			System.out.println("Unsupported");
		}
	}

	private static void sortDescending(int[] arr) {
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					a = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = a;
				}
			}
		}
	}

	private static void sortAscending(int[] arr) {
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					a = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = a;
				}
			}
		}
	}


	/*
		Создать калькулятор на свич. Создать метод для каждой операции.
	 */
	static float calculate(int num1, int num2, String op) {
		switch (op) {
			case "+":
				return add(num1, num2);
			case "-":
				return sub(num1, num2);
			case "*":
				return mul(num1, num2);
			case "/":
				return div(num1, num2);
			default:
				return 0;
		}
	}

	static float add(int num1, int num2) {
		return num1 + num2;
	}

	static float sub(int num1, int num2) {
		return num1 - num2;
	}

	static float mul(int num1, int num2) {
		return num1 * num2;
	}

	static float div(int num1, int num2) {
		if (num2 == 0) return 0;
		return (float) num1 / num2;
	}


	/*
		Метод принимает два числа возвращает их сумму
	 */
	static int getCalculatedNumbers(int num1, int num2) {
		return num1 + num2;
	}


	/*
		Метод принимает массив и выводит его в консоль
     */
	static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/*
		Метод принимает два числа и выводит уведомление о том, какое больше если числа одинаковые
		уведомление что числа равны
     */
	static void compareTwoNumbers(int num1, int num2) {
		if (num1 > num2) {
			System.out.println(num1 + ">" + num2);
		} else if (num2 > num1) {
			System.out.println(num2 + ">" + num1);
		} else {
			System.out.println("They are equals");
		}

	}


//	for
//	   for
//	     break;
//	   <-------
//	     return;
//<------------


//	выход из 2 циклов
//	for (; ; ) {
//		boolean n = false;
//		for (; ; ) {
//			if () {
//				n = true;
//				break;
//			}
//		}
//		if (n == true) break;
//	}


}