package com.anasim.cm.masterdsa.sorting;

import java.util.Arrays;

/**
 *  Given 'N' sticks and an array 'length' where each length[i] represents length of each stick. Our task is to make
 *  maximum number of pairs of these sticks such that the difference between the length of two sticks is at most 'D'.
 *  A stick can't be part of more than one pair of sticks.
 *
 *  Sample Input:
 *  length = {1, 3, 3, 9, 4}, D = 2
 *
 *  Sample Output:
 *  2
 */

public class Exercise08 {

    private static int pairSticks(int[] stickLengths, int diff) {

        int length = stickLengths.length;
        int res = 0;
        Arrays.sort(stickLengths);

        int index = 0;
        while (index < length - 1) {
            if (stickLengths[index + 1] - stickLengths[index] <= diff) {
                System.out.println("(" + stickLengths[index + 1] + ", " + stickLengths[index] + ")");
                res += 1;
                index += 1;
            }
            index += 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] lengthArr = new int[] {1, 3, 3, 9, 4};
        System.out.println("Result: " + pairSticks(lengthArr, 2));
    }
}
