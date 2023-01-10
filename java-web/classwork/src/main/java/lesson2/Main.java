package lesson2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1041));
    }
}

class Solution {
    public int solution(int N) {
        String bin = Integer.toBinaryString(N);
        int tempIndex = 999;
        int lengthToReturn = 0;

        for (int i = 0; i < bin.length(); i++) {
            if(bin.charAt(i) == '1' && tempIndex == 999) {
                tempIndex = i;
            }
            else if (bin.charAt(i) == '1' && tempIndex == i - 1) {
                tempIndex = i;
            }
            else if (bin.charAt(i) == '1' && tempIndex != i - 1) {
                lengthToReturn = Math.max (i - tempIndex - 1, lengthToReturn);
                tempIndex = i;
            }
        }
        return lengthToReturn;
    }
}
