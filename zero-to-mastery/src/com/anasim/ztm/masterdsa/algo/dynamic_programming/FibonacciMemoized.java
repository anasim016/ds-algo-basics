package com.anasim.ztm.masterdsa.algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoized {

    private static int count = 0;
    private static Map<Integer, Integer> cache = new HashMap<>();

    // Time Complexity - O(2^n)
    public static int fibonacciRecursive(int index) {
        count += 1;
        if (index < 2) {
           return index;
        }
        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    // Time Complexity - O(n)
    public static int fibonacciRecursiveMemoized(int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        } else {
            count += 1;
            System.out.println("Fibonacci Value Not Present For Index: " + index);
            if (index < 2) {
                return index;
            }
            int res = fibonacciRecursiveMemoized(index - 1) + fibonacciRecursiveMemoized(index - 2);
            cache.put(index, res);
            return res;
        }
    }

    public static void main(String[] args) {
        int index = 33;
        System.out.println("Fibonacci Number At Index " + index + ": " + fibonacciRecursive(index));
        System.out.println("Total Number Of Recursive Invocation: " + count);

        count = 0;
        System.out.println("Fibonacci Number At Index " + index + ": " + fibonacciRecursiveMemoized(index));
        System.out.println("Total Number Of Recursive Invocation: " + count);
    }
}
