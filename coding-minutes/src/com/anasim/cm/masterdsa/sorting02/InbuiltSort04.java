package com.anasim.cm.masterdsa.sorting02;

import java.util.Arrays;
import java.util.Comparator;

public class InbuiltSort04 {

    private static class DescComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer i1, Integer i2) {

            // System.out.println("Comparing i1: " + i1 + " and i2: " + i2);
            if (i1 > i2) {
               return -1;
            } else if (i1 < i2) {
               return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        /**
         *  The inbuilt sort() method is much more efficient than the basic sorting
         *  algorithms (Bubble, Insertion, Selection).
         *  Time Complexity of inbuilt sort() method: O(n log(n))
         */

        System.out.println("Sort in Ascending Order: \n");

        int[] arr1 = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Input Array: " + Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println("Sorted Array: " + Arrays.toString(arr1));

        arr1 = new int[] {99, 44, 6, 2, 1, 5, 6, 63, 87, 4, 0, 44};
        System.out.println("Input Array: " + Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println("Sorted Array: " + Arrays.toString(arr1));

        arr1 = new int[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Input Array: " + Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println("Sorted Array: " + Arrays.toString(arr1));

        /**
         *  Sorting an input array in descending order using a Comparator.
         */

        System.out.println("\n Sort in Descending Order: \n");
        DescComparator dc = new DescComparator();

        Integer[] arr2 = new Integer[] {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Input Array: " + Arrays.toString(arr2));
        Arrays.sort(arr2, dc);
        System.out.println("Sorted Array: " + Arrays.toString(arr2));

        arr2 = new Integer[] {99, 44, 6, 2, 1, 5, 6, 63, 87, 4, 0, 44};
        System.out.println("Input Array: " + Arrays.toString(arr2));
        Arrays.sort(arr2, dc);
        System.out.println("Sorted Array: " + Arrays.toString(arr2));

        arr2 = new Integer[] {21, 6, 3, 19, 2, 99, 20};
        System.out.println("Input Array: " + Arrays.toString(arr2));
        Arrays.sort(arr2, dc);
        System.out.println("Sorted Array: " + Arrays.toString(arr2));
    }
}
