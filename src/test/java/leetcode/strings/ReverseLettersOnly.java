package leetcode.strings;

public class ReverseLettersOnly {
    public static void main (String[] args) {
        String str= "1ab2";
        System.out.println("the  revers of letters only in string is : " + reverseString(str));

    }

    public static String reverseString(String str){
        StringBuilder s = new StringBuilder();
        char ch[] = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            if (!Character.isLetter(ch[left]))
                left++;
            else if (!Character.isLetter(ch[right])) {
                right--;

            }
            else {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right]=temp;
                left++;
                right--;
            }

        }
        return new String(ch);

    }
}
