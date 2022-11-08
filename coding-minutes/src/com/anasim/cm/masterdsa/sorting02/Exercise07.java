package com.anasim.cm.masterdsa.sorting02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *  Given co-ordinates of N points on X-Y axis, the task is to sort them in accordance to the x-coordinate. If the
 *  x-coordinates are same then sort them in accordance to the y-coordinate.
 *
 *  Sample Input:
 *  { (3, 4), (2, 3), (3, 7), (1, 5), (3, 4) }
 *
 *  Sample Output:
 *  { (1, 5), (2, 3), (3, 4), (3, 4), (3, 7) }
 */

public class Exercise07 {

    private static class Pair {

        private final Integer x;
        private final Integer y;

        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    private static class CartesianPointsComparator implements Comparator<Pair> {

        public int compare(Pair p1, Pair p2) {
            if (p1.x < p2.x) {
               return -1;
            } else if (p1.x > p2.x) {
                return 1;
            } else {
                return p1.y.compareTo(p2.y);
            }
        }
    }

    private static ArrayList<Pair> sortCartesianPoints(ArrayList<Pair> inputList, CartesianPointsComparator cpc) {
        Collections.sort(inputList, cpc);
        return inputList;
    }

    public static void main(String[] args) {

        ArrayList<Pair> li = new ArrayList<>(
                Arrays.asList(
                        new Pair(3, 4),
                        new Pair(2, 3),
                        new Pair(3, 7),
                        new Pair(1, 5),
                        new Pair(3, 4)
                )
        );
        System.out.println("Input List: " + li);
        System.out.println("Sorted List: " + sortCartesianPoints(li, new CartesianPointsComparator()));
    }
}
