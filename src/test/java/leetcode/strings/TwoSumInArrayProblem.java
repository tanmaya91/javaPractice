package leetcode.strings;

import java.util.Arrays;

public class TwoSumInArrayProblem {

    public static void main (String[] args){
        int[] numbers = {2, 5,15,16,21,9,14,29};

        int sum = 30;
        indexOfNumbers(numbers, sum);
       // System.out.println("The indexes of numbers is:"+ indexOfNumbers(numbers, sum));


    }

    private static void indexOfNumbers(int[] numbers, int sum) {
        for (int i=0; i< numbers.length; i++){
            for (int j=i+1; j< numbers.length; j++){
                if (numbers[j]== sum - numbers[i]){
                    System.out.println("the indexes are " + i + " " + j);
                    System.out.println("the numbers are "+ numbers[i] +"and " + numbers[j]);

                }
            }

        }
    }
}
