package com.mytrial;

public class StackUsingArray<T> {
    int initialCapacity = 100;
    Object[] objectArray = new Object[initialCapacity];
    int top = -1;
    int size = 0;

    void push(T data) {
        objectArray[++top] = data;
        size++;
    }

    T pop() {
        if (top < 1) throw new NullPointerException();
        size--;
        return (T) objectArray[top--];
    }

    T peek() {
        if (top < 1) throw new NullPointerException();
        return (T) objectArray[top];
    }

    boolean isEmpty() {
        return size == 0;
    }

    void printStack() {
        int temp = top;
        while(temp >= 0) {
            System.out.println("data -->"+objectArray[temp]);
            temp --;

        }
    }

    public static void main(String[] args) {
        StackUsingArray<String> stackUsingArray = new StackUsingArray<>();
        System.out.println("stack is empty -->"+stackUsingArray.isEmpty());
        stackUsingArray.push("first");
        stackUsingArray.push("second");
        stackUsingArray.push("third");
        System.out.println("stack is empty -->"+stackUsingArray.isEmpty());
        System.out.println("peek -->"+stackUsingArray.peek());
        stackUsingArray.pop();
        stackUsingArray.printStack();
        System.out.println("peek -->"+stackUsingArray.peek());


    }
    
}
