package com.anasim.cm.masterdsa;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {

        int x1 = 1 / 2;
        System.out.println(x1);

        int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println(Arrays.binarySearch(arr1, 70));
        System.out.println(Arrays.binarySearch(arr1, 35));
    }
}
