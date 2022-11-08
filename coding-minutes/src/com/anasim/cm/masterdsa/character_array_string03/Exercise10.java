package com.anasim.cm.masterdsa.character_array_string03;

/**
 *  Given a binary string as input, convert into its decimal form and return it as an integer.
 *
 *  Sample Input:
 *  111
 *
 *  Sample Output:
 *  7
 */

public class Exercise10 {

    private static int convertBinaryToInt(String bStr) {

        int res = 0;
        int exp = 0;

        for (int index = bStr.length() - 1; index >= 0; index--) {
            res = res + (Character.getNumericValue(bStr.charAt(index)) * (int) Math.pow(2, exp));
            exp += 1;
        }
        return res;
    }

    public static void main(String[] args) {

        String bStr = "111";
        System.out.println("Result: " + convertBinaryToInt(bStr));

        bStr = "11010";
        System.out.println("Result: " + convertBinaryToInt(bStr));

        bStr = "10010";
        System.out.println("Result: " + convertBinaryToInt(bStr));
    }
}
