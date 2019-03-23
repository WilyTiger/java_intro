package test;

import queue.ArrayQueue;
import queue.ArrayQueueADT;

public class ArrayQueueADTTest {
    private static void fill(ArrayQueueADT queue) {
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.push(queue, i);
        }
        for (int i = 10; i < 20; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
    }

    private static void dump(ArrayQueueADT queue) {
        while (!ArrayQueueADT.isEmpty(queue)) {
            System.out.println(ArrayQueueADT.size(queue) + " " + ArrayQueueADT.remove(queue));
        }
    }

    public static void main(String[] args) {
        ArrayQueueADT queue = new ArrayQueueADT();
        fill(queue);
        dump(queue);
    }
}