package com.anasim.ztm.masterdsa.algo.sorting;

import java.util.Arrays;

public class MergeSort {

    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    public static int[] mergeSort(int[] inputArr) {
        int length = inputArr.length;
        if (length == 0 || length == 1) {
            return inputArr;
        }
        return splitAndMerge(inputArr, length);
    }

    private static int[] splitAndMerge(int[] inputArr, int length) {
        if (length == 1) {
            return inputArr;
        }
        int mid = (int) Math.floor(length / 2);
        int[] lhsArr = splitLeftOrRight(inputArr, length, mid, LEFT);
        int[] rhsArr = splitLeftOrRight(inputArr, length, mid, RIGHT);
        System.out.println("InputArray: " + Arrays.toString(inputArr) + ", Length: " + length + ", Mid: " + mid +
                ", LHSArray: " + Arrays.toString(lhsArr) + ", RHSArray: " + Arrays.toString(rhsArr));
        return merge(splitAndMerge(lhsArr, lhsArr.length), splitAndMerge(rhsArr, rhsArr.length));
    }

    private static int[] splitLeftOrRight(int[] inputArr, int length, int mid, String side) {
        int[] resArr;
        int index = 0;
        if (side.equals(LEFT)) {
            resArr = new int[mid];
            while (index < mid) {
                resArr[index] = inputArr[index];
                index++;
            }
        } else {
            resArr = new int[length - mid];
            int inputArrIndex = mid;
            while (inputArrIndex < length) {
                resArr[index] = inputArr[inputArrIndex];
                index++;
                inputArrIndex += 1;
            }
        }
        return resArr;
    }

    private static int[] merge(int[] lhsArr, int[] rhsArr) {
        int lhsLength = lhsArr.length;
        int rhsLength = rhsArr.length;
        int resArrLength = lhsLength + rhsLength;
        int[] resArr = new int[resArrLength];
        int lhsArrIndex = 0;
        int rhsArrIndex = 0;
        for (int index = 0; index < resArrLength; index++) {
            if (lhsArrIndex < lhsLength && rhsArrIndex < rhsLength) {
                if (lhsArr[lhsArrIndex] <= rhsArr[rhsArrIndex]) {
                    resArr[index] = lhsArr[lhsArrIndex];
                    lhsArrIndex += 1;
                } else {
                    resArr[index] = rhsArr[rhsArrIndex];
                    rhsArrIndex += 1;
                }
            } else {
                if (lhsArrIndex < lhsLength) {
                    resArr[index] = lhsArr[lhsArrIndex];
                    lhsArrIndex += 1;
                } else {
                    resArr[index] = rhsArr[rhsArrIndex];
                    rhsArrIndex += 1;
                }
            }
        }
        System.out.println("MergedArray: " + Arrays.toString(resArr));
        return resArr;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(mergeSort(inputArr)) + "\n");

        inputArr = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(mergeSort(inputArr)) + "\n");

        inputArr = new int[] {7, 19, 33, 38, 53, 65, 77, 81};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(mergeSort(inputArr)) + "\n");

        inputArr = new int[] {};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(mergeSort(inputArr)) + "\n");

        inputArr = new int[] {963};
        System.out.println("Sorted Array for " + Arrays.toString(inputArr) + ": " + Arrays.toString(mergeSort(inputArr)) + "\n");
    }
}
