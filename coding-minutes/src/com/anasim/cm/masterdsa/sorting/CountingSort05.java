package com.anasim.cm.masterdsa.sorting;

import java.util.Arrays;

public class CountingSort05 {

    /**
     *  Time Complexity: O(n + r)
     *  where 'n' is the size of array and 'r' is the range.
     */
    private static int[] countingSort(int[] inputArr) {

        int maxEle = -1;
        for (int ele : inputArr) {  // Time Complexity: O(n)
            maxEle = Integer.max(ele, maxEle);
        }

        int[] frequencyArr = new int[maxEle + 1];
        Arrays.fill(frequencyArr, 0);
        for (int ele : inputArr) {  // Time Complexity: O(n)
            frequencyArr[ele] += 1;
        }

        int index = 0;
        for (int i = 0; i < frequencyArr.length; i++) {     // Time Complexity: O(n + r)
            while (frequencyArr[i] > 0) {
                inputArr[index] = i;
                index += 1;
                frequencyArr[i] -= 1;
            }
        }
        return inputArr;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {99, 44, 6, 2, 1, 5, 6, 63, 87, 4, 0, 44};
        System.out.println("Sorted Array for " + Arrays.toString(arr) + ": " + Arrays.toString(countingSort(arr)));
    }
}
