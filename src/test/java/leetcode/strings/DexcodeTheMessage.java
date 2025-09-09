package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class DexcodeTheMessage {

    public static void main (String[] args){
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println( decodeMessage(key, message));

    }

    public static String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char c = 'a';
        String result = "";
        map.put(' ', ' ');
        for (Character ch : key.toCharArray()) {
            if (!(map.containsKey(ch)) ) {
                map.put(ch, c++);
            }
        }

        for (Character ch : message.toCharArray()) {
            if (map.containsKey(ch)) {
                result = result + map.get(ch);
            }
       //     result= result + " ";
        }
        return  result;
    }
}
