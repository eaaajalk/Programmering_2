package stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack implements StackI {

    private ArrayList<Object> stack;



    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(Object element) {
        stack.add(element);
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
