package com.mytrial;

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

    // Node insert(Node rootNode, int data) {
    //     Node newNode = new Node(data);
    //     if (rootNode == null) {
    //         this.root = newNode;
    //         return this.root;
    //     } 
    //     // Node alreadyPresent = lookUp(root, data);
    //     // if (alreadyPresent != null) {
    //     //     System.out.println("data already present"+alreadyPresent.data);
    //     //     return true;
    //     // }

    //     // Node temp = root;
    //     // while (newNode.data < temp.data && temp.left != null) {
    //     //     temp = temp.left;
    //     // } 

    //     // while (newNode.data > temp.data && temp.right != null) {
    //     //     temp = temp.right;
    //     // }

    //     // if (temp != null) {
    //     //     if (newNode.data < temp.data) {
    //     //         temp.left = newNode;
    //     //     } else {
    //     //         temp.right = newNode;
    //     //     }
    //     // }

    //     if (newNode.data < rootNode.data) {
    //         this.root.left = insert(rootNode.left, data);
    //     }
    //     if (newNode.data > rootNode.data) {
    //         this.root.right = insert(rootNode.right, data);
    //     }
        
    //     return this.root;
    // }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }

    Node lookUp(Node root, int data) {
        if (root == null) throw new NullPointerException();

        if (root.data == data) {
            System.out.println("found data at root -->"+root.data);
            return root;
        }
        if (data < root.data) {
            return lookUp(root.left, data);
        } 
        return lookUp(root.right, data);
        // Node temp = root;
        //     while(temp != null && data > temp.data && data != temp.data) {
        //         temp = null != temp.right ? temp.right : null;
        //     }
    
        //     while(temp != null && data < temp.data && data != temp.data) {
        //         temp = null != temp.left ? temp.left : null;
        //     }
        //     if (temp != null && temp.data == data) {
        //         System.out.println("found data after loop -->"+temp.data);
        //         return temp;
        //     } else {
        //         return null;
        //     }
    }

    void remove(int data) {

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

        binarySearchTree.lookUp(binarySearchTree.root,170);


    }
    
}
