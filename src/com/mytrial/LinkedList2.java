package com.mytrial;

public class LinkedList2<T> {
    Node<T> head;
    Node<T> tail;

    // push head to next node
    void push (T data) {
        if (data == null) throw new NullPointerException();
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    //add new data to linked list
    void append(T data) {
        if (data == null) throw new NullPointerException();
        Node<T> newNode = new Node<T>(data);
        Node<T> n = head;
        while (n != null) {
            if (n.next == null) {
                n.next = newNode;
                break;
            } else {
                n = n.next;
            }
        }
        tail = newNode;
    }

    // insert data after index
    void insertAfter(T data, Node<T> prevNode) {
        if (data == null || prevNode == null) throw new NullPointerException();
        Node<T> newNode = new Node<T>(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    //delete a node
    void deleteNode(T data) {
        if (data == null) throw new NullPointerException();
        Node<T> prev= null;
        Node<T> n = head;
        // if deleting head shift head to next node
        while(n != null && head.data == data) {
            head = n.next;
            return;
        }

        while (n != null && !n.data.equals(data)) {
            prev = n;
            n = n.next;     
        }

        if (prev == null) return;

        prev.next = n.next; // now n will have data that to be deleted.
    }

    void printLinkedList() {
        Node<T> n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList2<String> linkedList2 = new LinkedList2<>();
        Node<String> node = new Node<String>("sourcingCall");
        linkedList2.head = node;
        Node<String> node2 = new Node<String>("findEarliestDate");
        node.next = node2;
        Node<String> node3 = new Node<String>("deliveryModifyCall");
        node2.next = node3;

        linkedList2.printLinkedList();

        // append a item to list
        linkedList2.append("OFACall");

        linkedList2.printLinkedList();

        // insertAfter
        linkedList2.insertAfter("failure", node2);

        linkedList2.printLinkedList();

        // push head
        linkedList2.push("HEAD");

        linkedList2.printLinkedList();

        //delete node
        linkedList2.deleteNode("failure");

        linkedList2.printLinkedList();

        //delete head
        linkedList2.deleteNode("HEAD");

        linkedList2.printLinkedList();


    }
}
