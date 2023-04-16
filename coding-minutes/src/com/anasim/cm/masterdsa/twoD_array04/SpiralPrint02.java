package com.anasim.cm.masterdsa.twoD_array04;

public class SpiralPrint02 {

    private static void spiralPrint1(int[][] inputArr, int noOfRows, int noOfCols) {

        int startRow = 0, endCol = noOfCols - 1, endRow = noOfRows - 1, startCol = 0;

        System.out.print("spiralPrint1 Output: ");
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(inputArr[startRow][i] + " ");
            }

            for (int i = (startRow + 1); i <= endRow; i++) {
                System.out.print(inputArr[i][endCol] + " ");
            }

            for (int i = (endCol - 1); i >= startCol; i--) {
                System.out.print(inputArr[endRow][i] + " ");
            }

            for (int i = (endRow - 1); i > startRow; i--) {
                System.out.print(inputArr[i][startCol] + " ");
            }

            startRow += 1;
            endCol -= 1;
            endRow -= 1;
            startCol += 1;
        }
        System.out.println();
    }

    private static void spiralPrint2(int[][] inputArr, int noOfRows, int noOfCols) {

        int startRow = 0, endRow = noOfRows - 1, startCol = 0, endCol = noOfCols - 1;
        System.out.println("spiralPrint2 Output: " + spiralPrint2Recursive(inputArr, startRow, endRow, startCol, endCol));
    }

    private static String spiralPrint2Recursive(int[][] inputArr, int startRow, int endRow, int startCol, int endCol) {

        StringBuilder sb = new StringBuilder();

        if (startRow == endRow && endRow == startCol && startCol == endCol) {
            return sb.append(inputArr[startRow][startCol]).toString();
        } else if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                sb.append(inputArr[startRow][i]).append(" ");
            }
            return sb.toString();
        } else if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                sb.append(inputArr[i][startCol]).append(" ");
            }
            return sb.toString();
        } else {
            for (int i = startCol; i < endCol; i++) {
                sb.append(inputArr[startRow][i]).append(" ");
            }
            for (int i = startRow; i < endRow; i++) {
                sb.append(inputArr[i][endCol]).append(" ");
            }
            for (int i = endCol; i > startCol; i--) {
                sb.append(inputArr[endRow][i]).append(" ");
            }
            for (int i = endRow; i > startRow; i--) {
                sb.append(inputArr[i][startCol]).append(" ");
            }
            startRow += 1;
            endRow -= 1;
            startCol += 1;
            endCol -= 1;
            return sb.append(spiralPrint2Recursive(inputArr, startRow, endRow, startCol, endCol)).toString();
        }
    }

    public static void main(String[] args) {

        int[][] arr1 = {
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        };
        spiralPrint1(arr1, 5, 3);
        spiralPrint2(arr1, 5, 3);

        int[][] arr2 = {
                {1, 2, 3, 4, 5},
                {12, 13, 14, 15,  6},
                {11, 10, 9, 8, 7}
        };
        spiralPrint1(arr2, 3, 5);
        spiralPrint2(arr2, 3, 5);

        int[][] arr3 = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        spiralPrint1(arr3, 5, 5);
        spiralPrint2(arr3, 5, 5);
    }
}
