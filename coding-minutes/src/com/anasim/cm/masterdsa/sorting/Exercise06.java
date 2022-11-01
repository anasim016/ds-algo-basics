package com.anasim.cm.masterdsa.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

/**
 *  Given an integer list and a boolean variable flag, the task is to sort the list in accordance to the boolean value.
 *  If the boolean value passed is true then sort it in ascending order or vice versa.
 *
 *  Sample Input:
 *  {111, 33, 5, 7, 29}, flag = true
 *
 *  Sample Output:
 *  {5, 7, 29, 33, 111}
 */

public class Exercise06 {

    private static ArrayList<Integer> sort(ArrayList<Integer> inputList, boolean flag) {

        if (flag) {
            Collections.sort(inputList);
        } else {
            Collections.sort(inputList, Collections.reverseOrder());
        }
        return inputList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(111, 33, 5, 7, 29));
        System.out.println("Input List: " + li);
        System.out.println("Sorted List in Ascending Order: " + sort(li, true));
        System.out.println("Sorted List in Descending Order: " + sort(li, false));
    }
}
