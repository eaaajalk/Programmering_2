package dropoutstack;

import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
 */
public class NodeStack implements StackI {
	private Node top;
	private int maxCapacity;

	/**
	 * Constructs an empty stack.
	 */
	public NodeStack(int maxCapacity) {
		top = null;
		this.maxCapacity = maxCapacity;
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
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = top;
		top = newNode;
	}

	private void dropFirst() {
		if (top != null) {
			Node temp = top;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}

	}

	private boolean checkFull() {
		return size() == maxCapacity;
	}
	/**
	 * Removes the element from the top of the stack.
	 *
	 * @return the removed element
	 */
	@Override
	public Object pop() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		Object element = top.data;
		top = top.next;
		return element;
	}

	/**
	 * Returns the element from the top of the stack. The stack is unchanged
	 *
	 * @return the element from the top of the stack
	 */
	@Override
	public Object peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.data;
	}
	/**
	 * The number of elements on the stack.
	 *
	 * @return the number of elements on the stack
	 */
	@Override
	public int size() {
		int count = 0;
		Node temp = top;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/**
	 * Checks whether this stack is empty.
	 *
	 * @return true if the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	class Node {
		public Object data;
		public Node next;
	}

}
