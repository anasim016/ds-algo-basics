package com.anasim.ztm.masterdsa;

import java.util.Arrays;

public class Playground {

    private static void findNemo(String[] inputArr) {
        Long t1 = System.currentTimeMillis();
        for(int i = 0; i < inputArr.length; i++) {
            if(inputArr[i].equals("Nemo_75")) {
                System.out.println("Found Nemo_75!");
            }
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("Time Elapsed: " + (t2 - t1) + " ms");
    }

    public static void logAllPairs(int[] inputArr) {
        for(int i = 0; i < inputArr.length; i++) {
            for(int j = 0; j < inputArr.length; j++) {
                System.out.println("(" + inputArr[i] + ", " + inputArr[j] + ")");
            }
        }
    }

    public static void main(String[] args) {

        String[] arr1 = new String[] {"Nemo"};
        String[] arr2 = new String[100000];
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = "Nemo_" + i;
        }
        findNemo(arr2);

        int[] arr3 = new int[] {1, 2, 3, 4, 5};
        logAllPairs(arr3);

        char[] chArr = {'a', 'p', 'k', 'x', 'd', 's'};
        Arrays.sort(chArr);
        System.out.println(Arrays.toString(chArr));
        int[] intArr = {3, 1, 59, 47, 63, 1, 7, 9};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        System.out.println(intArr[8]);
    }
}
