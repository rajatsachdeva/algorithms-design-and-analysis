package com.rohan.dsa.foundations.queue;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * FIFO
 * <p>
 * create
 * enQueue
 * deQueue
 * peek
 * isEmpty
 * isFull
 * deleteQueue
 * <p>
 * Takeaways:-
 * <p>
 * Underflow and Overflow conditions
 * FIFO
 *
 * Revisit
 */
public class Queue {

    private int[] arr;
    private int front;
    private int rear;

    public Queue(int size) {
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue is Full!");
        }

        if (isEmpty()) {
            front = 0;
        }

        rear++;
        arr[rear] = data;
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        int data = arr[front];
        front++;

        // To reset it to empty state
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return arr[front];
    }

    public boolean isFull() {
        return rear == arr.length - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(v -> sb.append(v).append(" <-- "));
        return sb.toString();
    }

    public static void main(String[] args) {

        Queue q = new Queue(5);
        IntStream.range(1, 6).forEach(q::enqueue);
        System.out.println(q);

        System.out.println("Is full ? " + q.isFull());

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        System.out.println("Is empty ? " + q.isEmpty());

        q.enqueue(10);
        System.out.println("Peek -> " + q.peek());
    }

}
