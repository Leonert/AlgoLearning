package l01;

import java.util.Arrays;

public class compSum2DimArray {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tempSum += accounts[i][j];
            }
            if (tempSum > max) max = tempSum;
        }
        return max;
    }

    public static int maximumWealthS(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(Arrays.stream(account).sum(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
