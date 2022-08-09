package com.anasim.masterdsa.ds.arrays;

public class MyArray {

    private int itemCount;
    private int length;
    private Object[] items;

    MyArray() {
        this.itemCount = 0;
        this.length = 1;
        this.items = new Object[length];
    }

    @Override
    public String toString() {
        return "MyArray - Item Count: " + this.itemCount + ", Length: " + this.length + ", Data: " + this.items;
    }

    // Time Complexity - O(n)
    public Object[] getItems() {
        System.out.println("Items present inside MyArray: ");
        for(int i = 0; i < length; i++) {
            System.out.println("Item: " + this.items[i] + ", Index: " + i);
        }
        return this.items;
    }

    // Time Complexity - O(1)
    public Object getItem(int index) {
        return this.items[index];
    }

    // Time Complexity - O(n)
    public int pushItem(Object obj) {
        if(this.itemCount == this.length) {
            int updatedLength = length * 2;
            Object[] updatedItems = new Object[updatedLength];
            for(int i = 0; i < items.length; i++) {
                updatedItems[i] = items[i];
            }
            this.items = updatedItems;
            this.length = updatedLength;
        }
        this.items[itemCount] = obj;
        itemCount += 1;
        return this.length;
    }

    // Time Complexity - O(1)
    public Object popItem() {
        Object lastItem = items[length - 1];
        if(this.itemCount == this.length) {
            items[length - 1] = null;
            itemCount -= 1;
        }
        return lastItem;
    }

    // Time Complexity - O(n)
    public Object deleteItem(int index) {
        Object itemToBeDeleted = this.getItem(index);
        this.shiftItems(index);
        itemCount -= 1;
        return itemToBeDeleted;
    }

    // Time Complexity - O(n)
    private void shiftItems(int index) {
        for(int i = index; i < length; i++) {
            if(i != (length - 1)) {
                this.items[i] = this.items[i + 1];
            } else {
                this.items[length - 1] = null;
            }
        }
    }

    public static void main(String[] args) {
        MyArray ma1 = new MyArray();
        System.out.println(ma1);
        System.out.println("Size of MyArray: " + ma1.pushItem("Joey"));
        System.out.println("Size of MyArray: " + ma1.pushItem("Chandler"));
        System.out.println("Size of MyArray: " + ma1.pushItem("Ross"));

        ma1.getItems();
        System.out.println(ma1);

        System.out.println("Size of MyArray: " + ma1.pushItem("Monica"));
        System.out.println("Deleted Item: " + ma1.popItem());
        ma1.getItems();
        System.out.println(ma1);

        System.out.println("Deleted Item: " + ma1.popItem());
        ma1.getItems();
        System.out.println(ma1);

        System.out.println("Size of MyArray: " + ma1.pushItem("Monica"));
        System.out.println(ma1);

        System.out.println("Size of MyArray: " + ma1.pushItem("Rachael"));
        System.out.println(ma1);

        System.out.println("Size of MyArray: " + ma1.pushItem("Phoebe"));
        System.out.println(ma1);

        System.out.println("Size of MyArray: " + ma1.pushItem("Janice"));
        System.out.println(ma1);
        ma1.getItems();

        System.out.println("Deleted Item: " + ma1.deleteItem(4));
        System.out.println(ma1);
        ma1.getItems();

        System.out.println("Size of MyArray: " + ma1.pushItem("Rachael"));
        System.out.println(ma1);

        System.out.println("Size of MyArray: " + ma1.pushItem("Gunther"));
        System.out.println(ma1);
        ma1.getItems();

        System.out.println("Deleted Item: " + ma1.deleteItem(6));
        System.out.println(ma1);
        ma1.getItems();
    }
}

