package com.anasim.masterdsa.ds.stacks_queues;

public class QueueUsingStack {

    private MyArrStack queue;

    QueueUsingStack(int initialQueueLength) {
        this.queue = new MyArrStack(initialQueueLength);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public int getQueueLength() {
        return this.queue.getStackLength();
    }

    public Object peek() {
        return this.queue.peek();
    }

    public void push(Object value) {
        if (this.isEmpty()) {
            this.queue.push(value);
        } else {
            MyArrStack s1 = this.queue;
            int s1Length = this.getQueueLength();
            MyArrStack s2 = new MyArrStack(s1Length);
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s2.push(value);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            this.queue = s1;
        }
    }

    public Object pop() {
        return this.queue.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack qus = new QueueUsingStack(1);
        System.out.println("First Element: " + qus.peek() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        qus.push("Google");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        qus.push("Udemy");
        qus.push("LinkedIn");
        qus.push("Twitter");
        qus.push("Instagram");
        qus.push("Facebook");
        System.out.println("First Element: " + qus.peek() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        System.out.println("Deleted Element: " + qus.pop() + "\n");
        System.out.println("isEmpty: " + qus.isEmpty() + ", Length: " + qus.getQueueLength() + "\n");
    }
}
