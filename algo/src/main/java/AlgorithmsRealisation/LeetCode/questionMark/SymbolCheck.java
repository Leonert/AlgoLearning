package AlgorithmsRealisation.LeetCode.questionMark;

import java.util.Arrays;

public class SymbolCheck {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (k == nums.length || nums.length < 2) return;
        k = k % nums.length;
        int max = nums.length - k;
        for (int i = 0; i < max / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[max - i - 1];
            nums[max - i - 1] = temp;
        }
        for (int i = max; i < (nums.length + max) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - (i - max) - 1];
            nums[nums.length - (i - max) - 1] = temp;
        }
        for (int i = 0; i < (nums.length / 2); i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

    }
}
