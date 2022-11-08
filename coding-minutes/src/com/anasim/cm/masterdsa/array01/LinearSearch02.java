package com.anasim.cm.masterdsa.array01;

public class LinearSearch02 {

    /**
     *  - Linear Search is an algorithm to find the index of an element in the given array.
     *  - The array need not be a sorted one.
     *  - Here we compare each element in the array with the element to be found. Once we found the element, we return
     *    the index where the element resides in the given array.
     *  - Time Complexity: O(n)
     */
    private static int linearSearch(int[] inputArr, int ele) {

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    private static void printOutput(int ele, int res) {

        if (res == -1) {
            System.out.println(ele + " NOT FOUND!");
        } else {
            System.out.println(ele + " is present at index: " + res);
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 1, 13, 25, 11, 99, 69, 87, 9};

        printOutput(69, linearSearch(arr, 69));
        printOutput(9, linearSearch(arr, 9));
        printOutput(7, linearSearch(arr, 7));
    }
}
