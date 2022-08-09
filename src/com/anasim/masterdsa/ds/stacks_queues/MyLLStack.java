package com.anasim.masterdsa.ds.stacks_queues;

public class MyLLStack {

    private StackQueueNode top;
    private StackQueueNode bottom;
    private int length;

    MyLLStack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return (this.length == 0);
    }

    public StackQueueNode peek() {
        return this.top;
    }

    public MyLLStack push(Object value) {
        StackQueueNode newNode = new StackQueueNode(value, null);
        if (this.isEmpty()) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            StackQueueNode currentTop = this.top;
            newNode.setNextNodeRef(currentTop);
            this.top = newNode;
        }
        this.length += 1;
        return this;
    }

    public MyLLStack pop() {
        if (this.isEmpty()) {
            return null;
        }
        if (this.length == 1) {
            this.top = null;
            this.bottom = null;
        } else {
            this.top = this.top.getNextNodeRef();
        }
        this.length -= 1;
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
        StackQueueNode currentNode = this.top;
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
        MyLLStack mlls = new MyLLStack();
        System.out.println(mlls.peek() + "\n");
        System.out.println(mlls.push("Google") + "\n");
        System.out.println(mlls.push("Udemy") + "\n");
        System.out.println(mlls.peek() + "\n");
        System.out.println(mlls.push("Discord") + "\n");
        System.out.println(mlls.peek() + "\n");
        System.out.println(mlls.pop() + "\n");
        System.out.println(mlls.pop() + "\n");
        System.out.println(mlls.pop() + "\n");
        System.out.println(mlls.pop() + "\n");
    }
}
