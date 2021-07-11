package com.mytrial;

public class Stack {
    int MAX_SIZE = 1000;
    int top;
    int[] stack = new int[MAX_SIZE];

    Stack() {
        top = -1;
    }

    public boolean push(int input) {
        if (top >= MAX_SIZE -1) {
            System.out.println("Stack over flow");
            return false;
        }
        stack[++top] = input;
        return true;
    }

    public int pop() {
        if(top < 0) {
            return 0;
        }
        return stack[--top];
    }

    public int peek() {
        if (top < 0) {
            return 0;
        }
        return stack[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(11);
        System.out.println("stack output --> "+stack.peek());
        stack.pop();
        System.out.println("stack output --> "+stack.peek());

    }
}
