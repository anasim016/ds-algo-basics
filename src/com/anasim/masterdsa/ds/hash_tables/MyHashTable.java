package com.anasim.masterdsa.ds.hash_tables;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHashTable {

    private int length;
    private MyNodes[] hTable;

    MyHashTable(int size) {
        this.length = size;
        this.hTable = new MyNodes[size];
    }

    /**
     *  This is just a dummy hash function.
     *  The hash functions implemented in any programming language are
     *  very efficient and have a time complexity of O(1).
     */
    private int hashF(String inputStr) {
        int hashIndex = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            hashIndex = (hashIndex + inputStr.codePointAt(i) * i) % this.length;
        }
        return hashIndex;
    }

    public MyNodes[] getHTable() {
        return this.hTable;
    }

    // Time Complexity - O(1)
    public void set(String key, int value) {
        int hashIndex = this.hashF(key);
        if (this.hTable[hashIndex] == null) {
            this.hTable[hashIndex] = new MyNodes();
        }
        this.hTable[hashIndex].add(new MyNode(key, value));
    }

    /**
     *  Generally, the time complexity of get() will be O(1).
     *  But, it can also be O(n) if there is a collision.
     */
    public Integer get(String key) {
        int hashIndex = this.hashF(key);
        MyNodes nodes = this.hTable[hashIndex];
        if (nodes != null) {
            for (MyNode node : nodes) {
                if (node.getNodeKey().equals(key)) {
                    return node.getNodeValue();
                }
            }
            return null;
        }
        return null;
    }

    public ArrayList<String> getKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (MyNodes nodes : this.hTable) {
            if (nodes != null) {
                for (MyNode node : nodes) {
                    keys.add(node.getNodeKey());
                }
            }
        }
        return keys;
    }

    public static void main(String[] args) {
        MyHashTable mht = new MyHashTable(3);
        mht.set("Apple", 49);
        mht.set("Banana", 23);
        mht.set("Guava", 17);
        System.out.println(Arrays.toString(mht.getHTable()));
        System.out.println(mht.get("Guava"));
        System.out.println(mht.get("Papaya"));
        System.out.println(mht.get("Apple"));
        mht.set("Papaya", 1);
        mht.set("Orange", 7);
        System.out.println(Arrays.toString(mht.hTable));
        System.out.println(mht.getKeys());
    }
}
