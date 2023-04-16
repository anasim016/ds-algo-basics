package com.anasim.cm.masterdsa.twoD_array04;

public class Pair04 {

    private int x, y;

    Pair04(int m, int n) {
        this.x = m;
        this.y = n;
    }

    public void setX(int m) {
        this.x = m;
    }

    public void setY(int n) {
        this.y = n;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
