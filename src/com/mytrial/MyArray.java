package com.mytrial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MyArray {

    private int initialCapacity = 2;
    private int[] table;
    private int currentIndex = 0;

    // List<Integer> arr = new ArrayList<>();

    MyArray() {
        table = new int[initialCapacity];
    }

    void insert(int item) {
        // Array grows here.
        if (currentIndex >= initialCapacity) {
            growArray();
        }

        table[currentIndex++] = item;
    }

    private void growArray() {
        initialCapacity = initialCapacity * 2;
        int[] temp = new int[initialCapacity];
        copyArray(temp);
        table = temp;

    }

    void removeAt(int index) {
        if (index >= currentIndex || index < 0) {
            throw new RuntimeException("Invalid Index passed");
        }
        copyArray(table, index + 1, table, index, currentIndex);
        // table[index] = 0;
    }

    void print() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }
    }

    int indexOf(int item) {
        // linear search
        for (int i = 0; i < currentIndex; i++) {
            if (table[i] == item) {
                return i;
            }
        }
        return -1;
    }

    int max() {
        if (currentIndex < 0) {
            System.out.println("Array is empty");
        }
        int largest = table[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            if (table[i] > largest) {
                largest = table[i];
            }
        }

        return largest;
    }

    int maxUsingStream() {
        return Arrays.stream(table)
        .max().getAsInt();
    }

    MyArray intersect(MyArray anotherArray) {
        MyArray commonArray = new MyArray();
        if (currentIndex > 0) {
            for (int i = 0; i < currentIndex; i++) {
                if (anotherArray.indexOf(table[i]) != -1) {
                    commonArray.insert(table[i]);
                }
            }
        }
        return commonArray;
    }

    void reversePrint() {
        for (int i = currentIndex; i >= 0; i--) {
            System.out.println(table[i]);
        }
    }

    void reverse() {
        int[] temp = new int[currentIndex];
        int j = 0;
        for (int i = currentIndex - 1; i >= 0; i--) {
            temp[j++] = table[i];
        }
        table = temp;
    }

    void reverseArrWithoutExtra() {
        // time - O (log n)
        // space - O(1)
        int lastIndex = table.length - 1;
        int temp;
        for (int i=0;i<table.length / 2;i++) {
            temp = table[i];
            table[i] = table[lastIndex];
            table[lastIndex] = temp;
            lastIndex--;
        }
    }

    //NOT WORKING
    void reverseUsingJava8() {
        IntStream.rangeClosed(1, table.length)
        .mapToObj(i -> table[table.length - i]);
    }

    void insertAt(int item, int index) {
        if (currentIndex == index || currentIndex == 0) {
            insert(item);
        } else {
            growArray();
            copyArray(table, index, table, index + 1, currentIndex);
            currentIndex++;
            table[index] = item;
        }
    }

    void copyArray(int[] src, int start, int[] dest, int destStart, int length) {
        for (int i = start; i < length; i++) {
            dest[destStart++] = src[i];
        }
    }

    void copyArray(int[] temp) {
        for (int i = 0; i < currentIndex; i++) {
            temp[i] = table[i];
        }
    }

    public static void main(String[] args) {
        MyArray numbers = new MyArray();
        numbers.insert(5);
        numbers.insert(4);
        numbers.insert(6);

        numbers.print();

        System.out.println("Index of item is: " + numbers.indexOf(5));

        // numbers.removeAt(1);
        numbers.print();

        // numbers.removeAt(10);

        System.out.println("Index of item is: " + numbers.indexOf(100));

        System.out.println("Largest item is: " + numbers.max());

        MyArray numbers2 = new MyArray();
        numbers2.insert(5);
        numbers2.insert(1000);
        numbers2.insert(199);

        // MyArray commonArray = numbers.intersect(numbers2);
        // commonArray.print();

        // numbers.reversePrint();
        // numbers.reverse();
        // numbers.print();
        numbers.insertAt(10, 2);
        numbers.print();
        System.out.println("After reversing");
        numbers.reverseArrWithoutExtra();
        numbers.print();
        System.out.println("before reversing using Java 8");
        numbers.print();
        System.out.println("After reversing using Java 8");
        numbers.reverseUsingJava8();
        numbers.print();
        System.out.println("Maximum element using stream: "+numbers.maxUsingStream());

    }
}
