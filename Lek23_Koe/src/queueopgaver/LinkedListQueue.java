package queueopgaver;

import java.util.NoSuchElementException;

public class LinkedListQueue implements QueueI {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty queue.
     */
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks whether this queue is empty.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Adds an element to the tail of this queue.
     *
     * @param newElement
     *            the element to add
     */
    @Override
    public void enqueue(Object newElement) {
        Node newNode = new Node();
        newNode.data = newElement;
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object element = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return element;
    }

    @Override
    public Object getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    class Node {
        public Object data;
        public Node next;
    }
}
