package com.mytrial;

import java.util.Stack;

public class LinkedListStack<T> {
    Node<T> top;

    static class Node<T> {
        T data;
        Node<T> link;

        Node(T data) {
            this.data = data;
            this.link = null;
        }
    }



    void push(T data) {
        Node<T> node = new Node<T>(data);
        if (top == null) {
            top = node;
            return;
        }
        node.link = top;
        top = node;
    }

    void pop() {
        if (top == null) throw new NullPointerException();
        Node<T> temp = top;
        top = top.link;
        temp.link = null;
    }

    T peek() {
        if (top == null) throw new NullPointerException();
        return top.data;
    }

    void printStack() {
        Node<T> node = top;
        while (node != null) {
            System.out.println("data -->"+node.data);
            node = node.link;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack<>();
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("topItem");
        linkedListStack.push("secondItem");
        linkedListStack.push("thirdItem");

        linkedListStack.printStack();

        linkedListStack.pop();

        linkedListStack.printStack();

        System.out.println("peek -->"+linkedListStack.peek());
    }
    
}
