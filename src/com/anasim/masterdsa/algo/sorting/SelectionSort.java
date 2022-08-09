package com.anasim.masterdsa.algo.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] inputArr) {
        int length = inputArr.length;
        int min;
        int temp;
        for (int i = 0; i < (length - 1); i++) {
            min = i;
            for (int j = (i + 1); j < length; j++) {
                if (inputArr[j] < inputArr[min]) {
                    min = j;
                }
            }
            temp = inputArr[i];
            inputArr[i] = inputArr[min];
            inputArr[min] = temp;
        }
        return inputArr;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(selectionSort(inputArr)));

        inputArr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(selectionSort(inputArr)));

        inputArr = new int[] {7, 19, 33, 38, 53, 65, 77, 81};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(selectionSort(inputArr)));
    }
}
