package leetcode.strings;
/*
Problem 4: Adjacent Pair Grouping
Problem Statement: Write a function evenSum that processes an array of integers by examining adjacent pairs of elements. The function should count how many non-overlapping pairs with an even sum can be formed while traversing the array from left to right.
        Input:
        * 		An array of integers arr
Output:
        * 		The count of non-overlapping adjacent pairs whose sum is even
Algorithm Details:
        * 		The function traverses the array from left to right
* 		When it finds a pair of adjacent elements whose sum is even, it:
        * 		Increments the counter
* 		Skips the next pair (moves the index by 2)
* 		If the adjacent pair doesn't have an even sum, it simply moves to the next position
Example:
        * 		For input array {4,2,5,8,7,3,7}:
        * 		Pair (4,2): Sum is 6 (even), increment counter to 1, move to index 2
        * 		Pair (5,8): Sum is 13 (odd), move to index 4
        * 		Pair (7,3): Sum is 10 (even), increment counter to 2, move to index 6
        * 		Index 6 is the last element, so there are no more pairs to check
* 		The function returns 2
Constraints:
        * 		The array will contain at least one element
* 		The function only considers adjacent pairs (elements at positions i and i+1)
* 		The function manages index traversal to ensure non-overlapping pairs
*/


public class AdjacetPairGrouping {
    public static void main (String[] args) {
        int[] numbers = {4,2,5,8,6,7,3,7};
        System.out.println("the number of adjacent pairs that are even is : "+ countPairs(numbers));

    }

    private static int countPairs(int[] numbers) {
        int count = 0;
        for (int i=0; i< numbers.length-1; i++) {
            if (( numbers[i] + numbers[i+1] )% 2 == 0) {
                count++;
                i++;
            }
        }
        return count;
    }

}
