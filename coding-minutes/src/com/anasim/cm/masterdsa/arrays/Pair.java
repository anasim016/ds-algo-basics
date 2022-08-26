package com.anasim.cm.masterdsa.arrays;

public class Pair {

    private int x, y;

    Pair(int a, int b) {
        this.x = a;
        this.y = b;
    }

    @Override
    public String toString() {
        return this.x + " and " + this.y;
    }
}
