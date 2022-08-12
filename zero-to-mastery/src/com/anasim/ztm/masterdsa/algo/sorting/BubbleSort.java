package com.anasim.ztm.masterdsa.algo.sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     *  Time Complexity: O(n * (n - 1)) = O(n * n) = O(n^2)
     *  Space Complexity: O(1)
     *  Here, it might happen that the array gets sorted before it reaches the iteration where no swapping
     *  is required. But still we are executing those unnecessary iterations. We can optimize this.
     */
    public static int[] bubbleSort(int[] inputArr) {
        int length = inputArr.length;
        for (int i = 1; i <= length; i++) {
            boolean swapExc = false;
            for (int j = 0; j < (length - 1); j++) {
                if (inputArr[j] > inputArr[j + 1]) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j + 1];
                    inputArr[j + 1] = temp;
                    swapExc = true;
                }
            }
            System.out.println("i: " + i + ", swapExc: " + swapExc);
        }
        return inputArr;
    }

    /**
     *  If we observe Bubble Sort algo, once iteration `i` is complete, it puts `i`th largest element to
     *  (length - i) index. Here, `i` starts with 1. Example - If we have an array of length `n`.
     *  When `i` is equal to -
     *      1: Puts 1st largest element to (n - 1) index.
     *      2: Puts 2nd largest element to (n - 2) index.
     *      3: Puts 3rd largest element to (n - 3) index.
     *      .
     *      .
     *      .
     *      (n - 1): Puts (n - 1)th largest element to 1 index. How index 1? (n - (n - 1))
     *  So, it requires total (n - 1) iterations.
     */
    public static int[] bubbleSortOptimized(int[] inputArr) {
        int length = inputArr.length;
        for (int i = 1; i < length; i++) {
            boolean swapExc = false;
            for (int j = 0; j < (length - i); j++) {
                if (inputArr[j] > inputArr[j + 1]) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j + 1];
                    inputArr[j + 1] = temp;
                    swapExc = true;
                }
            }
            System.out.println("i: " + i + ", swapExc: " + swapExc);
            if (!swapExc) {
                break;
            }
        }
        return inputArr;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("[Unoptimized] Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(bubbleSort(inputArr)));
        inputArr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("[Optimized] Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(bubbleSortOptimized(inputArr)));

        inputArr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("[Unoptimized] Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(bubbleSort(inputArr)));
        inputArr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("[Optimized] Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(bubbleSortOptimized(inputArr)));

        inputArr = new int[] {7, 19, 33, 38, 53, 65, 77, 81};
        System.out.println("[Unoptimized] Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(bubbleSort(inputArr)));
        inputArr = new int[] {7, 19, 33, 38, 53, 65, 77, 81};
        System.out.println("[Optimized] Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(bubbleSortOptimized(inputArr)));
    }
}
