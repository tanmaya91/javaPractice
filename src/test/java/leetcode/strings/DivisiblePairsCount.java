package leetcode.strings;
/*Problem 3: Divisible Pairs Count – Similar to previous problem (try to solve as assignment)
Problem Statement:Write a function divisor_pair that counts the number of pairs in an array whose sum is divisible by a given number.
        Input:
        * 		An array of integers arr
* 		A divisor divisor
Output:
        * 		The count of pairs (i, j) where i < j and (arr[i] + arr[j]) is divisible by the divisor
Example:
        * 		For input array {5,9,36,74,52,31,42} and divisor 3, the function should return 8*/

public class DivisiblePairsCount {
    public static void main (String[] args) {
        int[] numbers = {5,9,36,74,52,31,42};
        int divisor = 3;
        System.out.println("the divisible pairs count is: "+ countOfDivisiblePairs(numbers, divisor));
    }

    private static int countOfDivisiblePairs(int[] numbers, int divisor) {
        int count =0;
        for (int i=0; i < numbers.length-1; i++){
            for (int j=i+1; j< numbers.length; j++){
                if  ((numbers[i] + numbers[j]) % 3 ==0){
                    count++;
                }
            }
        }
        return count;
    }
}
