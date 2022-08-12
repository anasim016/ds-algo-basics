package com.anasim.ztm.masterdsa.ds.stacks_queues;

import java.util.Arrays;

public class MyArrStack {

    private Object[] stack;
    private int length;
    private int currentIndex;

    MyArrStack(int initialStackLength) {
        this.stack = new Object[initialStackLength];
        this.length = initialStackLength;
        this.currentIndex = 0;
    }

    public boolean isEmpty() {
        return (this.currentIndex == 0);
    }

    public int getStackLength() {
        return this.currentIndex;
    }

    public Object peek() {
        Object res = null;
        if (!this.isEmpty()) {
            res = this.stack[this.currentIndex - 1];
        }
        System.out.println(this);
        return res;
    }

    public void push(Object value) {
        if (this.currentIndex < this.length) {
            this.stack[this.currentIndex] = value;
            this.currentIndex++;
        } else {
            int newLength = this.length * 2;
            Object[] newStack = new Object[newLength];
            int i = 0;
            for (Object obj : this.stack) {
                newStack[i] = obj;
                i += 1;
            }
            newStack[this.currentIndex] = value;
            this.stack = newStack;
            this.length = newLength;
            this.currentIndex += 1;
        }
        System.out.println(this + "\n");
    }

    public Object pop() {
        Object res = null;
        if (!this.isEmpty()) {
            int newCurrentIndex = this.currentIndex - 1;
            Object poppedElement = this.stack[newCurrentIndex];
            this.stack[newCurrentIndex] = null;
            this.currentIndex = newCurrentIndex;
            res = poppedElement;
        }
        System.out.println(this);
        return res;
    }

    @Override
    public String toString() {
        String res = "Stack: " + Arrays.toString(this.stack) + "\nLength: " + this.length +
                "\nIndex Where To Add Next Element: " + this.currentIndex;
        return res;
    }

    public static void main(String[] args) {
        MyArrStack mas = new MyArrStack(1);
        System.out.println("Top Element: " + mas.peek() + "\n");
        System.out.println("Deleted Element: " + mas.pop() + "\n");
        mas.push("Google");
        System.out.println("Deleted Element: " + mas.pop() + "\n");
        mas.push("Udemy");
        mas.push("LinkedIn Learning");
        mas.push("Coursera");
        System.out.println("Deleted Element: " + mas.pop() + "\n");
        mas.push("Google");
        mas.push("YouTube");
        mas.push(69);
        System.out.println("Top Element: " + mas.peek() + "\n");
        System.out.println("Deleted Element: " + mas.pop() + "\n");
    }
}
