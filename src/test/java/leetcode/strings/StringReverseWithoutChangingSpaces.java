package leetcode.strings;
/*Input: "This is a string" output: "gnir ts a sisiht" → Reverse the string but the space will be same.*/

public class StringReverseWithoutChangingSpaces {
    public static void main (String[] args) {
        String s = "this is a string";
        System.out.println("the reverse of the string without changing position of spaces is : "+ reverseStringWithoutSpaces(s));
    }

    private static String reverseStringWithoutSpaces(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while (left < right) {
            if (Character.isWhitespace(chars[left]))
                left++;
            else if (Character.isWhitespace(chars[right])) {
                right--;
            }
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right]= temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
