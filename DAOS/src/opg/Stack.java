package opg;

public class Stack {
    private class Element {
        int info;
        Element next;
        Element(int n, Element e) {
            info = n;
            next = e;
        }
    }
    private Element first;
    public Stack() {
        first = null;
    }
    public synchronized void push(int n) {
        first = new Element(n, first);
        if (first.next == null) {
            notify();
        }
    }
    public synchronized int pop() throws InterruptedException {
        if (first == null) {
            System.out.println("Stacken er tom");
            wait();
        }
        int n = first.info;
        first = first.next;
        return n;
    }
    public boolean is_empty() {
        return first == null;
    }

}
