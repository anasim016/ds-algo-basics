package com.anasim.cm.masterdsa.array;

public class ClosestPairSum10 {

    /**
     *  - Given a sorted array and a number 'ele', find a pair in array whose sum is closest to 'ele'.
     *  - Sample Input:
     *    inputArr = {10, 22, 28, 29, 30, 40}, ele = 54
     *  - Sample Output:
     *    22 and 30
     */

    // Time Complexity: O(n^2)
    private static Pair getClosestPairSum1(int[] inputArr, int ele) {

        int minDiff = Integer.MAX_VALUE;
        Pair res = null;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                int diff = Math.abs(ele - (inputArr[i] + inputArr[j]));
                if (diff < minDiff) {
                    minDiff = diff;
                    res = new Pair(inputArr[i], inputArr[j]);
                }
            }
        }
        return res;
    }

    // Time Complexity: O(n)
    private static Pair getClosestPairSum2(int[] inputArr, int ele) {

        int startIndex = 0, endIndex = inputArr.length - 1, minDiff = Integer.MAX_VALUE;
        Pair res = null;
        while (startIndex < endIndex) {
            int pairSum = inputArr[startIndex] + inputArr[endIndex];
            int diff = Math.abs(ele - pairSum);
            if (diff < minDiff) {
                minDiff = diff;
                res = new Pair(inputArr[startIndex], inputArr[endIndex]);
            }
            if (pairSum > ele) {
                endIndex -= 1;
            } else {
                startIndex += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] inputArr1 = {10, 22, 28, 29, 30, 40};

        System.out.println(getClosestPairSum1(inputArr1, 54));
        System.out.println(getClosestPairSum2(inputArr1, 54));

        System.out.println(getClosestPairSum1(inputArr1, 40));
        System.out.println(getClosestPairSum2(inputArr1, 40));

        System.out.println(getClosestPairSum1(inputArr1, -1));
        System.out.println(getClosestPairSum2(inputArr1, -1));
    }
}
