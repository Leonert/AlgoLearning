package l01;

import java.util.Arrays;

public class SquaresOfASortedArray {

    // -4,-1,0,3,10
    public static int[] sortedSquares(int[] nums) {
       int[] outcome = new int[nums.length];
       int left = 0;
       int right = nums.length - 1;

       for (int index = right; index >= 0; index--) {
           if (Math.abs(nums[left]) > Math.abs(nums[right])) {
               outcome[index] = nums[left] * nums[left];
               left++;
           }
           else {
               outcome[index] = nums[right] * nums[right];
               right--;
           }
       }
        return outcome;
    }

























//    public static int[] sortedSquaresE(int[] A) {
//        int n = A.length;
//        int[] result = new int[n];
//        int i = 0, j = n - 1;
//        for (int p = n - 1; p >= 0; p--) {
//            if (Math.abs(A[i]) > Math.abs(A[j])) {
//                result[p] = A[i] * A[i];
//                i++;
//            } else {
//                result[p] = A[j] * A[j];
//                j--;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
    }
}
