package com.rohan.dsa.foundations.stack;

import java.util.Arrays;
import java.util.Optional;

public class InfixToPostfix {

    public String toPostFix(String infix) {

        if (infix == null || infix.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Stack stack = new Stack(infix.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    gotOperator(ch, stack)
                            .map(result::append);
                    break;

                case '(':
                    gotOpeningParenthesis(stack);
                    break;
                case ')':
                    gotClosingParenthesis(stack)
                            .map(result::append);
                    break;
                default:
                    result.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private Optional<String> gotOperator(char opNew, Stack stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            final char opLast = stack.pop();
            final OperatorPrecedence last = OperatorPrecedence.precedenceOf(opLast);
            final OperatorPrecedence current = OperatorPrecedence.precedenceOf(opNew);
            if (current.isGreaterThan(last) ||
                    opLast == '(') {
                stack.push(opLast);
                break;
            } else {
                result.append(opLast);
            }
        }

        stack.push(opNew);
        return Optional.of(result.toString());
    }


    private Optional<String> gotClosingParenthesis(Stack stack) {
        StringBuilder result = new StringBuilder();
        // start popping until you get the closing bracket.
        while (!stack.isEmpty()) {
            char op = stack.pop();
            if (op == '(') {
                break;
            }
            result.append(op);
        }

        return Optional.of(result.toString());
    }

    private void gotOpeningParenthesis(Stack stack) {
        stack.push('(');
    }

    public static void main(String[] args) {
        String[][] inputs = {
                {"A+B-C", "AB+C-"},
                {"A*B/C", "AB*C/"},
                {"A+B*C", "ABC*+"},
                {"A*B+C", "AB*C+"},
                {"A*(B+C)", "ABC+*"},
                {"A*B+C*D", "AB*CD*+"},
                {"(A+B)*(C-D)", "AB+CD-*"},
                {"((A+B)*C)-D", "AB+C*D-"},
                {"A+B*(C-D/(E+F))", "ABCDEF+/-*+"}
        };

        InfixToPostfix converter = new InfixToPostfix();
        Arrays.stream(inputs)
                .forEach(strings -> {
                    System.out.println(
                            String.format("Infix: %s -> PostFix: %s -> Result: %s",
                                    strings[0],
                                    strings[1],
                                    strings[1].equals(converter.toPostFix(strings[0]))));
                });
    }

    private enum OperatorPrecedence {
        LOW,
        HIGH;

        public static OperatorPrecedence precedenceOf(char operator) {
            return (operator == '*' || operator == '/') ? HIGH : LOW;
        }

        public boolean isGreaterThan(OperatorPrecedence op) {
            return this.compareTo(op) > 0;
        }
    }

    private static class Stack {
        private char[] arr;
        private int top;
        private int size;

        public Stack(int size) {
            this.arr = new char[size];
            this.top = -1;
            this.size = size;
        }

        public void push(char character) {
            if (isFull()) {
                throw new IllegalStateException("Stack Overflow");
            }

            top = top + 1;
            arr[top] = character;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow");
            }

            char c = arr[top];
            top--;
            if (isEmpty()) {
                top = -1;
            }
            return c;
        }

        public boolean isFull() {
            return top == size - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i]).append(" ");
            }
            return sb.toString();
        }
    }
}
