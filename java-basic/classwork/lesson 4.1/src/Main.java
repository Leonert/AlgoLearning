import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		final int n = 20;
		double p = 1;
		for (int i = 1; i <= n; i++) {
			double s = 0;
			for (int j = 1; j <= i; j++) {
				s += (j + Math.sin(j));  // s = s + ...
			}

			p *= ((i * i) + 1) / s;  // p = p * ...
		}
		System.out.println("p = " + p);


		double p2 = 1;
		double s = 0;
		for (int i = 1; i <= n; i++) {
			s += (i + Math.sin(i));
			p2 *= ((i * i) + 1) / s;
		}

		System.out.println("p2 = " + p2);


		for (int i = 0; i < 20; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}

		Scanner sc = new Scanner(System.in);



		int number = 0;
		for(;;){
			if(sc.hasNextLine()){
				number = sc.nextInt();
			}
			if(number == 5) break;
		}


		int a = 1;
		int b = 10;

		for(int i = 0; i < 10; i++){
			if (true) {
				int c = 0;
				{
					int f = 0;
				}
				int f = 0;
			}
			int f = 0;
		}
		int f = 0;




		for (int i = 0; i < 25; i++) {
			int num = (int) (Math.random() * 10); // [0 ; 10)

			System.out.println(num);
		}


		int a1 = 1;
		int a2 = 2;
		int a3 = 3;
		int a4 = 4;
		int a5 = 5;


		int[] arr2 = new int[] {5, 22, 3, 14, 5, 16};
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

//		// arr[0] - first == int a;
//		// arr[1] - second
//		// arr[2] - third
//		// . . .

//		int[] arr = new int[10];  // [int a1, int a2 ...] 5 elements   0000   0000   0000

		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}


		int[] arr1 = { -542, 32, -542, 532, 622, -523, -542, 622};

		//int min = arr1[0];
		//int max = arr1[0];
		int minIndex = 0;
		int maxIndex = 0;


		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] < arr1[minIndex]) {
				//min = arr1[i];
				minIndex = i;
			}

			if(arr1[i] >= arr1[maxIndex]){
				//max = arr1[i];
				maxIndex = i;
			}

		}

		int tmp = arr1[minIndex];
		arr1[minIndex] = arr1[maxIndex];
		arr1[maxIndex] = tmp;



		// найти первый мин и последний макс и поменять их местами

		int[] arr = {1, 2, 3, 4, 5, 6, 7}; // 6 5 4 3 2 1
		int n = arr.length;

		for (int i = 0; i < n / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[n - 1 - i];
			arr[n - 1 - i] = tmp;
		}

		System.out.println(Arrays.toString(arr));

		// 1 2 3 4 5 6 7 8

		// 5 6 7 8 4 3 2 1

	}
}