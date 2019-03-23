package queue;

// Inv: (size > 0 && elements[i] != null for i = 0..size - 1) || size = 0
public class ArrayQueue {
    private static final int INITIAL_SIZE = 10;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private Object[] elements = new Object[INITIAL_SIZE];

    private int inc(int x) {
        return (x + 1) % elements.length;
    }

    private int dec(int x) {
        if (x == 0) {
            return elements.length - 1;
        } else {
            return x - 1;
        }
    }

    private void ensureCapacity(int capacity) {
        if (capacity < elements.length) {
            return;
        }

        Object[] newElements = new Object[2 * capacity];
        int ind = 0;
        for (int i = head; i != tail; i = inc(i)) {
            newElements[ind++] = elements[i];
        }
        elements = newElements;
        head = 0;
        tail = ind;
    }

    // Pre: element != null
    // Post: size = size' + 1 && queue[size'] = element && other immutable
    public void enqueue(Object element) {
        assert element != null;

        ensureCapacity(++size);
        elements[tail] = element;
        tail = inc(tail);
    }

    // Pre: size > 0
    // Post: Res = queue[0] && other immutable
    public Object element() {
        return elements[head];
    }

    // Pre: size > 0
    // Post: Res = queue[0] size = size' - 1 queue[i] = queue[i + 1] && other immutable
    public Object dequeue() {
        assert size > 0;

        Object ans = elements[head];
        size--;
        head = inc(head);
        return ans;
    }


    // Pre: element != null
    // Post: queue[i] = queue'[i - 1] for i = 1..size' queue[0] = element size = size' + 1
    public void push(Object element) {
        assert element != null;

        ensureCapacity(++size);
        head = dec(head);
        elements[head] = element;
    }

    // Pre: size > 0
    // Post: Res = queue[size - 1] && other immutable
    public Object peek() {
        assert size > 0;
        return elements[dec(tail)];
    }

    // Pre: size > 0
    // Post: Res = queue[size - 1] && size = size' - 1 && other immutable
    public Object remove() {
        assert size > 0;
        tail = dec(tail);
        Object result = elements[tail];
        size--;
        return result;
    }

    // Pre: True
    // Post: Res = size && other immutable
    public int size() {
        return size;
    }

    // Pre: True
    // Post: Res = (size == 0) && other immutable
    public boolean isEmpty() {
        return size == 0;
    }

    // Pre: True
    // Post: size = 0
    public void clear() {
        elements = new Object[INITIAL_SIZE];
        size = tail = head = 0;
    }
}
