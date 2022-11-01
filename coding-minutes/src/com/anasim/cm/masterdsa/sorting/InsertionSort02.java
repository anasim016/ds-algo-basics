package com.anasim.cm.masterdsa.sorting;

import java.util.Arrays;

public class InsertionSort02 {

    /**
     *  Time Complexity: O(n^2)
     */
    private static int[] insertionSort(int[] inputArr) {

        int length = inputArr.length;
        for (int i = 1; i < length; i++) {
            int currentEle = inputArr[i];
            int prevIndex = i - 1;
            while (prevIndex >= 0 && inputArr[prevIndex] > currentEle) {
                inputArr[prevIndex + 1] = inputArr[prevIndex];
                prevIndex -= 1;
            }
            inputArr[prevIndex + 1] = currentEle;
        }
        return inputArr;
    }

    public static void main(String[] args) {

        int[] arr = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(insertionSort(arr)));

        arr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(insertionSort(arr)));

        arr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(insertionSort(arr)));
    }
}
