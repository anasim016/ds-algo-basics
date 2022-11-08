package com.anasim.cm.masterdsa.character_array_string03;

import java.util.List;
import java.util.ArrayList;

/**
 *  Given an array of characters 'chars', compress it using the following algorithm:
 *  Begin with an empty string 'str'. For each group of consecutive repeating characters in 'chars':
 *  - If the group's length is 1, append the character to 'str'.
 *  - Otherwise, append the character followed by the group's length to 'str'.
 *  The compressed string 'str' should not be returned separately, but instead be stored in the input character
 *  array 'chars'.
 *  Note: The group lengths that are 10 or longer will be split into multiple characters in 'chars'.
 */

public class Exercise05 {

    private static void pushCharAndCounter(ArrayList<Character> li, Character currentCh, int currentChCount) {

        li.add(currentCh);
        String currentChCountStr = String.valueOf(currentChCount);
        int index = 0;
        while (currentChCount != 1 && index < currentChCountStr.length()) {
            li.add(currentChCountStr.charAt(index));
            index += 1;
        }
    }

    private static void compressCharacterList1(ArrayList<Character> li) {

        Character currentCh = li.get(0);
        int currentChCount = 1;
        ArrayList<Character> liCopy = new ArrayList<>(li.subList(1, li.size()));
        li.clear();

        for (Character ch : liCopy) {
            if (currentCh.equals(ch)) {
                currentChCount += 1;
            } else {
                pushCharAndCounter(li, currentCh, currentChCount);
                currentCh = ch;
                currentChCount = 1;
            }
        }
        pushCharAndCounter(li, currentCh, currentChCount);
    }

    private static void compressCharacterList2(ArrayList<Character> li) {

        ArrayList<Character> liCopy = new ArrayList<>(li);
        int size = liCopy.size();
        li.clear();

        for (int index = 0; index < size; index++) {
            int currentChCount = 1;
            while (index < (size - 1) && liCopy.get(index + 1).equals(liCopy.get(index))) {
                currentChCount += 1;
                index += 1;
            }
            pushCharAndCounter(li, liCopy.get(index), currentChCount);
        }
    }

    public static void main(String[] args) {

        ArrayList<Character> inputList1 =
                new ArrayList<>(List.of('a', 'b', 'b', 'b', 'b', 'k', 'k', 'k', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'c'));
        ArrayList<Character> inputList2 = new ArrayList<>(inputList1);

        System.out.println("Input List Of Characters: " + inputList1);
        compressCharacterList1(inputList1);
        System.out.println("Modified List Of Characters: " + inputList1);

        System.out.println("Input List Of Characters: " + inputList2);
        compressCharacterList2(inputList2);
        System.out.println("Modified List Of Characters: " + inputList2);
    }
}
