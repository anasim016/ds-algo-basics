package com.anasim.cm.masterdsa.array01;

public class BinarySearch03 {

    /**
     *  - Binary Search is an algorithm to find the index of an element in the given array.
     *  - The array need to be a sorted one.
     *  - Time Complexity: O(log n)
     */
    private static int binarySearch(int[] inputArr, int ele) {

        int startIndex = 0;
        int endIndex = inputArr.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (inputArr[midIndex] == ele) {
                return midIndex;
            } else if (inputArr[midIndex] > ele) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

    private static void printOutput(int ele, int res) {

        if (res == -1) {
            System.out.println(ele + " NOT FOUND!");
        } else {
            System.out.println(ele + " is present at index: " + res);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 17, 23, 25, 34, 39, 43, 69, 72, 77, 91};

        printOutput(23, binarySearch(arr, 23));
        printOutput(43, binarySearch(arr, 43));
        printOutput(91, binarySearch(arr, 91));
        printOutput(107, binarySearch(arr, 107));
    }
}
