package com.mytrial;
class  LinkedList {
    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            this.data = d;
            next = null;
        }
    }

    public void push(int newData) {

        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node prevNode, int newData) {
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void append(int newData) {
        Node node = new Node(newData);
        if (head == null) {
            head = new Node(newData);
            return;
        }
        node.next = null;
        Node last = head;
        while (last.next != null) 
            last = last.next; 
        last.next = node;
        return;
    }

    public void deleteNode(int key) {
        Node temp = head, prev = null;

        while (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }

    /* This function prints contents of linked list starting from head */
    public void printList()
    {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    /* method to create a simple linked list with 3 nodes*/
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList llist = new LinkedList();

        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        llist.head.next = second; // Link first node with the second node
        second.next = third; // Link second node with the third node
        llist.tail = third;

        llist.append(9);
        llist.push(10);
        llist.insertAfter(llist.head.next, 11);
        llist.deleteNode(9);

        llist.printList();
    }
}