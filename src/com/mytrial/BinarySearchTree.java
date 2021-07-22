package com.mytrial;

public class BinarySearchTree<T> {
    Node<T> root;
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
    }

    void insert(T data) {
        Node<T> newNode = new Node<>();
        if (root == null) {
            root = newNode;
            return;
        }

    }

    void lookUp(T data) {
        
    }
    
}
