package dropoutstack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack implements StackI {

    private ArrayList<Object> stack;
    private int maxCapacity;

    public ArrayListStack(int maxCapacity) {
        stack = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void push(Object element) {
        if (checkFull()) {
            dropFirst();
        }
        stack.add(element);
    }

    private void dropFirst() {
        if (!stack.isEmpty()) {
          stack.remove(0);
        }
    }

    private boolean checkFull() {
        return size() == maxCapacity;
    }

    @Override
    public Object pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        Object element = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return element;

    }

    @Override
    public Object peek() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.get(stack.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
