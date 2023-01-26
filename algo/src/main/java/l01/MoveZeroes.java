package l01;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while(nums[left] != 0 && left < right) left++;
            for (int i = left; i < right; i++) {
                nums[i] = nums[i + 1];
            }
            if (left < right) nums[right] = 0;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
