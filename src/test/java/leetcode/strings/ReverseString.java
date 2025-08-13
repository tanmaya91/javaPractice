package leetcode.strings;
/*Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]*/

public class ReverseString {
    public static void main (String[] args) {
        char[] s =  {'h','e','l','l','o'};
        System.out.println("reverse of teh string is : " + reverseOfString(s));

    }

    private static char[] reverseOfString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        System.out.println(s);
        return s;
    }

}
