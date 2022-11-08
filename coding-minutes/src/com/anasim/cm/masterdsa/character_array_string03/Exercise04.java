package com.anasim.cm.masterdsa.character_array_string03;

/**
 *  Given a string, write a function to check if it is palindrome or not.
 *  A string is said to be palindrome if reverse of the string is same as string.
 *  Example: 'abba' is palindrome, but 'abbc' is not palindrome.
 *
 *  Sample Input:
 *  abcdcba
 *
 *  Sample Output:
 *  true
 */

public class Exercise04 {

    private static boolean isPalindrome1(String str) {

        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr = reverseStr + str.charAt(i);
        }
        return str.equals(reverseStr);
    }

    private static boolean isPalindrome2(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }

    private static boolean isPalindrome3(String str) {

        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {

        String inputStr = "abba";
        System.out.println("Is " + inputStr + " a palindrome: " + isPalindrome1(inputStr));
        System.out.println("Is " + inputStr + " a palindrome: " + isPalindrome2(inputStr));
        System.out.println("Is " + inputStr + " a palindrome: " + isPalindrome3(inputStr));

        inputStr = "coding_minutes";
        System.out.println("Is " + inputStr + " a palindrome: " + isPalindrome1(inputStr));
        System.out.println("Is " + inputStr + " a palindrome: " + isPalindrome2(inputStr));
        System.out.println("Is " + inputStr + " a palindrome: " + isPalindrome3(inputStr));
    }
}
