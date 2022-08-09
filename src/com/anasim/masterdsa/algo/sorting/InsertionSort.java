package com.anasim.masterdsa.algo.sorting;

import java.util.Arrays;

public class InsertionSort {

    private static void shiftAndPush(int[] inputArr, int pushIndex, int currentIndex) {
        int currentIndexVal = inputArr[currentIndex];
        for (int j = currentIndex; j > pushIndex; j--) {
            inputArr[j] = inputArr[j - 1];
        }
        inputArr[pushIndex] = currentIndexVal;
    }

    public static int[] insertionSort(int[] inputArr) {
        int length = inputArr.length;
        for (int i = 1; i < length; i++) {
            if (inputArr[i] < inputArr[i - 1]) {
                System.out.println("Need to execute shiftAndPush()");
                for (int j = 0; j < i; j++) {
                    if (inputArr[i] <= inputArr[j]) {
                        shiftAndPush(inputArr, j, i);
                        break;
                    }
                }
            }
        }
        return inputArr;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(insertionSort(inputArr)));

        inputArr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(insertionSort(inputArr)));

        inputArr = new int[] {7, 19, 33, 38, 53, 65, 77, 81};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(insertionSort(inputArr)));
    }
}
