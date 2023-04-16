package com.anasim.cm.masterdsa.twoD_array04;

import java.util.Arrays;

public class PascalTriangle05 {

    private static void printPascalTriangle(int noOfRows) {

        for (int row = 1; row <= noOfRows; row++) {
            int[] rowArr = new int[row];
            if (row == 1) {
                rowArr[row - 1] = 1;
            } else {
                for (int col = 0; col < row; col++) {
                    if (col == 0) {
                        rowArr[col] = 1;
                    } else {
                        int ele = (rowArr[col - 1] * (row - col)) / col;
                        rowArr[col] = ele;
                    }
                }
            }
            System.out.println(Arrays.toString(rowArr));
        }
    }

    public static void main(String[] args) {

        int noOfRows = 10;
        printPascalTriangle(noOfRows);
    }
}
