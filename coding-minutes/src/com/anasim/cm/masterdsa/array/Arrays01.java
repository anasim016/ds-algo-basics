package com.anasim.cm.masterdsa.array;

public class Arrays01 {

    public static void main(String[] args) {

        int[] marks;
        marks = new int[60];

        int[] scores = new int[20];

        for (int i = 0; i < 10; i++) {
            marks[i] = i * 2;
        }

        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();

        System.out.println("Length of marks: " + marks.length);
        System.out.println("Length of scores: " + scores.length);

        int[] fares = {12, 25, 7, 39};
        System.out.println("Length of fares: " + fares.length);

        /**
         *  In programming languages, the two most prevalent modes of passing arguments to methods are:
         *  1. passing-by-value
         *  2. passing-by-reference
         *
         *  JAVA IS STRICTLY PASS BY VALUE!
         */
    }
}
