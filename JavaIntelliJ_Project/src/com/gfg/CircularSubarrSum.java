package com.gfg;

import java.util.Arrays;

// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.
public class CircularSubarrSum {

    public int circularSubarraySum(int[] arr) {
        // Your code here

        // idea here is to subtract minimum Sum subarray (provided it should be negative) from complete sum of the array

        int arrSum = Arrays.stream(arr).sum();
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum>0){
                sum = 0;
            }
            sum = sum + arr[i];
            if (minSum>sum && sum < 0){
                minSum = sum;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum2<0){
                sum2 = 0;
            }
            sum2 = sum2 + arr[i];
            if (maxSum<sum2){
                maxSum = sum2;
            }
        }

        if (arrSum == minSum){
            return maxSum;
        }
        return Math.max(arrSum - minSum, maxSum);
    }

    public int circularSubarraySum2(int[] arr) {
        // Your code here

        // idea here is to subtract minimum Sum subarray (provided it should be negative) from complete sum of the array

        int arrSum = Arrays.stream(arr).sum();
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int currMaxSum = 0;
        int currMinSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(currMinSum,minSum);

            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(currMaxSum,maxSum);

        }

//        System.out.println(maxSum);
//        System.out.println(minSum);
        if (arrSum == minSum){
            return maxSum;
        }
        return Math.max(arrSum - minSum, maxSum);
    }
    public static void main(String[] args) {
//        int[] arr = {8, -8, 9, -9, 10, -11, 12};
//        int[] arr = {10, -3, -4, 7, 6, 5, -4, -1};
        int[] arr = {-1,-2};
//        int[] arr = {-7, 32, -11, 21, 18, 35, -26, -17, 35, -12, -38, -33, 32, 16, 44, 11, -40, -21, 2, 27, -35, 21, -37, -12, 1};
        // {-2,-3,4,5,-2,1}  // in this example maxSum is greater than arrSum - minSum

        CircularSubarrSum obj1 = new CircularSubarrSum();
        System.out.println(obj1.circularSubarraySum2(arr));
    }
}
