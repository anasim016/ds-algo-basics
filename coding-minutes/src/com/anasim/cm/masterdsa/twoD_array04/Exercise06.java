package com.anasim.cm.masterdsa.twoD_array04;

import java.util.Arrays;

public class Exercise06 {
    private static int[][] preProcess(int[][] inputArr, int noOfRows, int noOfCols) {

        int[][] sumArr = new int[noOfRows][noOfCols];

        for (int row = 0; row < noOfRows; row++) {
            int sumRow = 0;
            for (int col = 0; col < noOfCols; col++) {
                sumRow = sumRow + inputArr[row][col];
                if (row > 0) {
                    sumArr[row][col] = sumRow + sumArr[row - 1][col];
                } else {
                    sumArr[row][col] = sumRow;
                }
            }
        }
        return sumArr;
    }

    private static void print2DArr(int[][] arr) {

        int noOfRows = arr.length;
        for (int row = 0; row < noOfRows; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
    }

    private static void subMatrixSum(int[][] sumArr, int startRow, int startCol, int endRow, int endCol) {

        int res = 0;
        res = res + sumArr[endRow][endCol];

        if (startRow > 0) {
            res = res - sumArr[startRow - 1][endCol];
        }

        if (startCol > 0) {
            res = res - sumArr[endRow][startCol - 1];
        }

        if (startRow > 0 && startCol > 0) {
            res = res + sumArr[startRow - 1][startCol - 1];
        }
        System.out.println(
                "Sub-Matrix sum from (" + startRow + ", " + startCol + ") to (" + endRow + ", " + endCol + "): " + res
        );
    }

    public static void main(String[] args) {

        int[][] arr1 = {
                {1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}
        };
        int noOfRows = arr1.length;
        int noOfCols = arr1[0].length;

        int[][] sumArr = preProcess(arr1, noOfRows, noOfCols);
        print2DArr(sumArr);

        subMatrixSum(sumArr, 0, 0, 1, 1);
        subMatrixSum(sumArr, 2, 2, 3, 4);
        subMatrixSum(sumArr, 1, 2, 3, 3);
    }
}
