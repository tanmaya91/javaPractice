package leetcode.strings;

/*Problem 2: Two Sum Problem
Problem Statement: Write a function sum that finds a pair of elements in an array that add up to a specified target sum. If such a pair exists, print the indexes and the values of these elements.
        Input:
        * 		An array of integers inputArray
* 		A target sum expectedSum
Output:
        * 		The indexes of the two elements that add up to the target sum
* 		The values of these two elements
Example:
        * 		For input array {1, 2, 3, 5} and target sum 4, the function should print:
        * 		"Indexes are: 0, 2"
        * 		"Values are: 1, 3"
Constraints:
        * 		Assume there is exactly one solution
* 		You cannot use the same element twice*/

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
