package leetcode.strings;

/*Write a program in which you will find the sum of the digits.
If the sum of the digits is a single digit number then print the sum
otherwise keep finding the sum of the digits of the sum until you get a single digit sum.*/

public class SumOfDigits {
    public static void main (String[] args) {
        int num =299;
        System.out.println("The sum of digits in single digit number is : " + sumInSingleDigit(num));
    }

    private static int sumInSingleDigit(int num) {
        int result = 0;
        while (num > 0){

            result = result + num % 10;
            num = num / 10;
            if (num == 0 && result >9){
                num = result;
                result =0;
            }
        }
        return result;
    }
}
