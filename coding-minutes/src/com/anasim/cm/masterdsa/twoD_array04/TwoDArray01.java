package com.anasim.cm.masterdsa.twoD_array04;

import java.util.Scanner;

public class TwoDArray01 {

    private static void printArray(int[][] arr) {

        System.out.println("Output Array: ");
        int row = arr.length, col;
        for (int i = 0; i < row; i++) {
            col = arr[i].length;
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] arr1 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8},
                {9, 10, 11}
        };
        int[][] arr2;
        int m, n;
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter total number of rows: ");
        m = scn.nextInt();
        System.out.print("Enter total number of columns: ");
        n = scn.nextInt();
        arr2 = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }

        printArray(arr1);
        printArray(arr2);

        char[][] arr3 = {
                {'A', 'S', 'A', 'D'},
                "NASIM".toCharArray(),
                "INAYAT".toCharArray(),
                {'A', 'F', 'R', 'E', 'E', 'N'}
        };

        for (int i = 0; i < arr3.length; i++) {
            System.out.println(String.valueOf(arr3[i]));
        }
    }
}
