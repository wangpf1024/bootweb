package com.controller.bootweb.demo.dsa;

public class CircularQueue {
    private int[] array;
    private int front;  // 队头指针
    private int rear;   // 队尾指针
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity + 1;  // 为了区分队列满和队列空的条件，多预留一个位置
        this.array = new int[this.capacity];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public void enqueue(int value) {
        if (!isFull()) {
            array[rear] = value;
            rear = (rear + 1) % capacity;
        } else {
            System.out.println("Queue is full. Cannot enqueue " + value);
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int value = array[front];
            front = (front + 1) % capacity;
            return value;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;  // 表示队列为空
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return array[front];
        } else {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;  // 表示队列为空
        }
    }

    public int size() {
        return (rear - front + capacity) % capacity;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int count = size();
        int i = front;
        while (count > 0) {
            System.out.print(array[i] + " ");
            i = (i + 1) % capacity;
            count--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.display(); // 输出：1 2 3 4 5

        System.out.println("Dequeue: " + queue.dequeue()); // 输出：Dequeue: 1

        queue.enqueue(6);
        queue.display(); // 输出：2 3 4 5 6
    }
}
