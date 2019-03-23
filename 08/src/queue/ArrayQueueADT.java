package queue;

// Inv: (size > 0 && elements[i] != null for i = 0..size - 1) || size = 0
public class ArrayQueueADT {
    private static final int INITIAL_SIZE = 10;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private Object[] elements = new Object[INITIAL_SIZE];

    private static int inc(ArrayQueueADT queue, int x) {
        return (x + 1) % queue.elements.length;
    }

    private static int dec(ArrayQueueADT queue, int x) {
        if (x == 0) {
            return queue.elements.length - 1;
        } else {
            return x - 1;
        }
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity < queue.elements.length) {
            return;
        }

        Object[] newElements = new Object[2 * capacity];
        int ind = 0;
        for (int i = queue.head; i != queue.tail; i = inc(queue, i)) {
            newElements[ind++] = queue.elements[i];
        }
        queue.elements = newElements;
        queue.head = 0;
        queue.tail = ind;
    }

    // Pre: element != null && queue != null
    // Post: size = size' + 1 && queue[size'] = element && other immutable
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue, ++queue.size);
        queue.elements[queue.tail] = element;
        queue.tail = inc(queue, queue.tail);
    }

    // Pre: size > 0 && queue != null
    // Post: Res = queue[0] && other immutable
    public static Object element(ArrayQueueADT queue) {
        return queue.elements[queue.head];
    }

    // Pre: size > 0 && queue != null
    // Post: Res = queue[0] size = size' - 1 queue[i] = queue[i + 1] && other immutable
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;

        Object ans = queue.elements[queue.head];
        queue.size--;
        queue.head = inc(queue, queue.head);
        return ans;
    }


    // Pre: element != null && queue != null
    // Post: queue[i] = queue'[i - 1] for i = 1..size' queue[0] = element size = size' + 1
    public static void push(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue, ++queue.size);
        queue.head = dec(queue, queue.head);
        queue.elements[queue.head] = element;
    }

    // Pre: size > 0 && queue != null
    // Post: Res = queue[size - 1] && other immutable
    public static Object peek(ArrayQueueADT queue) {
        assert queue.size > 0;
        return queue.elements[dec(queue, queue.tail)];
    }

    // Pre: size > 0 && queue != null
    // Post: Res = queue[size - 1] && size = size' - 1 && other immutable
    public static Object remove(ArrayQueueADT queue) {
        assert queue.size > 0;
        queue.tail = dec(queue, queue.tail);
        Object result = queue.elements[queue.tail];
        queue.size--;
        return result;
    }

    // Pre: queue != null
    // Post: Res = size && other immutable
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Pre: queue != null
    // Post: Res = (size == 0) && other immutable
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Pre: queue != null
    // Post: size = 0
    public static void clear(ArrayQueueADT queue) {
        queue.elements = new Object[INITIAL_SIZE];
        queue.size = queue.tail = queue.head = 0;
    }
}
