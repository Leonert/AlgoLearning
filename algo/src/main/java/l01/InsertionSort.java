package l01;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = fillArray(10);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        long time = System.currentTimeMillis();
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(Arrays.toString(bubbleSort(arr2)));
        System.out.println(System.currentTimeMillis() - time);
    }

    private static int[] insertionSort(int[] arr) {
        for (int count = 1; count < arr.length; count++) {
            if (arr[count - 1] > arr[count]) {
                int temp = 0;
                for (int index = count - 1; index >= 0; index--) {
                    if (arr[index] > arr[index + 1]) {
                        temp = arr[index];
                        arr[index] = arr[index + 1];
                    }
                    else break;
                }
                arr[count] = temp;
            }
        }
        return arr;
    }

    public static int[] fillArray(int n) {
        Random random = new Random();
        int[] outcome = new int[n];
        for (int i = 0; i < outcome.length; i++) {
            outcome[i] = random.nextInt(20) - 10;
        }
        return outcome;
    }



    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int q = 1; q < nums.length; q++) {
                if (nums[q - 1] > nums[q]) {
                    int temp = nums[q - 1];
                    nums[q - 1] = nums[q];
                    nums[q] = temp;
                }
            }
        }
        return nums;
    }
}
