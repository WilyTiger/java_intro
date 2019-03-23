package test;

import queue.ArrayQueue;

public class ArrayQueueTest {
    private static void fill(ArrayQueue queue) {
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        for (int i = 10; i < 20; i++) {
            queue.enqueue(i);
        }
    }

    private static void dump(ArrayQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " + queue.remove());
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        fill(queue);
        dump(queue);
    }
}