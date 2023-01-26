package l01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Character> map = new HashMap<>();
        for (Character c: magazine.toCharArray()) {
            map.put(c, c);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(map.containsValue(ransomNote.charAt(i))) map.remove(ransomNote.charAt(i));
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
