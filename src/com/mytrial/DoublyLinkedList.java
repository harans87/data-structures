package com.mytrial;

public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    void append (T data) {
        Node<T> newNode = new Node<T>(data);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    void preappend(T data) {
        Node<T> newNode = new Node<T>(data);
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
    }

    void insertAfter(T data, Node<T> prevNode) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.previous = prevNode;

        if (newNode.next != null)
        newNode.next.previous = newNode;
    }

    void printLinkedList() {
        Node<T> n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    void printReverseLinkedList() {
        Node<T> n = tail;
        while(n != null) {
            System.out.println(n.data + " ");
            n = n.previous;
        }
    }

    void deleteNode(Node<T> nodeToDelete) {
        // delete head
        if (nodeToDelete == head) {
            head = nodeToDelete.next;
            head.previous = null;
            return;
        }

        // delete at the tail
        if (nodeToDelete == tail) {
            tail = nodeToDelete.previous;
            nodeToDelete.previous.next = null;
            return;
        }

        // delete at the middle
        Node<T> n = head;
        while (n != null) {
            if (n == nodeToDelete) {
                n.previous.next = n.next;
                n.next.previous = n.previous;
                return;
            }
            n = n.next;
        }
    }

    // considered input is head
    Node<T> reverseList(Node<T> input) {
        if (input == null) {
            throw new NullPointerException();
        }

        Node<T>  temp = null;
        Node<T> current = input;

        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }

        if (temp != null) {
            this.head = temp.previous;
        }

        return input;

    }

    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        Node<String> headNode = new Node<String>("doubly");
        Node<String> secondNode = new Node<String>("linked");

        headNode.next = secondNode;
        secondNode.previous = headNode;

        doublyLinkedList.head = headNode;
        doublyLinkedList.tail = secondNode;

        doublyLinkedList.printLinkedList();

        doublyLinkedList.append("list");

        System.out.println("\n After appending \n");

        doublyLinkedList.printLinkedList();

        doublyLinkedList.preappend("DEMO");

        System.out.println("\n After pre-appending \n");

        doublyLinkedList.printLinkedList();

        doublyLinkedList.insertAfter("AFTER", doublyLinkedList.head);

        System.out.println("\n After inserAfter \n");

        doublyLinkedList.printLinkedList();
        System.out.println("\n Print reverse \n");

        doublyLinkedList.printReverseLinkedList();

        // doublyLinkedList.deleteNode(doublyLinkedList.head);

        // System.out.println("\n After delete node head \n");

        // doublyLinkedList.printLinkedList();

        // doublyLinkedList.deleteNode(doublyLinkedList.tail);

        // System.out.println("\n After delete node tail \n");

        // doublyLinkedList.printLinkedList();

        // Node<String> middleNode = doublyLinkedList.head.next;

        // doublyLinkedList.deleteNode(middleNode);

        // System.out.println("\n After delete node middle \n");

        // doublyLinkedList.printLinkedList();

        System.out.println("\n After reverse doubly linked list \n");

        doublyLinkedList.reverseList(doublyLinkedList.head);

        doublyLinkedList.printLinkedList();
        
    }


    
}
