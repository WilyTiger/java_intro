package test;

import queue.ArrayQueueModule;

public class ArrayQueueModuleTest {
    private static void fill() {
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.push(i);
        }
        for (int i = 10; i < 20; i++) {
            ArrayQueueModule.enqueue(i);
        }
    }

    private static void dump() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(ArrayQueueModule.size() + " " + ArrayQueueModule.remove());
        }
    }

    public static void main(String[] args) {
        fill();
        dump();
    }
}