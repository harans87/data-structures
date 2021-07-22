package com.mytrial;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    Node(T data) {
     this.data = data;
     this.next = null;
     this.previous = null;
    }
}
