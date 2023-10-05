package kannibaler;

public class CirkulærListe {
    private Node last;
    private Node start;
    private int size;

    public CirkulærListe() {
        last = null;
        size = 0;
    }

    public void addPerson(Person p) {
        Node newNode = new Node();
        newNode.data = p;

        if (size == 0) {
            last = newNode;
            last.next = last;
        }
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public Node randomStart() {
        if (size != 0) {
            start = last.next;
        int index = (int) (Math.random() * size);
        for (int i = 0; i < index; i++) {
            start = start.next;
        }
      }
        return start;
    }

    public Node remove(int count) {
        Node removed = null;
        if (size != 0) {
        Node element = start;
        for (int i = 0; i < count; i++) {
            element = element.next;
        }
        removed = element.next;
        element.next = removed.next;
        start = element.next;
        size--;
        }
        return removed;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public class Node {
        public Person data;
        public Node next;

    }


}
