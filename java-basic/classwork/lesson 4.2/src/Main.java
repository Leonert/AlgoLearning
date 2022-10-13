import java.util.Arrays;
import java.util.StringJoiner;

public class Main {
	public static void main(String[] args) {

		int[] arr1 = {-542, 32, -542, 532, 622, -523, -542, 622};

		int capacity = 50;
		int currentLength = 0;
		int[] arr = new int[capacity];

		arr[currentLength] = 23452;
		currentLength++;


		int min = arr1[0];
		int max = arr1[0];
		int minIndex = 0;
		int maxIndex = 0;

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "  ");
		}

		System.out.println();






		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] < min) {
				min = arr1[i];
				minIndex = i;
			}

			if (arr1[i] >= max) {
				max = arr1[i];
				maxIndex = i;
			}

		}

		int tmp = arr1[minIndex];
		arr1[minIndex] = arr1[maxIndex];
		arr1[maxIndex] = tmp;

		System.out.println(Arrays.toString(arr1));






		// вывести сумму каждого столбца
		// 12 15 18
		// вывесту сумму диагонали (одним циклом)


		int[][] arr2x = {
				{1, 2, 3, 3},
				{4, 5, 6, 5},
				{7, 8, 9, 6},
				{10, 11, 12, 6}
		};

		for(int i = 0; i < arr2x.length; i++){
			int sum = 0;

			for(int j = 0; j < arr2x[i].length; j++){
				sum += arr2x[j][i];
			}

			System.out.println(sum);
		}

		// 1) i = 0 j = 0   arr[0][0]
		// 2) i = 0 j = 1   arr[1][0]
		// 1) i = 0 j = 2   arr[2][0]

		// 1) i = 1 j = 0   arr[0][1]
		// 1) i = 1 j = 1   arr[1][1]
		// 2) i = 1 j = 2   arr[2][1]

		int[][] arr = {
				{3, 2, 3, 3},
				{4, 5, 6, 5},
				{7, 8, 1, 6},
				{10, 11, 12, 6}
		};

		int min = arr[0][0];

		// main diagonal
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][i] < min) {
				min = arr[i][i];
			}
		}


        // additional diagonal
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][arr.length - i - 1]);
		}



		int[][][] arr3x =
		{
				{
						{1, 2},
						{1, 2}
				},
				{
						{1, 2},
						{1, 2},
				}
		};





		int[] arr = {6, 5, 1, 2, 8, 6, 10, 3, 0};

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}

		int[] arr2 = {6, 5, 1, 2, 8, 6, 10, 3, 0};

		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));









		String str = "Hello";

		String str1 = new String();

		char[] arr = { 'a', 'b', 'c'};

		String str3 = new String(arr);

		System.out.println(str3);


		char[] arr2 = str3.toCharArray();

		System.out.println(arr2);
//
//		char a = '1';
//
//		for(int i = 0; i < str.length(); i++){
//			System.out.println(str.charAt(i));
//		}

		System.out.println(str.length());






		String s = "abc";
		String s3 = s;   // String s3 = "abc";
		s3 = "a   " + "sadf";

		System.out.println(s);
		System.out.println(s3);





//		// abc-abv-ads
//
//		// abc0abv0ads

		String str = "abc-abv-ads";

		System.out.println(str.replace('-', '0'));










		// "Word" "HERE" "word" "same" "hello" "hi" "HI" "here"

		// удалить повторяющиеся строки ( игнорируем размер букв ) -  заменить их на null

		// "Word" "HERE" null "same" "hello" "hi" null null


		String[] strings = {"Word", "HERE", "word", "same", "hello", "hi", "HI", "here"};

		for (int i = 0; i < strings.length; i++) {

			String tmp = strings[i];
			if (tmp != null) {
				for (int j = i + 1; j < strings.length; j++) {
					if (tmp.equalsIgnoreCase(strings[j])) {
						strings[j] = null;
					}
				}
			}
		}

		System.out.println(Arrays.toString(strings));
		String s = null;
		String s2 = "";
		String s3 = new String();

		System.out.println(s3.length());





		// StringBuilder 
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(asdf).append(423).append("asdfsadg").append(123.5234);
		stringBuilder.insert(0, "START");
		System.out.println(stringBuilder);



		// StringBuffer
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("123").append(423).append("asdfsadg");
		
		System.out.println(stringBuffer);



		// StringJoiner
		StringJoiner stringJoiner = new StringJoiner("/", "[", "");

		stringJoiner.add("2002").add("04").add("13");

		System.out.println(stringJoiner.toString());

	}
}