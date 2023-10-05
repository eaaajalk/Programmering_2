package queueopgaver;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListQueue implements QueueI {
    private ArrayList<Object> elements;
    private int head;
    private int tail;

    public ArrayListQueue() {
        elements = new ArrayList<>();
        head = 0;
        tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void enqueue(Object newElement) {
        elements.add(newElement);
        tail++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object removed = elements.get(head);
        elements.remove(head);
        tail--;
        return removed;
    }

    @Override
    public Object getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.get(head);
    }

    @Override
    public int size() {
        return elements.size();
    }
}
