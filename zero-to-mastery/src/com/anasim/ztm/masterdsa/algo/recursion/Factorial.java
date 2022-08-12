package com.anasim.ztm.masterdsa.algo.recursion;

public class Factorial {

    // Time Complexity: O(n - 1) = O(n)
    public static int findFactorialIterative(int inputInt) {
        int res = 1;
        for (int i = inputInt; i > 1; i--) {
            res = res * i;
        }
        return res;
    }

    // Time Complexity: O(n - 1) = O(n)
    public static int findFactorialRecursive(int inputInt) {
        if (inputInt == 2) {
            return inputInt;
        }
        return inputInt * findFactorialRecursive(inputInt - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 6: " + findFactorialIterative(6));
        System.out.println("Factorial of 6: " + findFactorialRecursive(6));

        System.out.println("Factorial of 13: " + findFactorialIterative(13));
        System.out.println("Factorial of 13: " + findFactorialRecursive(13));
    }
}
