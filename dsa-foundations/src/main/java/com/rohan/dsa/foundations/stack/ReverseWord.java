package com.rohan.dsa.foundations.stack;

/**
 * Example - 1
 * <p>
 * For our first example of using a stack, we’ll examine a very simple task: reversing a
 * word. When you run the program, it asks you to type in a word. When you press
 * Enter, it displays the word with the letters in reverse order.
 * <p>
 * A stack is used to reverse the letters. First, the characters are extracted one by one
 * from the input string and pushed onto the stack. Then they’re popped off the stack
 * and displayed. Because of its Last-In-First-Out characteristic, the stack reverses the
 * order of the characters.
 */
public class ReverseWord {

    public String reverse(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Stack stack = new Stack(input.length());

        // loop from 0 to len - 1
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        System.out.println("Reverse of rohan is " + reverseWord.reverse("rohan"));
        System.out.println("Reverse of java is " + reverseWord.reverse("java"));
        System.out.println("Reverse of react is " + reverseWord.reverse("react"));
    }

    private static class Stack {

        private char[] arr;
        private int top;
        private int size;

        public Stack(int capacity) {
            this.arr = new char[capacity];
            this.top = -1;
        }

        public void push(char element) {

            if (isFull()) {
                throw new IllegalStateException("Stack Overflow");
            }

            top++;
            arr[top] = element;
            size++;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow");
            }
            char c = arr[top];
            top--;
            size--;
            return c;
        }

        private boolean isEmpty() {
            return top == -1;
        }

        private boolean isFull() {
            return top == arr.length - 1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append("[ ").append(arr[i]).append(" ]").append("\n");
            }
            return sb.toString();
        }
    }


}
