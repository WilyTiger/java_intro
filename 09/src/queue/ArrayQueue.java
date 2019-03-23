package queue;

public class ArrayQueue extends AbstractQueue {
    private static final int INITIAL_SIZE = 10;
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

    public void doEnqueue(Object element) {
        assert element != null;

        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = inc(tail);
    }

    public void doPush(Object element) {
        assert element != null;

        ensureCapacity(size + 1);
        head = dec(head);
        elements[head] = element;
    }

    public Object doElement() {
        return elements[head];
    }

    public Object doPeek() {
        assert size > 0;
        return elements[dec(tail)];
    }

    public void doDequeue() {
        assert size > 0;
        head = inc(head);
    }

    public void doRemove() {
        assert size > 0;
        tail = dec(tail);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void doClear() {
        elements = new Object[INITIAL_SIZE];
        size = tail = head = 0;
    }

    protected Queue emptyQueue() {
        return new ArrayQueue();
    }
}
