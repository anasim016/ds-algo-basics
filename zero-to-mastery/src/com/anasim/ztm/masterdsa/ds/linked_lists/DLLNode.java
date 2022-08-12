package com.anasim.ztm.masterdsa.ds.linked_lists;

public class DLLNode {

    private Object nodeValue;
    private DLLNode prevNodeRef;
    private DLLNode nextNodeRef;

    DLLNode(Object value, DLLNode leadNodeRef, DLLNode rearNodeRef) {
        this.nodeValue = value;
        this.prevNodeRef = leadNodeRef;
        this.nextNodeRef = rearNodeRef;
    }

    public void setPrevNodeRef(DLLNode ref) {
        this.prevNodeRef = ref;
    }

    public void setNextNodeRef(DLLNode ref) {
        this.nextNodeRef = ref;
    }

    public Object getNodeValue() {
        return this.nodeValue;
    }

    public DLLNode getPrevNodeRef() {
        return this.prevNodeRef;
    }

    public DLLNode getNextNodeRef() {
        return this.nextNodeRef;
    }

    @Override
    public String toString() {
       return "{ nodeValue: " + this.nodeValue + ", prevNodeRef: " + this.prevNodeRef +
               ", nextNodeRef: " + this.nextNodeRef + " }\n";
    }
}
