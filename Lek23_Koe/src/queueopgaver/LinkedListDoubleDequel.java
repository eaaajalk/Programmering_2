package queueopgaver;

import java.util.NoSuchElementException;

public class LinkedListDoubleDequel implements DequeI {

    // tomt lsitehoved og fod

    private Node head;
    private Node tail;
    private int size;

    public LinkedListDoubleDequel() {
        head = new Node();
        tail = new Node();
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void addFirst(Object newElement) {
        Node newNode = new Node();
        newNode.data = newElement;
        if (isEmpty()) {
            newNode.next = tail;
            newNode.prev = head;
            head.next = newNode;
            tail.prev = newNode;
        } else {
            newNode.next = head.next;
            newNode.prev = head;

            head.next.prev = newNode;
            head.next = newNode;

        }
        size++;
    }

    @Override
    public void addLast(Object newElement) {
        Node newNode = new Node();
        newNode.data = newElement;
        if (isEmpty()) {
            newNode.next = tail;
            newNode.prev = head;
            head.next = newNode;
            tail.prev = newNode;
        } else {
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;

        }
        size++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object element = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return element;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object element = tail.prev.data;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
        return element;
    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next;
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.prev;
    }

    @Override
    public int size() {
        return size;
    }

    class Node {
        public Object data;
        public Node next;
        public Node prev;
    }
}
