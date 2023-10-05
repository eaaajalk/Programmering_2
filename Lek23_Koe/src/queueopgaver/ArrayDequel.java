package queueopgaver;

import java.util.NoSuchElementException;

public class ArrayDequel implements DequeI {
    private Object[] elements;
    private int size;
    private int head;
    private int tail;
    public ArrayDequel() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object newElement) {
        size++;
        elements[head] = newElement;
        head = (head + 1) % elements.length;
    }

    @Override
    public void addLast(Object newElement) {
        growIfNecessary();
        size++;
        elements[tail] = newElement;
        tail = (tail + 1) % elements.length;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object removed = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return removed;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object removed = elements[tail];
        tail = (tail - 1 + elements.length) % elements.length;
        size--;
        return removed;
    }


    @Override
    public Object getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return elements[head];
    }

    @Override
    public Object getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return elements[tail];
    }
    private void growIfNecessary() {
        if (size == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = size;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
