package queue;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    protected abstract void doEnqueue(Object element);
    protected abstract void doPush(Object element);
    protected abstract void doDequeue();
    protected abstract void doRemove();
    protected abstract Object doElement();
    protected abstract Object doPeek();
    protected abstract void doClear();
    protected abstract Queue emptyQueue();

    public void enqueue(Object element) {
        assert element != null;

        doEnqueue(element);
        size++;
    }

    public void push(Object element) {
        assert element != null;

        doPush(element);
        size++;
    }


    public Object element() {
        assert size > 0;
        return doElement();
    }

    public Object peek() {
        assert size > 0;
        return doPeek();
    }

    public Object dequeue() {
        assert size > 0;

        Object result = element();
        doDequeue();
        size--;
        return result;
    }

    public Object remove() {
        assert size > 0;

        Object result = peek();
        doRemove();
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        doClear();
        size = 0;
    }

    public Object[] toArray() {
        int sz = size();
        Object[] array = new Object[sz];
        for (int i = 0; i < sz; i++) {
            array[i] = dequeue();
            enqueue(array[i]);
        }
        return array;
    }


    public Queue filter(Predicate<Object> predicate) {
        Queue newQueue = emptyQueue();

        for (int i = 0; i < size; i++) {
            Object value = remove();
            push(value);

            if (predicate.test(value)) {
                newQueue.push(value);
            }
        }
        return newQueue;
    }

    public Queue map(Function<Object, Object> function) {
        Queue newQueue = emptyQueue();

        for (int i = 0; i < size; i++) {
            Object value = remove();
            push(value);

            newQueue.push(function.apply(value));
        }
        return newQueue;
    }

}
