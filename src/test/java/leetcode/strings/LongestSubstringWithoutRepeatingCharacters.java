package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abba";
        int maxString = lengthOfLongestSubstring(s);
        System.out.println("longest substring without repeating characters: " + maxString);
      //  int result =  maxString.length();
        System.out.println("Length of the longest substring without repeating characters: " + maxString);
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.isBlank())
            return 0;
        else {
            int length = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0;
            for (int end = 0; end < s.length(); end++) {
                if (map.containsKey(s.charAt(end))) {

                    start = Math.max(start,map.get(s.charAt(end)) + 1);

                }
                map.put(s.charAt(end), end);

                length = Math.max(length, end - start + 1);

            }
            return length;
        }
    }
}
