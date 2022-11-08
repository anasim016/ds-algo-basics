package com.anasim.cm.masterdsa.sorting02;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Theodore implements a new strategy game 'Defense of a Kingdom'. On each level a player defends the Kingdom that is
 *  represented by a rectangular grid of cells. The player builds crossbow towers in some cells of the grid. The tower
 *  defends all the cells in the same row and the same column. No two towers share a row or a column. The penalty of the
 *  position is the number of cells in the largest undefended rectangle.
 *
 *  Sample Input:
 *  width = 15, height = 8, positions = {(3, 8), (11, 2), (8, 6)}
 *
 *  Sample Output:
 *  12
 */

public class Exercise09 {

    private static Integer computeDefenseKingdomPenalty(int width, int height, ArrayList<Position09> positions) {

        int newSize = positions.size() + 2;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        ArrayList<Integer> xArr = new ArrayList<>(newSize), yArr = new ArrayList<>(newSize);

        xArr.add(0);
        yArr.add(0);
        for (Position09 pos : positions) {
            xArr.add(pos.getX());
            yArr.add(pos.getY());
        }
        xArr.add(width + 1);
        yArr.add(height + 1);

        Collections.sort(xArr);
        Collections.sort(yArr);

        for (int i = 1; i < xArr.size(); i++) {
            maxX = Integer.max(maxX, xArr.get(i) - xArr.get(i - 1) - 1);
        }

        for (int i = 1; i < yArr.size(); i++) {
            maxY = Integer.max(maxY, yArr.get(i) - yArr.get(i - 1) - 1);
        }

        System.out.println("maxX: " + maxX + ", maxY: " + maxY);
        return maxX * maxY;
    }

    public static void main(String[] args) {

        ArrayList<Position09> positions = new ArrayList<>(
                Arrays.asList(
                        new Position09(3, 8),
                        new Position09(11, 2),
                        new Position09(8, 6)
                )
        );
        System.out.println("Defense Kingdom Penalty: " + computeDefenseKingdomPenalty(15, 8, positions));
    }
}
