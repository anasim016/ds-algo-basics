package com.anasim.cm.masterdsa.sorting;

import java.util.Arrays;

public class SelectionSort03 {

    /**
     *  Time Complexity: O(n^2)
     */
    private static int[] selectionSort(int[] inputArr) {

        int length = inputArr.length;
        for (int i = 0; i < length - 1; i++) {
            int minEleIndex = i;
            int temp;
            for (int j = i + 1; j < length; j++) {
                if (inputArr[j] < inputArr[minEleIndex]) {
                    minEleIndex = j;
                }
            }
            if (minEleIndex != i) {
                temp = inputArr[i];
                inputArr[i] = inputArr[minEleIndex];
                inputArr[minEleIndex] = temp;
            }
        }
        return inputArr;
    }

    public static void main(String[] args) {

        int[] arr = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(selectionSort(arr)));

        arr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(selectionSort(arr)));

        arr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(selectionSort(arr)));
    }
}
