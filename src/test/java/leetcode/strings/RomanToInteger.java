package leetcode.strings;

public class RomanToInteger {

    public static void main (String[] args){
        String s = "MDLXX";
        System.out.println("the roman to integer number is: "+romanToInt(s));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i=0; i< s.length(); i++){
            if(s.charAt(i)=='M')
                result= result + 1000;
            if(s.charAt(i)=='D')
                result= result + 500;
            if(s.charAt(i)=='C') {
                if (s.charAt(i + 1) == 'D') {
                    result = result + 400;
                    i++;
                } else if (s.charAt(i + 1) == 'M') {
                    result = result + 900;
                    i++;
                } else
                    result = result + 100;
            }
            if(s.charAt(i)=='L')
                result= result + 50;
            if(s.charAt(i)=='X') {
                if (s.charAt(i + 1) == 'L') {
                    result = result + 40;
                    i++;
                } else if (s.charAt(i + 1) == 'C') {
                    result = result + 90;
                    i++;
                } else
                    result = result + 10;
            }
            if(s.charAt(i)=='V')
                result= result + 5;
            if(s.charAt(i)=='I') {
                if (i == s.length() - 1) {
                    result = result + 1;
                    break;
                }
                if (s.charAt(i + 1) == 'V') {
                    result = result + 4;
                    i++;
                } else if (s.charAt(i + 1) == 'X') {
                    result = result + 9;
                    i++;
                } else
                    result = result + 1;
            }

        }
        return result;

    }
}
