package AlgorithmsRealisation.LeetCode.questionMark;

import java.util.Arrays;

public class LSWRC {
    public static boolean l(String s1, String s2) {
        int[] chars = new int[26];
        Arrays.fill(chars, 0);

        for (int i = 0; i < s1.length(); i++) {
            chars[(s1.charAt(i) - 'a')] += 1;
        }

        System.out.println(Arrays.toString(chars));

        return false;
    }

    //helh elhh
    public static void main(String[] args) {
//        System.out.println(l("ab", "dboa"));
//        System.out.println(l("ab", "eidboaoo"))
        System.out.println(checkInclusionE("hello", "loohholleh"));
        System.out.println(checkInclusionE("ab", "boa"));
        System.out.println(checkInclusionE("ab", "a"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1a = new int[26];
        int[] s2a = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1a[s1.charAt(i) - 'a']++;
            s2a[s2.charAt(i) - 'a']++;
        }
        if (match(s1a, s2a)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            s2a[s2.charAt(i - s1.length()) - 'a']--;
            s2a[s2.charAt(i) - 'a']++;
            if (match(s1a, s2a)) return true;
        }
        return false;
    }

    private static boolean match(int[] s1a, int[] s2a) {
        for (int i = 0; i < s1a.length; i++) {
            if (s1a[i] != s2a[i]) return false;
        }
        return true;
    }

    public static boolean checkInclusionE(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }

}
