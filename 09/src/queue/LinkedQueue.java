package queue;

public class LinkedQueue extends AbstractQueue {
    private class Node {
        Object key;
        Node next;
        Node prev;

        public Node(Object key, Node prev, Node next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head, tail;
    public LinkedQueue() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);
    }

    protected void doEnqueue(Object element) {
        Node current = new Node(element, tail, null);

        if (size == 0) {
            head = tail = current;
        } else {
            tail.next = current;
            tail = current;
        }
    }

    protected void doPush(Object element) {
        Node current = new Node(element, null, head);

        if (size == 0) {
            head = tail = current;
        } else {
            head.prev = current;
            head = current;
        }
    }

    protected Object doElement() {
        return head.key;
    }

    protected Object doPeek() {
        return tail.key;
    }

    protected void doDequeue() {
        if (size == 1) {
            head = new Node(null, null, null);
            tail = new Node(null, null, null);
        } else {
            head = head.next;
        }
    }

    protected void doRemove() {
        if (size == 1) {
            head = new Node(null, null, null);
            tail = new Node(null, null, null);
        } else {
            tail = tail.prev;
        }
    }

    protected void doClear() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);
    }

    protected Queue emptyQueue() {
        return new LinkedQueue();
    }
}
