package com.anasim.cm.masterdsa.array;

import java.util.Arrays;

public class LargestElement08 {

    /**
     *  - Implement a function that takes array of integers as input and returns the largest element.
     *  - Sample Inputs:
     *    {-3, 4, 1, 2, 3}
     *    {-1, -2, -3, -3, 8}
     *  - Sample Outputs:
     *    4
     *    8
     */

    private static int getLargestElement(int[] inputArr) {

        int maxEle = Integer.MIN_VALUE;
        for (int ele : inputArr) {
            maxEle = Integer.max(maxEle, ele);
        }
        return maxEle;
    }

    public static void main(String[] args) {

        int[] inputArr1 = {-3, 4, 1, 2, 3};
        System.out.println("Largest element inside " + Arrays.toString(inputArr1) + " is " + getLargestElement(inputArr1));

        int[] inputArr2 = {-1, -2, -3, -3, 8};
        System.out.println("Largest element inside " + Arrays.toString(inputArr2) + " is " + getLargestElement(inputArr2));
    }
}
