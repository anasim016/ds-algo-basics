package com.anasim.masterdsa.ds.stacks_queues;

public class MyLLQueue {

    private StackQueueNode first;
    private StackQueueNode last;
    private int length;

    MyLLQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return (this.length == 0);
    }

    public StackQueueNode peek() {
        return this.first;
    }

    public MyLLQueue enqueue(Object value) {
        StackQueueNode newNode = new StackQueueNode(value, null);
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNextNodeRef(newNode);
        }
        this.last = newNode;
        this.length++;
        return this;
    }

    public MyLLQueue dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        if (this.length == 1) {
            this.first = null;
            this.last = null;
        } else {
           this.first = this.first.getNextNodeRef();
        }
        this.length--;
        return this;
    }

    private Object getNodeValue(StackQueueNode ref) {
        if (ref != null) {
            return ref.getNodeValue();
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "";
        StackQueueNode currentNode = this.first;
        while (currentNode != null) {
            res = res + currentNode.getNodeValue() + " --> ";
            System.out.println(
                    "NodeValue: " + currentNode.getNodeValue() +
                            ", NextNodeValue: " + this.getNodeValue(currentNode.getNextNodeRef())
            );
            currentNode = currentNode.getNextNodeRef();
        }
        System.out.println("Length: " + this.length);
        res = res + "null";
        return res;
    }

    public static void main(String[] args) {
        MyLLQueue mllq = new MyLLQueue();
        System.out.println(mllq.peek() + "\n");
        System.out.println(mllq.enqueue("Joey") + "\n");
        System.out.println(mllq.enqueue("Chandler") + "\n");
        System.out.println(mllq.peek() + "\n");
        System.out.println(mllq.enqueue("Ross") + "\n");
        System.out.println(mllq.enqueue("Monica") + "\n");
        System.out.println(mllq.dequeue() + "\n");
        System.out.println(mllq.peek() + "\n");
        System.out.println(mllq.dequeue() + "\n");
        System.out.println(mllq.dequeue() + "\n");
        System.out.println(mllq.dequeue() + "\n");
        System.out.println(mllq.dequeue() + "\n");
    }
}
