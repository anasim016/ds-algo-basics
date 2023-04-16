package com.anasim.cm.masterdsa.twoD_array04;

/**
 *  Wave Print Exercise:
 *  Given a 2D array, number of rows, and number of columns, print it in reverse wave form.
 *
 *  Sample Input:
 *  1 2 3 4
 *  5 6 7 8
 *  9 10 11 12
 *  13 14 15 16
 *
 *  Sample Output:
 *  4 8 12 16 15 11 7 3 2 6 10 14 13 9 5 1
 *
 *  Sample Input:
 *  1 9 4 10
 *  3 6 90 11
 *  2 30 85 72
 *  6 31 99 15
 *
 *  Sample Output:
 *  10 11 72 15 99 85 90 4 9 6 30 31 6 2 3 1
 */

public class Exercise03 {

    private enum Direction { UP, DOWN };
    private static Direction currentDir;

    private static void wavePrint(int[][] inputArr, int noOfRows, int noOfCols) {

        int endRow = noOfRows - 1, endCol = noOfCols - 1;
        currentDir = Direction.DOWN;

        while (endCol >= 0) {
            if (currentDir == Direction.DOWN) {
                for (int i = 0; i <= endRow; i++) {
                    System.out.print(inputArr[i][endCol] + " ");
                }
                currentDir = Direction.UP;
            } else {
                for (int i = endRow; i >= 0; i--) {
                    System.out.print(inputArr[i][endCol] + " ");
                }
                currentDir = Direction.DOWN;
            }
            endCol -= 1;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] arr1 = {
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        };
        wavePrint(arr1, 5, 3);

        int[][] arr2 = {
                {1, 2, 3, 4, 5},
                {12, 13, 14, 15,  6},
                {11, 10, 9, 8, 7}
        };
        wavePrint(arr2, 3, 5);

        int[][] arr3 = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        wavePrint(arr3, 5, 5);
    }
}
