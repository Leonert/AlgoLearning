import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		// task 1
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input name: ");
		String name = scanner.nextLine();

		System.out.println("Input surname: ");
		String surname = scanner.nextLine();

		System.out.println("Input year: ");

		int year = 0;
		if (scanner.hasNextInt()) {
			year = scanner.nextInt();
		}

		System.out.printf("USER: %c ? %c ? %d", name.charAt(0), surname.charAt(0), 2022 - year);

		scanner.close();


		// if else

		boolean a1 = true;
		boolean a2 = false;
		boolean a3 = true;

		// && || !

		// true && true && true == true
		// true && false && true == false

		// true || true || true == true
		// false || false || true || false = true

		//!   !true = false


		if (a1 == true && a3 == true) {
			System.out.println(" a < 15 ");
		} else {
			System.out.println(" a >= 15");
		}


//		[	a <= 5
//		(   a < 5

		// true && true || true  -- > true || true

		// true && (false || false)  -- > true && true


		// task 2
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		Double y = null;

		if ((x >= -49 && x < -10) || (x > 0 && x <= 10)) {
			y = 10 * x * x * x + 7 * (double) x / 5 + 2;
			//System.out.println("y = " + y);
		} else if (x > 20) {
			y = (double) (x * -1 + 9);
			//System.out.println("y = " + y);
		} else {
			//System.out.println("No such func");
		}

		if (y != null) {
			System.out.println("y = " + y);
		} else {
			System.out.println("No such");
		}

		sc.close();


		// switch

		String str = "1";
		switch (str) {
			case "a": // if str == a
				System.out.println("it is a");
				System.out.println("it is a2");
				break;
//  <------------------
			case "1": // else if str == 1
				System.out.println("it is 1");
				break;
//  <------------------
			case "3":
				System.out.println("it is 3");
				break;
//  <------------------
			default:  // else
				System.out.println("default");
		}


		// mul(*) add(+) div(/) sub(-)  two numbers
		// result in console
		//task 3
		Scanner scanner = new Scanner(System.in);


		System.out.println("Enter a ");
		int a = scanner.nextInt();

		System.out.println("Enter b ");
		int b = scanner.nextInt();

		System.out.println("Enter operation(+ - * /) ");
		String operation = scanner.next();

		switch (operation) {
			case "+":
				System.out.println(a + b);
				break;
			case "*":
				System.out.println(a * b);
				break;
			case "/":
				System.out.println((float) a / b);
				break;
			case "-":
				System.out.println(a - b);
				break;
			default:
				System.out.println("Unknown operation!");
				break;
		}
		scanner.close();


		// cycles

		int i = 0;
		while (i < 5) {
			System.out.println(i);
			i++;
		}
		System.out.println("While cycle ended.");


		int j = 0;
		do {
			System.out.println(j);
			j++;
		} while (j < 5);

		System.out.println("doWhile cycle ended.");

		//while парные числа от 0 до 11
		//dowhile непарные числа от 0 до 11

		// task 4
		int i = 0;
		while (i < 11) {
			System.out.print(i + ", ");
			i += 2; // i = i + 2;
		}

		System.out.println();

		int j = 1;
		do {
			System.out.print(j + ", ");
			j += 2; // j = j + 2
		} while (j < 11);

		int n = 10;


		// cycle for
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < 10; j++) {
				System.out.println(i + j);

				// . . .

				//j++
			}

			// . . .

			// i++;
		}
	}
}


