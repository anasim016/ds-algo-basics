package com.anasim.ztm.masterdsa.ds.stacks_queues;

public class StackQueueNode {

    private Object nodeValue;
    private StackQueueNode nextNodeRef;

    StackQueueNode(Object value, StackQueueNode ref) {
        this.nodeValue = value;
        this.nextNodeRef = ref;
    }

    public void setNextNodeRef(StackQueueNode ref) {
        this.nextNodeRef = ref;
    }

    public Object getNodeValue() {
        return this.nodeValue;
    }

    public StackQueueNode getNextNodeRef() {
        return this.nextNodeRef;
    }

    @Override
    public String toString() {
        return "{ nodeValue: " + this.nodeValue + ", nextNodeRef: " + this.nextNodeRef + " }";
    }
}
