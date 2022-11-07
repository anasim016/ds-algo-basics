package com.anasim.cm.masterdsa.character_array_string;

import java.util.Scanner;

public class LargestString03 {

    public static void main(String[] args) {

        int length = Integer.MIN_VALUE;
        String currentStr, res = "";
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the total number of strings from which the largest string needs to be obtained: ");
        int n = scn.nextInt();
        scn.nextLine();

        while (n > 0) {
            System.out.println("Fetching a string from the input stream ...");
            currentStr = scn.nextLine();
            if (currentStr.length() > length) {
                length = currentStr.length();
                res = currentStr;
            }
            n -= 1;
        }

        System.out.println("Largest String: " + res);
    }
}
