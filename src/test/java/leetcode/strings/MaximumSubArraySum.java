package leetcode.strings;

public class MaximumSubArraySum {
    public static void main (String[] args){

        int[] numbers1 = {2,3,-8,7,-1,2,3};
        int[] numbers2 = {-6, -2, -4};

        System.out.println("the sum of maximum sb array is :"+ maxSum(numbers1));
        System.out.println("the sum of maximum sb array is :"+ maxSum(numbers2));
    }

    private static int maxSum(int[] numbers) {
        int sum = 0;
        int maxSum = numbers[0];
        for (int i=0; i <numbers.length; i++){

                sum = sum+ numbers[i];
            if (maxSum < sum)
                maxSum = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

}
