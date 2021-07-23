package com.mytrial;

import java.net.BindException;

public class BinarySearchTree {
    Node root;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        } 
        Node alreadyPresent = lookUp(data);
        if (alreadyPresent != null) {
            System.out.println("data already present"+alreadyPresent.data);
            return true;
        }

        Node temp = root;
        while (newNode.data < temp.data && temp.left != null) {
            temp = temp.left;
        } 

        while (newNode.data > temp.data && temp.right != null) {
            temp = temp.right;
        }

        if (temp != null) {
            if (newNode.data < temp.data) {
                temp.left = newNode;
            } else {
                temp.right = newNode;
            }
        }
        
        return true;
    }

    Node lookUp(int data) {
        if (root == null) throw new NullPointerException();

        if (root.data == data) {
            System.out.println("found data at root -->"+root.data);
            return root;
        }
        Node temp = root;
        while(data > temp.data && data != temp.data) {
            temp = temp.right;
        }

        while(data < temp.data && data != temp.data) {
            temp = temp.left;
        }
        
        System.out.println("found data after loop -->"+temp.data);

        return temp;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(170);

        binarySearchTree.lookUp(1);


    }
    
}
