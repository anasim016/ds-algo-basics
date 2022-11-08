package com.anasim.cm.masterdsa.character_array_string03;

import java.util.Arrays;
import java.util.HashSet;

/**
 *  Given a string 'S', the task is to remove all the duplicates from the given string and return the updated string
 *  in sorted order.
 */

public class Exercise08 {

    private static String removeDuplicatesAndSort1(String inputStr) {

        char ch;
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();

        for (int index = 0; index < inputStr.length(); index++) {
            ch = inputStr.charAt(index);
            if (!hs.contains(ch)) {
                sb.append(inputStr.charAt(index));
                hs.add(ch);
            }
        }

        char[] chArr = sb.toString().toCharArray();
        Arrays.sort(chArr);

        return String.valueOf(chArr);
    }

    private static String removeDuplicatesAndSort2(String inputStr) {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        char[] chArr = inputStr.toCharArray();
        Arrays.sort(chArr);

        while (index < (chArr.length - 1)) {
            if (chArr[index + 1] != chArr[index]) {
                sb.append(chArr[index]);
            }
            index += 1;
        }
        sb.append(chArr[index]);

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "asadnasiminayatafreen";
        System.out.println("Result: " + removeDuplicatesAndSort1(str));
        System.out.println("Result: " + removeDuplicatesAndSort2(str));

        str = "najmazkhatoonz";
        System.out.println("Result: " + removeDuplicatesAndSort1(str));
        System.out.println("Result: " + removeDuplicatesAndSort2(str));
    }
}
