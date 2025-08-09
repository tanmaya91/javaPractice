package leetcode.strings;

public class NeedleInHaystack {

    public static void main(String[] args) {
        String s1 = "sadsadsad";
        String s2 = "sadd";
        System.out.println("the index of needle in haystack is : " + indexOfNeedle(s1, s2));
    }

    public static int indexOfNeedle(String haystack, String needle) {
        int length = needle.length();
        if(haystack.equals(needle))
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if ((i+length) <= haystack.length() && haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
