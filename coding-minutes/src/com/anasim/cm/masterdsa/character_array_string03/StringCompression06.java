package com.anasim.cm.masterdsa.character_array_string03;

public class StringCompression06 {

    private static void appendCharAndCounter(StringBuilder sb, char currentCh, int currentChCount) {
        sb.append(currentCh);
        sb.append(currentChCount);
    }

    private static String getResult(String inputStr, String compressedString) {

        System.out.println("Input String: " + inputStr + ", Compressed String: " + compressedString);
        if (inputStr.length() < compressedString.length()) {
            return inputStr;
        }
        return compressedString;
    }

    private static String compressString1(String inputStr) {

        StringBuilder sb = new StringBuilder();
        char currentCh = inputStr.charAt(0);
        int currentChCount = 1;
        int length = inputStr.length();

        for (int index = 1; index < length; index++) {
            if (currentCh == inputStr.charAt(index)) {
                currentChCount += 1;
            } else {
                appendCharAndCounter(sb, currentCh, currentChCount);
                currentCh = inputStr.charAt(index);
                currentChCount = 1;
            }
        }
        appendCharAndCounter(sb, currentCh, currentChCount);

        return getResult(inputStr, sb.toString());
    }

    private static String compressString2(String inputStr) {

        StringBuilder sb = new StringBuilder();
        int length = inputStr.length();

        for (int index = 0; index < length; index++) {
            int currentChCount = 1;
            while (index < (length - 1) && inputStr.charAt(index + 1) == inputStr.charAt(index)) {
                currentChCount += 1;
                index += 1;
            }
            appendCharAndCounter(sb, inputStr.charAt(index), currentChCount);
        }

        return getResult(inputStr, sb.toString());
    }

    public static void main(String[] args) {

        String str1 = "aabbbbekkkkkkkkkkkkz";
        System.out.println("Result: " + compressString1(str1));
        System.out.println("Result: " + compressString2(str1));

        str1 = "abcd";
        System.out.println("Result: " + compressString1(str1));
        System.out.println("Result: " + compressString2(str1));
    }
}
