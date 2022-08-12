package com.anasim.ztm.masterdsa.ds.linked_lists;

import java.util.Map;
import java.util.HashMap;

public class MyLinkedList {

    private LLNode head;
    private LLNode tail;
    private int length;

    MyLinkedList(Object value) {
        LLNode node = new LLNode(value, null);
        this.head = node;
        this.tail = this.head;
        this.length = 1;
    }

    public String toString() {
        String res = "";
        LLNode currentNode = this.head;
        while (currentNode != null) {
            res = res + currentNode.getNodeValue().toString() + " --> ";
            currentNode = currentNode.getNextNodeRef();
        }
        res = res + "null";
        return "MyLinkedList: " + res + "\nLength: " + this.length + "\n";
    }

    // Time Complexity - O(1)
    public MyLinkedList append(Object value) {
        LLNode newNode = new LLNode(value, null);
        this.tail.setNextNodeRef(newNode);
        this.tail = newNode;
        this.length++;
        return this;
    }

    // Time Complexity - O(1)
    public MyLinkedList prepend(Object value) {
        LLNode newNode = new LLNode(value, this.head);
        this.head = newNode;
        this.length += 1;
        return this;
    }

    public LLNode get(int index) {
        if (index < this.length) {
            int i = 0;
            LLNode currentNode = this.head;
            while (i != index) {
                currentNode = currentNode.getNextNodeRef();
                i++;
            }
            return currentNode;
        }
        return null;
    }

    // My Implementation, Time Complexity - O(n)
    public MyLinkedList insert1(int index, Object value) {
        MyLinkedList res;
        if (index > this.length) {
            res = null;
        } else if (index == 0) {
            res = this.prepend(value);
        } else if (index == this.length) {
            res = this.append(value);
        } else {
            LLNode newNode = new LLNode(value, null);
            int i = 0;
            Map<Integer, LLNode> nodeWithIndex = new HashMap<>();
            LLNode currentNode = this.head;
            while (i <= index) {
                nodeWithIndex.put(i, currentNode);
                if (i == index) {
                    newNode.setNextNodeRef(currentNode);
                    nodeWithIndex.get(i - 1).setNextNodeRef(newNode);
                    this.length += 1;
                }
                i += 1;
                currentNode = currentNode.getNextNodeRef();
            }
            res = this;
        }
        return res;
    }

    // Time Complexity - O(n)
    public MyLinkedList insert2(int index, Object value) {
        MyLinkedList res;
        if (index > this.length) {
            res = null;
        } else if (index == 0) {
            res = this.prepend(value);
        } else if (index == this.length) {
            res = this.append(value);
        } else {
            LLNode newNode = new LLNode(value, null);
            LLNode leadNode = this.get(index - 1);
            LLNode rearNode = leadNode.getNextNodeRef();
            leadNode.setNextNodeRef(newNode);
            newNode.setNextNodeRef(rearNode);
            this.length++;
            res = this;
        }
        return res;
    }

    // Time Complexity - O(n)
    public MyLinkedList remove(int index) {
        if (index < this.length) {
            LLNode leadNode = this.get(index - 1);
            LLNode deleteNode = leadNode.getNextNodeRef();
            LLNode rearNode = deleteNode.getNextNodeRef();
            leadNode.setNextNodeRef(rearNode);
            this.length--;
            return this;
        }
        return null;
    }

    public MyLinkedList reverse() {
        LLNode a = null;
        LLNode b = this.head;
        while (b != null) {
            LLNode c = b.getNextNodeRef();
            b.setNextNodeRef(a);
            a = b;
            b = c;
        }
        this.head = a;
        return this;
    }

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList("Apple");
        System.out.println(mll);
        System.out.println(mll.append("Grape"));
        System.out.println(mll.append(97));
        System.out.println(mll.prepend(23));
        System.out.println(mll.prepend("Banana"));
        System.out.println(mll.insert1(3, "Strawberry"));
        System.out.println(mll.insert1(0, 13));
        System.out.println(mll.insert2(7, "Cherry"));
        System.out.println(mll.insert2(4, "Guava"));
        System.out.println(mll.get(4).getNodeValue());
        System.out.println(mll.get(7).getNodeValue());
        System.out.println(mll.get(1).getNodeValue());
        System.out.println(mll.remove(4));
        System.out.println(mll.remove(7));
        System.out.println(mll.reverse());
    }
}
