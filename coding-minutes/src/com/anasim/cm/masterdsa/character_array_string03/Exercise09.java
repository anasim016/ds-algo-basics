package com.anasim.cm.masterdsa.character_array_string03;

/**
 *  Given a string 'S' consisting of lowercase English alphabets, return a string containing all the vowels present
 *  in 'S' in serial order.
 *
 *  Sample Input:
 *  S = "aeoibsddaeioudb"
 *
 *  Sample Output:
 *  "aeoiaeiou"
 */

public class Exercise09 {

    public static void main(String[] args) {

        String inputStr = "aeoibsddaeioudb";
        char ch;
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < inputStr.length(); index++) {
            ch = inputStr.charAt(index);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                sb.append(ch);
            }
        }
        System.out.println("Result: " + sb);
    }
}
