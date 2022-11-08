package com.anasim.cm.masterdsa.character_array_string03;

import java.util.Scanner;

public class ShortestRoute02 {

    private static String getShortestRoute(String route) {

        int x = 0, y = 0;
        String res = "";
        char[] routeArr = route.toCharArray();

        for (char direction : routeArr) {
            switch (direction) {
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
                case 'N':
                    y += 1;
                    break;
                case 'S':
                    y -= 1;
                    break;
            }
        }
        System.out.println("(x, y): (" + x + ", " + y + ")");

        if (x >= 0) {
            while (x > 0) {
                res = res + "E";
                x--;
            }
        } else {
            while (x < 0) {
                res = res + "W";
                x++;
            }
        }

        if (y >= 0) {
            while (y > 0) {
                res = res + "N";
                y--;
            }
        } else {
            while (y < 0) {
                res = res + "S";
                y++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String inputRoute = scn.nextLine();
        System.out.println("Shortest Route for " + inputRoute + ": " + getShortestRoute(inputRoute));
    }
}
