package com.anasim.cm.masterdsa.character_array_string;

import java.util.Arrays;

/**
 *  Given two strings A and B. Check if one string is permutation of the other.
 *  A Permutation of a string is another string that contains same characters, only the order of characters can be
 *  different. Example: 'abcd' and 'dabc' are Permutation of each other.
 */

public class Exercise07 {

    private static boolean arePermutation1(String str1, String str2) {

        if (str1.length() == str2.length()) {
            char[] chArr1 = str1.toCharArray(), chArr2 = str2.toCharArray();
            Arrays.sort(chArr1);
            Arrays.sort(chArr2);
            System.out.println("chArr1: " + Arrays.toString(chArr1) + ", chArr2: " + Arrays.toString(chArr2));
            return Arrays.equals(chArr1, chArr2);
        }
        return false;
    }

    private static boolean arePermutation2(String str1, String str2) {

        if (str1.length() == str2.length()) {
            int asciiSum1 = 0, asciiSum2 = 0;
            int asciiVal1, asciiVal2;
            for (int index = 0; index < str1.length(); index++) {
                asciiVal1 = (int) str1.charAt(index);
                asciiVal2 = str2.charAt(index);
                asciiSum1 = asciiSum1 + asciiVal1;
                asciiSum2 = asciiSum2 + asciiVal2;
            }
            return asciiSum1 == asciiSum2;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Are Permutation? " + arePermutation1("zmnozm", "zmzmon"));
        System.out.println("Are Permutation? " + arePermutation2("zmnozm", "zmzmon"));

        System.out.println("Are Permutation? " + arePermutation1("pqrv", "vqpr"));
        System.out.println("Are Permutation? " + arePermutation2("pqrv", "vqpr"));

        System.out.println("Are Permutation? " + arePermutation1("abcd", "dabe"));
        System.out.println("Are Permutation? " + arePermutation2("abcd", "dabe"));
    }
}
