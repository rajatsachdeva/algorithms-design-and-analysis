package com.rohan.dsa.foundations.stack;

import java.util.stream.IntStream;

/**
 * Stack using Arrays
 * <p>
 * - It is a logical data structure
 * - It follows LIFO (Last in first out)
 * - Eg. Browser back button, UI Application where we
 * push and pop the screens
 */
public class Stack {
    private int[] stack;
    private int size;
    private int top;

    public Stack(int size) {
        this.stack = new int[size];
        this.size = size;
        top = -1;
    }

    // O(1)
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow...");
        }
        top += 1;
        stack[top] = value;
    }

    // O(1)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow...");
        }

        int element = stack[top];
        stack[top] = -1;
        top--;
        return element;
    }

    // top variable is not updated
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow...");
        }
        return stack[top];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void delete() {
        stack = null;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(String.format("[ %d ]", stack[i]));
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Stack stack = new Stack(5);
        IntStream.range(10, 15).forEach(stack::push);
        stack.print();

        System.out.println("Stack is full? : " + stack.isFull());

        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }

        System.out.println("Peeking... : " + stack.peek());
        stack.print();
    }
}
