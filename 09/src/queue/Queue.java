package queue;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Queue {
    // Pre: element != null
    // Post: queue[size] = element size = size' + 1 other immutable
    void enqueue(Object element);

    // Pre: element != null
    // Post: queue[i] = queue[i - 1] && queue[0] = element size = size' + 1 other immutable
    void push(Object element);

    // Pre: size > 0
    // Post: Res = queue[0] size = size' - 1 queue[i] = queue[i + 1]
    Object dequeue();

    // Pre: size > 0
    // Post: Res = queue[size - 1] size = size' - 1
    Object remove();

    // Pre: size > 0
    // Post: Res = queue[0]
    Object element();

    // Pre: size > 0
    // Post: Res = queue[size - 1]
    Object peek();

    // Pre: true
    // Post: Res = size
    int size();

    // Pre: true
    // Post: Res = (size == 0)
    boolean isEmpty();

    // Pre: true
    // Post: size = 0
    void clear();

    // Pre: correct predicate
    // Post: queue immutable && Res = {p[0]..p[len]} len <= size && predicate(p[i]) = true
    // Res same type of queue
    Queue filter(Predicate<Object> predicate);

    // Pre: correct function
    // Post: queue immutable && Res = {p[i], p[i] = function(queue[i]) for all i = 0..size - 1)
    // Res same type of queue
    Queue map(Function<Object, Object> function);

}
