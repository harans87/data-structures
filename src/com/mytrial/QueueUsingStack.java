package com.mytrial;

public class QueueUsingStack {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    void enqueue (int x) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    int dequeue() {
        if (stack1.isEmpty()) throw new NullPointerException();

        int top = stack1.peek();
        stack1.pop();
        return top;
    }

    boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(10);
        queueUsingStack.enqueue(20);
        queueUsingStack.enqueue(30);
        queueUsingStack.enqueue(40);
        System.out.println("isEmpty -->"+queueUsingStack.isEmpty());

        queueUsingStack.dequeue();
        queueUsingStack.dequeue();
        // queueUsingStack.dequeue();
        // queueUsingStack.dequeue();

        System.out.println("isEmpty -->"+queueUsingStack.isEmpty());

    }
}
