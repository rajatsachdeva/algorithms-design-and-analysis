package com.rohan.dsa.foundations.queue;

import java.util.Arrays;

/**
 * Double Ended Queue
 * <p>
 * Create a Deque class based on the discussion of deques (double-ended queues) in
 * this chapter. It should include insertLeft(), insertRight(), removeLeft(),
 * removeRight(), isEmpty(), and isFull() methods. It will need to support wraparound
 * at the end of the array, as queues do
 * <p>
 * <p>
 * <p>
 * Implemented Using Circular Arrays
 * <p>
 * https://www.youtube.com/watch?v=pqg0SOPRlJ4&list=PLdo5W4Nhv31bbKJzrsKfMpo_grxuLl8LU&index=48&t=662s
 */
public class Deque {

    private int[] q;
    private int front;
    private int rear;
    private int size;

    public Deque(int size) {
        this.q = new int[size];
        this.size = size;
        front = rear = -1;
    }

    /**
     * Always do front --
     *
     * @param data
     */
    public void enqueueFront(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is Full!");
        }

        // No Element
        if (front == -1 && rear == -1) {
            front = rear = 0; // Incrementing to 0
        }
        // Only the first element
        else if (front == 0) {
            front = size - 1;
        } else {
            // Normal case in case of inserting at first
            front--;
        }
        q[front] = data;
    }

    /**
     * Normal way in which circular queue works
     *
     * @param data
     */
    public void enqueueRear(int data) {

        if (isFull()) {
            throw new IllegalStateException("Queue is Full!");
        }

        if (front == -1 && rear == -1) {
            front = rear = 0;
        } else if (rear + 1 == size) {
            rear = 0;
        } else {
            rear++;
        }

        q[rear] = data;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }

        return q[front];
    }

    /**
     * Normal scenario
     *
     * @return
     */
    public int dequeueFront() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }

        int data = q[front];

        // Only one element
        if (front == rear) {
            front = rear = -1;
        }
        // If front is at the end
        else if (front + 1 == size) {
            front = 0;
        } else {
            // Normal case
            front++;
        }

        return data;
    }


    /**
     * Always do r--
     *
     * @return
     */
    public int dequeueRear() {

        if (isEmpty()) {
            throw new IllegalStateException("Queueu is Empty!");
        }

        int data = q[rear];

        // Only one element
        if (rear == front) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }

        return data;
    }


    public int peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }

        return q[rear];
    }


    public boolean isFull() {
        return (front == 0 && rear + 1 == size) || (rear + 1 == front);
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(q).forEach(v -> sb.append(v).append(" <--> "));
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
