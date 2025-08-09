package leetcode.strings;

import java.util.HashMap;

public class LongestPallindromeSubstring {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        String result = String.valueOf(longestPalindrome(s));
        System.out.println("longest pallindrome substring is:" + result);

    }

    public static String longestPalindrome(String s) {
        for (int end=s.length(); end>0; end--){
            for (int start=0; start <= s.length()-end; start++){
                if (isPallindrome(s,start,start+end)) {
                    return s.substring(start,start+end);
                }
            }
        }
        return s.substring(0,1);
    }

    public static Boolean isPallindrome(String s, int i, int j){
        int left =i;
        int right = j-1;
        while (left < right ){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

