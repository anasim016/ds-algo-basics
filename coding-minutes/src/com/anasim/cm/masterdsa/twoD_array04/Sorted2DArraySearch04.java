package com.anasim.cm.masterdsa.twoD_array04;

import java.util.Arrays;

/**
 *  Staircase Search:
 *  Given a 2D array, number of rows, number of columns, and an element. Find the element in the array and return
 *  its coordinates. The input array is sorted in both ways, i.e. Via row-wise and Via column-wise.
 */

public class Sorted2DArraySearch04 {

    // Time Complexity: O( noOfRows * noOfCols ) = { O(n^2) }
    private static Pair04 searchEle1(int[][] inputArr, int noOfRows, int noOfCols, int ele) {

        Pair04 res = new Pair04(-1, -1);
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                if (inputArr[i][j] == ele) {
                    res.setX(i);
                    res.setY(j);
                    return res;
                }
            }
        }
        return res;
    }

    // Time Complexity: O( noOfRows * log(noOfCols) ) = { O(n * log(n)) }
    private static Pair04 searchEle2(int[][] inputArr, int noOfRows, int noOfCols, int ele) {

        Pair04 res = new Pair04(-1, -1);
        for (int i = 0; i < noOfRows; i++) {
            int[] rowArr = inputArr[i];
            int j = Arrays.binarySearch(rowArr, ele);
            if (j >= 0) {
                res.setX(i);
                res.setY(j);
                return res;
            }
        }
        return res;
    }

    // Time Complexity: O( noOfRows + noOfCols - constant ) = { O(n) }
    private static Pair04 searchEle3(int[][] inputArr, int noOfRows, int noOfCols, int ele) {

        Pair04 res = new Pair04(-1, -1);
        int i = noOfRows - 1, j = 0;
        while (i >= 0 && j < noOfCols) {
            if (inputArr[i][j] == ele) {
                res.setX(i);
                res.setY(j);
                return res;
            } else if (inputArr[i][j] < ele) {
                j += 1;
            } else {
                i -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] arr1 = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        System.out.println("searchEle1 Output: " + searchEle1(arr1, 4, 4, 33));
        System.out.println("searchEle1 Output: " + searchEle1(arr1, 4, 4, -10));

        System.out.println("searchEle2 Output: " + searchEle2(arr1, 4, 4, 33));
        System.out.println("searchEle2 Output: " + searchEle2(arr1, 4, 4, -10));

        System.out.println("searchEle3 Output: " + searchEle3(arr1, 4, 4, 33));
        System.out.println("searchEle3 Output: " + searchEle3(arr1, 4, 4, -10));
    }
}
