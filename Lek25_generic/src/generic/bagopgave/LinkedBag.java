package generic.bagopgave;

public class LinkedBag<T> implements Bag<T> {

    private Node first;
    private final int INITIAL_SIZE = 20;
    private int entries;

    public LinkedBag() {
        first = null;
        entries = 0;
    }

    @Override
    public int getCurrentSize() {
        return entries;
    }

    @Override
    public boolean isFull() {
        return entries == INITIAL_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return entries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node();
        newNode.data = newEntry;
        newNode.next = first;
        first = newNode;
        entries++;
        return true;
    }

    @Override
    public T remove() {
        T deleted = null;
        if (!isEmpty()) {
            if (entries == 1) {
                deleted = (T) first.data;
                first = null;
                entries--;
            } else {
                deleted = (T) first.data;
                first = first.next;
                entries--;
            }
        }
        return deleted;
    }

    @Override
    public boolean remove(T anEntry) {
        // finder ikke den første, hvis det er tilfældet.
        Node temp = first;
        while(temp.next != null) {
            if (temp.next.data == anEntry) {
                temp.next = temp.next.next;
                entries--;
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        entries = 0;
        first = null;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        Node temp = first;
        while(temp != null) {
            if (temp.data == anEntry) {
                counter++;
            }
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        Node temp = first;
        while(temp != null) {
            if (temp.data == anEntry) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        Node temp = first;
        T[] array = (T[]) new Object[getCurrentSize()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (T) temp.data;
            temp = temp.next;

        }
        return array;
    }

    class Node {
        public Object data;
        public Node next;
    }
}
