package com.rohan.dsa.foundations.stack;


public class EvaluatePostfix {

    public int evaluate(String postfix) {
        if (postfix == null || postfix.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int len = postfix.length();
        OperandStack stack = new OperandStack(len);
        for (int i = 0; i < len; i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                // operator
                int operand2 = stack.pop(); // Important last in will be the second character
                int operand1 = stack.pop();
                int result = performArithmeticOperation(operand1, operand2, c);
                stack.push(result);
            }
        }

        // Final result
        return stack.pop();
    }

    private static int performArithmeticOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    private boolean isOperand(char c) {
        // return (c >= '0' && ch <= '9');
        return Character.isDigit(c);
    }

    public static void main(String[] args) {
        EvaluatePostfix e = new EvaluatePostfix();
        System.out.println(e.evaluate("57+"));
        System.out.println(e.evaluate("345+*612+/-"));
    }

    private static class OperandStack {
        private int[] arr;
        private int top;
        private int size;

        public OperandStack(int size) {
            this.arr = new int[size];
            this.top = -1;
            this.size = size;
        }

        public void push(int operand) {
            if (isFull()) {
                throw new IllegalStateException("Stack Overflow");
            }

            top++;
            arr[top] = operand;
        }

        private boolean isFull() {
            return top == size - 1;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow");
            }

            int operand = arr[top];
            top--;
            return operand;
        }

        private boolean isEmpty() {
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
