package com.anasim.ztm.masterdsa.ds.trees;

public class BSTNode {

    private Integer nodeValue;
    private BSTNode leftNodeRef;
    private BSTNode rightNodeRef;

    BSTNode(Integer value) {
        this.nodeValue = value;
        this.leftNodeRef = null;
        this.rightNodeRef = null;
    }

    public void setLeftNodeRef(BSTNode ref) {
        this.leftNodeRef = ref;
    }

    public void setRightNodeRef(BSTNode ref) {
        this.rightNodeRef = ref;
    }

    public Integer getNodeValue() {
        return this.nodeValue;
    }

    public BSTNode getLeftNodeRef() {
        return this.leftNodeRef;
    }

    public BSTNode getRightNodeRef() {
        return this.rightNodeRef;
    }

    @Override
    public String toString() {
        return "{ nodeValue: " + this.nodeValue + ", leftNodeRef: " + this.leftNodeRef +
                ", rightNodeRef: " + this.rightNodeRef + " }";
    }
}
