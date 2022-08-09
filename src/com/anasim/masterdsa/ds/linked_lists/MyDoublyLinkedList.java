package com.anasim.masterdsa.ds.linked_lists;

public class MyDoublyLinkedList {

    private DLLNode head;
    private DLLNode tail;
    private int length;

    MyDoublyLinkedList(Object value) {
        DLLNode newNode = new DLLNode(value, null, null);
        this.head = newNode;
        this.tail = this.head;
        this.length = 1;
    }

    // Time Complexity - O(1)
    public MyDoublyLinkedList append(Object value) {
        DLLNode newNode = new DLLNode(value, null, null);
        DLLNode currentTail = this.tail;
        currentTail.setNextNodeRef(newNode);
        newNode.setPrevNodeRef(currentTail);
        this.tail = newNode;
        this.length += 1;
        return this;
    }

    // Time Complexity - O(1)
    public MyDoublyLinkedList prepend(Object value) {
        DLLNode newNode = new DLLNode(value, null, null);
        DLLNode currentHead = this.head;
        newNode.setNextNodeRef(currentHead);
        currentHead.setPrevNodeRef(newNode);
        this.head = newNode;
        this.length++;
        return this;
    }

    // Time Complexity - O(n)
    public DLLNode get(int index) {
        if (index < this.length) {
            int i = 0;
            DLLNode currentNode = this.head;
            while (i != index) {
                currentNode = currentNode.getNextNodeRef();
                i += 1;
            }
            System.out.println("NodeValue at index " + index + ": " + currentNode.getNodeValue() + "\n");
            return currentNode;
        }
        System.out.println("NodeValue at index " + index + ": null\n");
        return null;
    }

    // Time Complexity - O(n)
    public MyDoublyLinkedList insert(int index, Object value) {
        if (index <= 0) {
            return this.prepend(value);
        } else if (index >= this.length) {
            return this.append(value);
        } else {
            DLLNode newNode = new DLLNode(value, null, null);
            DLLNode leadNode = this.get(index - 1);
            DLLNode rearNode = leadNode.getNextNodeRef();
            leadNode.setNextNodeRef(newNode);
            newNode.setPrevNodeRef(leadNode);
            newNode.setNextNodeRef(rearNode);
            rearNode.setPrevNodeRef(newNode);
            this.length += 1;
            return this;
        }
    }

    // Time Complexity - O(n)
    public MyDoublyLinkedList remove(int index) {
        if (index >= 0 && index < this.length) {
            if (index == 0) {
                DLLNode newHead = this.head.getNextNodeRef();
                newHead.setPrevNodeRef(null);
                this.head = newHead;
            } else if (index == this.length - 1) {
                DLLNode newTail = this.tail.getPrevNodeRef();
                newTail.setNextNodeRef(null);
                this.tail = newTail;
            } else {
                DLLNode deleteNode = this.get(index);
                DLLNode leadNode = deleteNode.getPrevNodeRef();
                DLLNode rearNode = deleteNode.getNextNodeRef();
                leadNode.setNextNodeRef(rearNode);
                rearNode.setPrevNodeRef(leadNode);
            }
            this.length--;
            return this;
        }
        System.out.println("Node not found for index: " + index);
        return null;
    }

    private Object getNodeValue(DLLNode ref) {
        if (ref != null) {
            return ref.getNodeValue();
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "null <-- ";
        DLLNode currentNode = this.head;
        while (currentNode != null) {
            Object currentNodeValue = currentNode.getNodeValue();
            DLLNode prevNode = currentNode.getPrevNodeRef();
            DLLNode nextNode = currentNode.getNextNodeRef();
            res = res + currentNodeValue + " --> <-- ";
            System.out.println(
                    "NodeValue: " + currentNodeValue +
                            ", PrevNodeValue: " + this.getNodeValue(prevNode) +
                            ", NextNodeValue: " + this.getNodeValue(nextNode)
            );
            currentNode = nextNode;
        }
        res = res.substring(0, res.length() - 4) + "null";
        return "[Readable Mode] MyDoublyLinkedList: " + res +
                "\nLength: " + this.length + "\n";
    }

    public static void main(String[] args) {
        MyDoublyLinkedList mdll = new MyDoublyLinkedList("Apple");
        System.out.println(mdll);
        System.out.println(mdll.append(17));
        System.out.println(mdll.append("Banana"));
        System.out.println(mdll.prepend(99));
        System.out.println(mdll.prepend("Grape"));
        mdll.get(2);
        mdll.get(4);
        mdll.get(5);
        System.out.println(mdll.insert(-2, "Papaya"));
        System.out.println(mdll.insert(6, "Cherry"));
        System.out.println(mdll.insert(3, 69));
        System.out.println(mdll.insert(6, "Blueberry"));
        System.out.println(mdll.remove(8));
        System.out.println(mdll.remove(0));
        System.out.println(mdll.remove(2));
        System.out.println(mdll.remove(6));
    }
}
