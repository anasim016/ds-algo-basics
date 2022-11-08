package com.anasim.cm.masterdsa.array01;

import java.util.Arrays;

public class ReverseArray04 {

    /**
     *  - Time Complexity: O(n/2) = O(n)
     */
    private static int[] reverseArray(int[] inputArr) {

        int startIndex = 0;
        int endIndex = inputArr.length - 1;
        int temp;
        while (startIndex < endIndex) {
            temp = inputArr[startIndex];
            inputArr[startIndex] = inputArr[endIndex];
            inputArr[endIndex] = temp;
            startIndex += 1;
            endIndex -= 1;
        }
        return inputArr;
    }

    public static void main(String[] args) {

        // Input array containing old number of elements.
        int[] inputArr1 = {10, 20, 30, 40, 50, 60, 70};
        System.out.println("Input Array: " + Arrays.toString(inputArr1) + ", Reverse Output Array: " + Arrays.toString(reverseArray(inputArr1)));

        // Input array containing even number of elements.
        int[] inputArr2 = {10, 20, 30, 40, 50, 60, 70, 80};
        System.out.println("Input Array: " + Arrays.toString(inputArr2) + ", Reverse Output Array: " + Arrays.toString(reverseArray(inputArr2)));
    }
}
