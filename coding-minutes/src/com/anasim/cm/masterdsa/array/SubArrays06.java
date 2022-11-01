package com.anasim.cm.masterdsa.array;

import java.util.Arrays;

public class SubArrays06 {

    /**
     *  getMaxSubArraySum() prints all possible sub-arrays with their sum from the given array.
     *  It returns the maximum computed sub-array sum.
     */

    // Time Complexity: O(n^3)
    private static int getMaxSubArraySum1(int[] inputArr) {
        int maxSubArrSum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = inputArr.length - 1; j >= i; j--) {
                int subArrSum = 0;
                for (int k = i; k <= j; k++) {
                    subArrSum = subArrSum + inputArr[k];
                    // System.out.print(inputArr[k] + ", ");
                }
                // System.out.println("\nAbove Sub Array Sum: " + subArrSum + "\n");
                maxSubArrSum = Integer.max(maxSubArrSum, subArrSum);
            }
        }
        return maxSubArrSum;
    }

    // Time Complexity: O(n + n^2) = O(n^2)
    private static int getMaxSubArraySum2(int[] inputArr) {
        int[] level0CumulativeSumArr = new int[inputArr.length];    // Space Complexity: O(n)
        level0CumulativeSumArr[0] = inputArr[0];
        int maxSubArrSum = inputArr[0];
        String subArr = inputArr[0] + ", ";
        int subArrSum = inputArr[0];

        for (int i = 1; i < inputArr.length; i++) {
            if (i == 1) {
                // System.out.println(subArr + "\nAbove Sub Array Sum: " + subArrSum);
            }
            subArr = subArr + inputArr[i] + ", ";
            subArrSum = level0CumulativeSumArr[i - 1] + inputArr[i];
            // System.out.println(subArr + "\nAbove Sub Array Sum: " + subArrSum);
            level0CumulativeSumArr[i] = subArrSum;
            maxSubArrSum = Integer.max(maxSubArrSum, subArrSum);
        }

        for (int j = 1; j < inputArr.length; j++) {
            subArr = "";
            for (int k = j; k < inputArr.length; k++) {
                subArr = subArr + inputArr[k] + ", ";
                subArrSum = level0CumulativeSumArr[k] - level0CumulativeSumArr[j - 1];
                // System.out.println(subArr + "\nAbove Sub Array Sum: " + subArrSum);
                maxSubArrSum = Integer.max(maxSubArrSum, subArrSum);
            }
        }

        return maxSubArrSum;
    }

    // Time Complexity: O(n^2)
    private static int getMaxSubArraySum3(int[] inputArr) {
        int maxSubArrSum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArr.length; i++) {
            String subArr = "";
            int subArrSum = 0;
            for (int j = i; j < inputArr.length; j++) {
                subArr = subArr + inputArr[j] + ", ";
                subArrSum = subArrSum + inputArr[j];
                // System.out.println(subArr + "\nAbove Sub Array Sum: " + subArrSum);
                maxSubArrSum = Integer.max(maxSubArrSum, subArrSum);
            }
        }
        return maxSubArrSum;
    }

    public static void main(String[] args) {

        int[] inputArr1 = {10, 20, 30, 40, 50, 60};
        System.out.println("[getMaxSubArraySum1] Max computed sub-array sum for: " + Arrays.toString(inputArr1) + " is " +
                getMaxSubArraySum1(inputArr1));
        System.out.println("[getMaxSubArraySum2] Max computed sub-array sum for: " + Arrays.toString(inputArr1) + " is " +
                getMaxSubArraySum2(inputArr1));
        System.out.println("[getMaxSubArraySum3] Max computed sub-array sum for: " + Arrays.toString(inputArr1) + " is " +
                getMaxSubArraySum3(inputArr1));

        int[] inputArr2 = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("[getMaxSubArraySum1] Max computed sub-array sum for: " + Arrays.toString(inputArr2) + " is " +
                getMaxSubArraySum1(inputArr2));
        System.out.println("[getMaxSubArraySum2] Max computed sub-array sum for: " + Arrays.toString(inputArr2) + " is " +
                getMaxSubArraySum2(inputArr2));
        System.out.println("[getMaxSubArraySum3] Max computed sub-array sum for: " + Arrays.toString(inputArr2) + " is " +
                getMaxSubArraySum3(inputArr2));

        int[] inputArr3 = {-2, -87, -4, -1, -69, -12, -6, -1, -3};
        System.out.println("[getMaxSubArraySum1] Max computed sub-array sum for: " + Arrays.toString(inputArr3) + " is " +
                getMaxSubArraySum1(inputArr3));
        System.out.println("[getMaxSubArraySum2] Max computed sub-array sum for: " + Arrays.toString(inputArr3) + " is " +
                getMaxSubArraySum2(inputArr3));
        System.out.println("[getMaxSubArraySum3] Max computed sub-array sum for: " + Arrays.toString(inputArr3) + " is " +
                getMaxSubArraySum3(inputArr3));
    }
}
