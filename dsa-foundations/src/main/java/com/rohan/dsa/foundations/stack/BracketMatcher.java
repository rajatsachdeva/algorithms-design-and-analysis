package com.rohan.dsa.foundations.stack;

/**
 * Example - 2
 * <p>
 * One common use for stacks is to parse certain kinds of text strings. Typically, the
 * strings are lines of code in a computer language, and the programs parsing them are
 * compilers.
 * <p>
 * To give the flavor of what’s involved, we’ll show a program that checks the delimiters
 * in a line of text typed by the user. This text doesn’t need to be a line of real Java
 * code (although it could be), but it should use delimiters the same way Java does. The
 * delimiters are the braces { and }, brackets [ and ], and parentheses ( and ). Each
 * opening or left delimiter should be matched by a closing or right delimiter; that is,
 * every { should be followed by a matching } and so on. Also, opening delimiters that
 * occur later in the string should be closed before those occurring earlier.
 * <p>
 * Here are some examples:
 * c[d] // correct
 * a{b[c]d}e // correct
 * a{b(c]d}e // not correct; ] doesn’t match (
 * a[b{c}d]e} // not correct; nothing matches final }
 * a{b(c) // not correct; nothing matches opening {
 */
public class BracketMatcher {

    public void match(String input) {

        if (input == null || input.isEmpty()) {
            throw new NullPointerException("Invalid Input");
        }

        Stack stack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[': {
                    stack.push(ch);
                }
                break;
                case '}':
                case ')':
                case ']': {

                    if (!stack.isEmpty()) {
                        char lastCh = stack.pop();
                        if ((ch == ']' && lastCh != '[') ||
                                (ch == ')' && lastCh != '(') ||
                                (ch == '}' && lastCh != '{')) {
                            System.out.println(String.format("not correct; %c doesn’t match %c", ch, lastCh));
                            return; //
                        }
                    } else {
                        System.out.println(String.format("not correct; nothing match final %c", ch));
                        return; //
                    }
                }
                break;
                default:
                    // continue
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("not correct; nothing matches opening " + stack.pop());
        } else {
            System.out.println("correct");
        }
    }

    public static void main(String[] args) {
        BracketMatcher matcher = new BracketMatcher();
        matcher.match("c[d]");
        matcher.match("a{b[c]d}e");
        matcher.match("a{b(c]d}e");
        matcher.match("a[b{c}d]e}");
        matcher.match("a{b(c)");
    }

    private static class Stack {

        private char[] arr;
        private int top;

        public Stack(int capacity) {
            arr = new char[capacity];
            top = -1;
        }

        public void push(char value) {

            if (isFull()) {
                throw new IllegalStateException("Stack Overflow");
            }

            top++;
            arr[top] = value;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow");
            }

            char c = arr[top];
            top--;
            return c;
        }

        public boolean isFull() {
            return top == arr.length - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append("[ ").append(arr[i]).append(" ]").append("\n");
            }
            return sb.toString();
        }

    }
}
