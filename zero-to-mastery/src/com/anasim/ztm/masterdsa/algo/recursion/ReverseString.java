package com.anasim.ztm.masterdsa.algo.recursion;

public class ReverseString {

    public static String reverseStringRecursive1(String inputStr) {
        if (inputStr.isEmpty()) {
            return "";
        }
        return reverseStringRecursive1(inputStr.substring(1)) + inputStr.charAt(0);
    }

    public static void main(String[] args) {
        String inputStr = "Yo Yo Honey Singh";
        System.out.println("Reverse of '" + inputStr + "': " + reverseStringRecursive1(inputStr));
        inputStr = "";
        System.out.println("Reverse of '" + inputStr + "': " + reverseStringRecursive1(inputStr));
        inputStr = "Hello World!";
        System.out.println("Reverse of '" + inputStr + "': " + reverseStringRecursive1(inputStr));
    }
}
