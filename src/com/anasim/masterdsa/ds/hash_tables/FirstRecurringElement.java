package com.anasim.masterdsa.ds.hash_tables;

import java.util.HashMap;

public class FirstRecurringElement {

    private static Integer getFirstRecurringElement(int[] inputArr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : inputArr) {
            if (map.containsKey(ele)) {
                return ele;
            } else {
                map.put(ele, 1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getFirstRecurringElement(new int[] {1, 2, 3, 1, 3, 5, 2, 1}));
        System.out.println(getFirstRecurringElement(new int[] {1, 2, 3}));
    }
}
