package com.anasim.ztm.masterdsa.ds.arrays;

public class MergeSortedArrays {

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        if (arr1Length == 0) {
            return arr2;
        } else if (arr2Length == 0) {
            return arr1;
        } else {
            int[] res = new int[arr1Length + arr2Length];
            int i = 0;
            int j = 0;
            int k = 0;
            while (k < res.length) {
                if (i != arr1Length && (j == arr2Length || arr1[i] < arr2[j])) {
                    res[k] = arr1[i];
                    i++;
                } else {
                    res[k] = arr2[j];
                    j++;
                }
                k++;
            }
            return res;
        }
    }

    private static void printArrayElements(int[] inputArr) {
        for (int ele : inputArr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        printArrayElements(mergeSortedArrays(new int[] {1, 10, 17, 29}, new int[] {0, 5, 10, 33, 34}));
        printArrayElements(mergeSortedArrays(new int[] {0, 5, 10, 33, 34}, new int[] {1, 10, 17, 29}));
        printArrayElements(mergeSortedArrays(new int[] {}, new int[] {1, 10, 17, 29}));
        printArrayElements(mergeSortedArrays(new int[] {0, 5, 10, 33, 34}, new int[] {}));
    }
}
