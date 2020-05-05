package com.rohan.dsa.foundations.queue;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CircularQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public CircularQueue(int capacity) {
        arr = new int[capacity];
        front = rear = -1;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Cases:
     * <p>
     * 1. Is Full
     * 2. Rear is at the end of the queue. i.e it has occupied the last cell of the queue
     * 3. Normal case
     *
     * @param data
     */
    public void enqueue(int data) {
        //1
        if (isFull()) {
            throw new IllegalStateException("Queue is Full!");
        }

        // When adding first element
        if (front == -1) {
            front = 0;
        }

        //2 -> can also be written as rear = (rear + 1) % capacity
        if (rear + 1 == capacity) {
            rear = 0;
        } else {
            //3
            rear++;
        }

        arr[rear] = data;
        size++;
    }

    /**
     * Key: Takeaways:-
     * Cases to handle
     * 1. No element in the queue
     * 2. Only one element in the queue
     * 3. Front is at the end of the queue
     * 4. Normal case if front is behind rear
     *
     * @return
     */
    public int dequeue() {
        //1
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }

        int data = arr[front];

        //2
        if (front == rear) {
            rear = front = -1;
        }
        // 3 Can also be written as front = (front + 1) % capacity
        else if (front + 1 == capacity) {
            front = 0;
        } else {
            //4
            front++;
        }

        size--;
        return data;
    }


    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        return arr[front];
    }

    private boolean isFull() {
        return size == arr.length;
    }

    /**
     * Cases:
     * 1. Its a full circle
     * 2. Normal case front = 0 and rear = capacity
     * 3. false
     *
     * @return
     */
    private boolean isFullWithoutUsingSize() {

        if (rear + 1 == front) {
            return true;
        } else if (front == 0 && rear + 1 == capacity) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmptyWithoutUsingSize() {
        return rear == -1;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(v -> sb.append(v).append(" <-- "));
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
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
