package queueopgaver;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListDequel implements DequeI {
    private ArrayList<Object> elements;

    public ArrayListDequel() {
        elements = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void addFirst(Object newElement) {
        elements.add(0, newElement);
    }

    @Override
    public void addLast(Object newElement) {
        elements.add(newElement);
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.remove(0);
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.get(0);
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public int size() {
        return elements.size();
    }
}
