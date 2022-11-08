package com.anasim.cm.masterdsa.array01;

import java.util.ArrayList;
import java.util.Arrays;

public class KRotate11 {

    /**
     *  - Given an integer Vector or ArrayList and a value k. The task is to rotate the array k times clockwise.
     *  - Sample Input:
     *    inputArr = {1, 3, 5, 7, 9}, k = 2
     *  - Sample Output:
     *    {7, 9, 1, 3, 5}
     *  - Explanation:
     *    After 1st rotation - {9, 1, 3, 5, 7}
     *    After 2nd rotation - {7, 9, 1, 3, 5}
     */

    private static ArrayList<Integer> getKRotatedArr(ArrayList<Integer> inputArr, int arrSize, int k) {

        System.out.println("Executing getKRotatedArr() ... noOfRotationReq: " + k);
        ArrayList<Integer> res = new ArrayList<>(arrSize);
        for (int i = 0; i < arrSize; i++) {
            if (i < k) {
                res.add(inputArr.get(arrSize + i - k));
            } else {
                res.add(inputArr.get(i - k));
            }
        }
        return res;
    }

    private static ArrayList<Integer> kRotate(ArrayList<Integer> inputArr, int k) {

        int arrSize = inputArr.size();
        k = k % arrSize;
        ArrayList<Integer> res;
        res = k == 0 ? inputArr : getKRotatedArr(inputArr, arrSize, k);
        return res;
    }

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        int noOfRotationReq = 2;
        System.out.println(kRotate(al, noOfRotationReq));

        noOfRotationReq = 100;
        System.out.println(kRotate(al, noOfRotationReq));

        noOfRotationReq = 999;
        System.out.println(kRotate(al, noOfRotationReq));
    }
}
