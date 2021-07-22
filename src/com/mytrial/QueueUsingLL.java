package com.mytrial;

public class QueueUsingLL<T> {
    Node<T> first;
    Node<T> last;

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);
        if (first == null) {
            first = newNode;
            last = newNode;
            return;
        }
        last.next = newNode;
        last = newNode;
    }

    void dequeue() {
        if (first == null) throw new NullPointerException();
        Node<T> temp = first;
        first = temp.next;
        temp = null;
    }

    T peek() {
        return first.data;
    }

    void printQueue() {
        Node<T> temp = first;
        while (temp != null) {
            System.out.println("data -->"+temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        QueueUsingLL<String> queueUsingLL = new QueueUsingLL<>();
        queueUsingLL.enqueue("first");
        queueUsingLL.enqueue("second");
        queueUsingLL.enqueue("third");

        queueUsingLL.printQueue();

        queueUsingLL.dequeue();

        queueUsingLL.printQueue();

        System.out.println("peek -->"+queueUsingLL.peek());
    }
    
}
