package com.anasim.ztm.masterdsa.ds.hash_tables;

public class MyNode {

    private String nodeKey;
    private int nodeValue;

    MyNode(String key, int value) {
        this.nodeKey = key;
        this.nodeValue = value;
    }

    public String getNodeKey() {
        return this.nodeKey;
    }

    public int getNodeValue() {
        return this.nodeValue;
    }

    @Override
    public String toString() {
        return "(" + this.nodeKey + ", " + this.nodeValue + ")";
    }
}
