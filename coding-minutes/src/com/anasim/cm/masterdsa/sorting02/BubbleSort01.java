package com.anasim.cm.masterdsa.sorting02;

import java.util.Arrays;

public class BubbleSort01 {

    /**
     *  Time Complexity:
     *      = O((n - 1) * (n - 2 - 1 + 1))
     *      = O((n - 1) * (n - 2))
     *      = O(n^2)
     */
    private static int[] bubbleSort1(int[] inputArr) {

        int length = inputArr.length;
        int totalNumOfOps = 0;
        for (int n = 1; n < length; n++) {
            for (int i = 0; i < length - 2; i++) {
                totalNumOfOps += 1;
                if (inputArr[i] > inputArr[i + 1]) {
                    int temp = inputArr[i];
                    inputArr[i] = inputArr[i + 1];
                    inputArr[i + 1] = temp;
                }
            }
        }
        System.out.println("totalNumOfOps: " + totalNumOfOps);
        return inputArr;
    }

    /**
     *  Little optimised version of Bubble Sort, even though the time complexity will be O(n^2) only.
     *  But here the best case time complexity will be O(n).
     */
    private static int[] bubbleSort2(int[] inputArr) {

        int length = inputArr.length;
        int totalNumOfOps = 0;
        for (int n = 1; n < length; n++) {
            boolean swapExec = false;
            for (int i = 0; i < length - n - 1; i++) {
                totalNumOfOps += 1;
                if (inputArr[i] > inputArr[i + 1]) {
                    swapExec = true;
                    int temp = inputArr[i];
                    inputArr[i] = inputArr[i + 1];
                    inputArr[i + 1] = temp;
                }
            }
            if (!swapExec) {
                break;
            }
        }
        System.out.println("totalNumOfOps: " + totalNumOfOps);
        return inputArr;
    }

    public static void main(String[] args) {

        int[] arr = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(bubbleSort1(arr)));
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(bubbleSort2(arr)));

        arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(bubbleSort1(arr)));
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(bubbleSort2(arr)));
    }
}
