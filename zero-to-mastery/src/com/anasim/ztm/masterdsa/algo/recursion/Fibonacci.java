package com.anasim.ztm.masterdsa.algo.recursion;

public class Fibonacci {

    // Time Complexity: O(n - 1) = O(n)
    public static long fibonacciIterative(int index) {
        if (index < 2) {
           return index;
        } else {
            int ele1 = 0;
            int ele2 = 1;
            System.out.print("Fibonacci Series: " + ele1 + " " + ele2 + " ");
            int res = 0;
            for (int i = 2; i <= index; i++) {
                res = ele1 + ele2;
                System.out.print(res + " ");
                ele1 = ele2;
                ele2 = res;
            }
            System.out.println();
            return res;
        }
    }

    // Time Complexity: O(2^n) [Horrible]
    public static long fibonacciRecursive(int index) {
        if (index < 2) {
            return index;
        }
        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Element At Index 0: " + fibonacciIterative(0));
        System.out.println("Fibonacci Element At Index 1: " + fibonacciIterative(1));
        System.out.println("Fibonacci Element At Index 6: " + fibonacciIterative(6));
        System.out.println("Fibonacci Element At Index 12: " + fibonacciIterative(12));

        System.out.println("Fibonacci Element At Index 0: " + fibonacciRecursive(0));
        System.out.println("Fibonacci Element At Index 1: " + fibonacciRecursive(1));
        System.out.println("Fibonacci Element At Index 6: " + fibonacciRecursive(6));
        System.out.println("Fibonacci Element At Index 12: " + fibonacciRecursive(12));

        System.out.println("Fibonacci Element At Index 50: " + fibonacciRecursive(50));
    }
}
