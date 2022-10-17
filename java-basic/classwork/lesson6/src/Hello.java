import house.House;

import java.util.Random;

// public {protected} package(default) private

public class Hello {


	public static void main(String[] args) {

		House house = new House(1, 1, "black");

		House anotherHouse = new House();

		House coloredHouse = new House("red");

		house.printSomething("something");

		house.setColor("blue");
		System.out.println(house.getColor());

		System.out.println(house);

		System.out.println(anotherHouse);

		System.out.println(coloredHouse);

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