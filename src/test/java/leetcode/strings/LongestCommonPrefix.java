package leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main (String[] args){
        String[] strs = {"flower","flow","flig"};
        System.out.println("the commonPrefix is: "+commonPrefix(strs));
    }

    public static String commonPrefix(String[] strs){
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        char [] first = strs[0].toCharArray();
        char [] last = strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);
        }
        return result.toString();
    }
}
