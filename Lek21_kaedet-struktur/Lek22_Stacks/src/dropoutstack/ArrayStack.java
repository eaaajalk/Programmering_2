package dropoutstack;

import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
 */
public class ArrayStack implements StackI {
	private Object[] stack;
	private int top;

	/**
	 * Constructs an empty stack.
	 */
	public ArrayStack(int maxCapacity) {
		top = -1;
		stack = new Object[maxCapacity];
	}

	/**
	 * Adds an element to the top of the stack.
	 *
	 * @param element
	 *            the element to add
	 */
	@Override
	public void push(Object element) {
		if (checkFull()) {
			dropFirst();
		}
		top++;
		stack[top] = element;
	}

	private void dropFirst() {
		stack[0] = null;
		Object[] tempStack = new Object[top+1];
		for (int i = 0; i < top; i++) {
			tempStack[i] = stack[i + 1];
		}
		stack = tempStack;
		top--;
	}


	private boolean checkFull() {
		return size() == stack.length;
	}


	/**
	 * Removes the element from the top of the stack.
	 *
	 * @return the removed element
	 */
	@Override
	public Object pop() {
		if (top < 0) {
			throw new NoSuchElementException();
		}
		Object element = stack[top];
		stack[top] = null;
		top--;
		return element;
	}

	/**
	 * Returns the element from the top of the stack. The stack is unchanged
	 *
	 * @return the element from the top of the stack
	 */
	@Override
	public Object peek() {
		if (top < 0) {
			throw new NoSuchElementException();
		}
		return stack[top];
	}

	/**
	 * The number of elements on the stack.
	 *
	 * @return the number of elements on the stack
	 */
	@Override
	public int size() {
		return top + 1;
	}

	/**
	 * Checks whether this stack is empty.
	 *
	 * @return true if the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

}
