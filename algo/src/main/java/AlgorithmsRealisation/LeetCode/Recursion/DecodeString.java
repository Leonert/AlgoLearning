package AlgorithmsRealisation.LeetCode.Recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DecodeString {
    // https://leetcode.com/problems/decode-string/ 394. Decode String
    public String decodeString(String s) {
        int mult = 1;
        int symbCounter = 0;
        int seqStart = 0;
        StringBuilder sb = new StringBuilder();
        Queue<String> qeeue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                mult = s.charAt(i);
            }
            else if (s.charAt(i) != '[' && symbCounter == 0) sb.append(s.charAt(i));
            else {
                if(s.charAt(i) == '[' && symbCounter == 0) {
                    symbCounter++;
                    seqStart = i;
                }
                else if (s.charAt(i) == '[') symbCounter++;
                else if (s.charAt(i) == ']' && symbCounter == 1) {
                    symbCounter--;
                    String temp = s.substring(seqStart, seqStart + i);
                    qeeue.add(temp);
                    map.put(temp, mult);
                }
                else if (s.charAt(i) == ']') symbCounter--;
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();

        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]2[a3[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
