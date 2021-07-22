package com.mytrial;

import java.util.ArrayList;
import java.util.List;

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
                newNode.previous = n;
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

    Node<T> deleteAtPosition(int position) {
        Node<T> n = head;
        Node<T> prev = null;
        int counter = 0;
        if (position == 0) {
            head = n.next;
            return head;
        }
        while(n != null && counter != position) {
            counter++;
            prev = n;
            n = n.next;
        }
        if(n == null) return null;
        prev.next = n.next;
        return head;
    }

    void printLinkedList() {
        Node<T> n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    void reversePrint(Node<T> head) {
        Node<T> n = head;
        List<Node<T>> prev = new ArrayList<>();
        while (n != null && n.next != null) {
            prev.add(n);
            n = n.next;
        }
        prev.add(n); //adding this since last item next will be null;
        for (int i=prev.size()-1;i>=0;i--) {
            System.out.println("LinkedList in reversed order -->"+prev.get(i).data);
        }
    }

    void reverse(Node<T> head) {
        Node<T> current = head;
        Node<T> next = null;
        Node<T> prev = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    boolean compareLists(Node<T> head1, Node<T> head2) {
        Node<T> n1 = head1;
        Node<T> n2 = head2;
        if (n1 == null && n2 == null) return true;
        while(n1 != null && n2!= null) {
            return n1.data == n2.data && compareLists(n1.next, n2.next);
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedList2<String> linkedList2 = new LinkedList2<>();
        Node<String> node = new Node<String>("sourcingCall");
        linkedList2.head = node;
        Node<String> node2 = new Node<String>("findEarliestDate");
        node.next = node2;
        node2.previous = node;
        Node<String> node3 = new Node<String>("deliveryModifyCallll");
        node2.next = node3;
        node3.previous = node2;

        LinkedList2<String> linkedList3 = new LinkedList2<>();
        Node<String> node4 = new Node<String>("sourcingCall");
        linkedList3.head = node4;
        Node<String> node5 = new Node<String>("findEarliestDate");
        node4.next = node5;
        // node2.previous = node;
        Node<String> node6 = new Node<String>("deliveryModifyCall");
        node5.next = node6;
        // node3.previous = node2;

        // linkedList2.printLinkedList();

        // append a item to list
        // linkedList2.append("OFACall");

        // linkedList2.printLinkedList();

        // insertAfter
        // linkedList2.insertAfter("failure", node2);

        // linkedList2.printLinkedList();

        // push head
        // linkedList2.push("HEAD");

        // linkedList2.printLinkedList();

        // //delete node
        // linkedList2.deleteNode("failure");

        // linkedList2.printLinkedList();

        // //delete head
        // linkedList2.deleteNode("HEAD");

        // linkedList2.printLinkedList();

        //delete at position
        // Node<String> result = linkedList2.deleteAtPosition(0);
        // System.out.println("\n Head Node --->"+result.data);
        // linkedList2.printLinkedList();

        // linkedList2.reversePrint(linkedList2.head);

        // linkedList2.reverse(linkedList2.head);
        // linkedList2.printLinkedList();

        System.out.println("result -->"+linkedList2.compareLists(linkedList2.head, linkedList3.head));

    }
}
