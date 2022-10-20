import house.House;
import task1.Car;
import task1.Engine;

import java.util.Random;

// public {protected} package(default) private

public class Hello {

	public enum DayOfTheWeek {
		MONDAY("test1"),
		TUESDAY("test2"),
		WEDNESDAY("test3"),
		THURSDAY("test4"),
		FRIDAY("test5"),
		SATURDAY("test6"),
		SUNDAY("test7");

		private final String test;

		private DayOfTheWeek(String test) {
			this.test = test;
		}

		public String getTest() {
			return test;
		}
	}


	public static void main(String[] args) throws Throwable {

		DayOfTheWeek day = DayOfTheWeek.FRIDAY;

		System.out.println(day.ordinal());

//		System.out.println(day.getTest());

		System.out.println(DayOfTheWeek.MONDAY.compareTo(DayOfTheWeek.SUNDAY));

//
//
//		for(DayOfTheWeek day2 : DayOfTheWeek.values()){
//			if(day2.ordinal() > 4)
//				System.out.println(day2);
//		}

//		DayOfTheWeek day3 = DayOfTheWeek.valueOf("WEDNESDAY");
//		System.out.println(day3);


		Engine engine = new Engine(1, 2, "ASOM");


		// .....

		engine = null;


//		Engine engine1 = new Engine(1, 1, "ASOM");
//
//		Car car = new Car(engine);
//		Car car1 = new Car(engine1);
//
//		System.out.println(car);


//		House coloredHouse = new House("red");
//
//		house.printSomething("something");
//
//		house.setColor("blue");
//		System.out.println(house.getColor());
//
//		System.out.println(house);
//
//		System.out.println(anotherHouse);
//
//		System.out.println(coloredHouse);

//		int[][] a = new int[4][5];
//		int[][] b = new int[3][3];
//
//		fillArray(a);
//		fillArray(b);
//
//		printMatrix(b);
//		printVectorSum(b);
//		System.out.println();
//		System.out.println();
//
//		sortMatrix(b);
//		//swapColumns(a, 0);
//
//		printMatrix(b);
//		printVectorSum(b);


		//
	}

	private static String getDay(DayOfTheWeek day) {
		switch (day) {
			case MONDAY:
				return "monday blabla";
			case THURSDAY:
				return "thursday blabla2";
			case WEDNESDAY:
				return "WEDNESDAY blabla2";
			case TUESDAY:
				return "TUESDAY blabla2";
			case FRIDAY:
				return "FRIDAY blabla2";
			case SATURDAY:
				return "SATURDAY blabla2";
			case SUNDAY:
				return "SUNDAY blabla2";
			default:
				return null;
		}
	}

	static void sortMatrix(int[][] arr) {

		//bubble sort of columns
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length - i; j++) {
				if (sumColumn(arr, j - 1) <= sumColumn(arr, j)) {
					swapColumns(arr, j - 1);
				}
			}
		}
	}

	static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" ");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
	}

	static void printVectorSum(int[][] arr) {
		System.out.print("S:");
		for (int i = 0; i < arr[0].length; i++) {
			System.out.printf("%5d", sumColumn(arr, i));
		}
	}

	private static void swapColumns(int[][] arr, int pos) {
		for (int i = 0; i < arr.length; i++) {
			int tmp = arr[i][pos];
			arr[i][pos] = arr[i][pos + 1];
			arr[i][pos + 1] = tmp;
		}
	}

	private static int sumColumn(int[][] arr, int columnNumber) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][columnNumber];
		}
		return sum;
	}

	static void fillArray(int[][] arr) {
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rand.nextInt(20);
			}
		}
	}
}