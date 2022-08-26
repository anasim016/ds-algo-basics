package com.anasim.cm.masterdsa.arrays;

import java.util.Arrays;

public class KadaneAlgo07 {

    /**
     *  Kadane's Algorithm:
     *  - The algorithm only works if and only if at least one positive integer is present in the input array.
     *  - An array containing all negative integers is an invalid input for Kadane's algorithm.
     *  - Time Complexity: O(n)
     */
    private static int getMaxSubArraySum1(int[] inputArr) {

        int currentSubArrSum = 0;
        int maxSubArrSum = Integer.MIN_VALUE;
        for (int ele : inputArr) {
            currentSubArrSum = currentSubArrSum + ele;
            currentSubArrSum = Integer.max(currentSubArrSum, 0);
            maxSubArrSum = Integer.max(currentSubArrSum, maxSubArrSum);
        }
        return maxSubArrSum;
    }

    /**
     *  - Modified Kadane's algorithm to also support an array of all negative integers.
     *  - Time Complexity: O(n)
     */
    private static int getMaxSubArraySum2(int[] inputArr) {

        int currentSubArrSum = 0;
        int maxSubArrSum = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int ele : inputArr) {
            maxElement = Integer.max(maxElement, ele);
            currentSubArrSum = currentSubArrSum + ele;
            currentSubArrSum = Integer.max(currentSubArrSum, 0);
            maxSubArrSum = Integer.max(currentSubArrSum, maxSubArrSum);
        }
        return maxSubArrSum == 0 ? maxElement: maxSubArrSum;
    }

    public static void main(String[] args) {

        int[] inputArr1 = {10, 20, 30, 40, 50, 60};
        System.out.println("Max computed sub-array sum for: " + Arrays.toString(inputArr1) + " is " + getMaxSubArraySum1(inputArr1));
        System.out.println("Max computed sub-array sum for: " + Arrays.toString(inputArr1) + " is " + getMaxSubArraySum2(inputArr1));

        int[] inputArr2 = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Max computed sub-array sum for: " + Arrays.toString(inputArr2) + " is " + getMaxSubArraySum1(inputArr2));
        System.out.println("Max computed sub-array sum for: " + Arrays.toString(inputArr2) + " is " + getMaxSubArraySum2(inputArr2));

        int[] inputArr3 = {-2, -87, -4, -1, -69, -12, -6, -1, -3};
        System.out.println("Max computed sub-array sum for: " + Arrays.toString(inputArr3) + " is " + getMaxSubArraySum1(inputArr3));
        System.out.println("Max computed sub-array sum for: " + Arrays.toString(inputArr3) + " is " + getMaxSubArraySum2(inputArr3));
    }
}
