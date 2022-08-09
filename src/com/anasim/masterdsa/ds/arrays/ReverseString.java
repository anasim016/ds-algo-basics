package com.anasim.masterdsa.ds.arrays;

import java.util.Arrays;

public class ReverseString {

    public static String reverseString(String inputStr, char approach) {
        if(inputStr != null) {
            if(inputStr.isEmpty() || inputStr.length() == 1) {
                return inputStr;
            } else {
                switch (approach) {
                    case 'a':  return reverseString1(inputStr);
                    case 'b':  return reverseString2(inputStr);
                    case 'c':  return reverseString3(inputStr);
                    default: return "Invalid Approach";
                }
            }
        } else {
            return "Encountered NULL";
        }
    }

    private static String reverseString1(String inputStr) {
        System.out.println("Inside Approach 'a'");
        char[] chArr = inputStr.toCharArray();
        char[] chArrCopy = Arrays.copyOf(chArr, chArr.length);
        for(int i = 0; i < chArr.length; i++) {
            chArr[i] = chArrCopy[chArr.length - (i + 1)];
        };
        return getStringFromCharArray(chArr);
    }

    private static String getStringFromCharArray(char[] chArr) {
        String str = "";
        for(char c : chArr) {
            str = str + c;
        }
        return str;
    }

    private static String reverseString2(String inputStr) {
        System.out.println("Inside Approach 'b'");
        String res = "";
        for(int i = (inputStr.length() - 1); i >= 0; i--) {
            res = res.concat(Character.toString(inputStr.charAt(i)));
        }
        return res;
    }

    private static String reverseString3(String inputStr) {
        System.out.println("Inside Approach 'c'");
        return new StringBuilder(inputStr).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Output: " + reverseString("Hey, my name is Data Structure & Algorithm", 'a'));
        System.out.println("Output: " + reverseString("Hey, my name is Data Structure & Algorithm", 'b'));
        System.out.println("Output: " + reverseString("Hey, my name is Data Structure & Algorithm", 'c'));
        System.out.println("Output: " + reverseString(null, 'd'));
        System.out.println("Output: " + reverseString("", 'd'));
        System.out.println("Output: " + reverseString("z", 'd'));
        System.out.println("Output: " + reverseString("zz", 'd'));
    }
}
