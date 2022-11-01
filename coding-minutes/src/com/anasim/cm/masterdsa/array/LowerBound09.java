package com.anasim.cm.masterdsa.array;

import java.util.Arrays;

public class LowerBound09 {

    /**
     *  - Given an array of integers A (sorted) and an integer Val. Implement a function that takes A and Val as input
     *    parameters and returns the lower bound of Val.
     *  - If Val is not present in array then Lower bound of a given integer means integer which is just smaller than
     *    given integer. Otherwise, Val itself is the answer.
     *  - If Val is less than the smallest element of array A then return '-1' in that case.
     *
     *  - Example 1:
     *      A = [-1, -1, 2, 3, 5]
     *      Val = 4
     *    Answer: 3
     */

    // Time Complexity: O(n)
    private static int getLowerBound1(int[] inputArr, int ele) {

        if (inputArr[0] > ele) {
            return -1;
        }
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ele) {
                return ele;
            }
            if (inputArr[i] > ele) {
                return inputArr[i - 1];
            }
        }
        return inputArr[inputArr.length - 1];
    }

    // Time Complexity: O(log n)
    private static int getLowerBound2(int[] inputArr, int ele) {

        int res = -1, startIndex = 0, endIndex = inputArr.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (inputArr[midIndex] > ele) {
                endIndex = midIndex - 1;
            } else {
                res = inputArr[midIndex];
                startIndex = midIndex + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] inputArr1 = {-1, -1, 2, 3, 5};

        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound1(inputArr1, 4));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound1(inputArr1, -1));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound1(inputArr1, -17));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound1(inputArr1, 3));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound1(inputArr1, 25));

        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound2(inputArr1, 4));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound2(inputArr1, -1));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound2(inputArr1, -17));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound2(inputArr1, 3));
        System.out.println("Closest element inside " + Arrays.toString(inputArr1) + " is " + getLowerBound2(inputArr1, 25));
    }
}
