package com.anasim.cm.masterdsa.array01;

public class PrintAllPairs05 {

    /**
     *  Given an array of N integers, the task is to print all the possible pairs from the given array.
     *  Note:
     *  (arr[i], arr[i]) is not considered as a valid pair.
     *  (arr[i], arr[j]) and (arr[j], arr[i]) are considered as one single pair.
     */

    /**
     *  - Time Complexity: O(n^2)
     */
    private static void printAllPairs(int[] inputArr) {

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                System.out.println("(" + inputArr[i] + ", " + inputArr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] inputArr = {10, 20, 30, 40, 50, 60, 70};
        printAllPairs(inputArr);
    }
}
