package AlgorithmsRealisation.LeetCode.questionMark;

public class TwoPointers {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int spaceIndex = 0;
        int left = 0;
        int right;
        while (spaceIndex < s.length()) {
            while (spaceIndex < s.length() - 1 && s.charAt(spaceIndex + 1) != ' ') spaceIndex++;
            right = spaceIndex;
            while (left <= right) sb.append(s.charAt(right--));
            if (spaceIndex < s.length() - 1) sb.append(" ");
            spaceIndex += 2;
            left = spaceIndex;
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's fck goo"));
    }

    public String reverseWordsE(String s) {
        StringBuilder result = new StringBuilder();
        int lastSpaceIndex = -1;
        for (int strIndex = 0; strIndex < s.length(); strIndex++) {
            if ((strIndex == s.length() - 1) || s.charAt(strIndex) == ' ') {
                int reverseStrIndex = (strIndex == s.length() - 1) ? strIndex : strIndex - 1;
                for (; reverseStrIndex > lastSpaceIndex; reverseStrIndex--) {
                    result.append(s.charAt(reverseStrIndex));
                }
                if (strIndex != s.length() - 1) {
                    result.append(' ');
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(result);
    }
}
