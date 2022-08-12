package com.anasim.ztm.masterdsa.ds.linked_lists;

public class LLNode {

    private Object nodeValue;
    private LLNode nextNodeRef;

    LLNode(Object value, LLNode ref) {
        this.nodeValue = value;
        this.nextNodeRef = ref;
    }

    public Object getNodeValue() {
        return this.nodeValue;
    }

    public void setNextNodeRef(LLNode ref) {
        this.nextNodeRef = ref;
    }

    public LLNode getNextNodeRef() {
        return this.nextNodeRef;
    }

    @Override
    public String toString() {
        return "{ nodeValue: " + this.nodeValue + ", nextNodeRef: " + this.nextNodeRef + " }\n";
    }
}
