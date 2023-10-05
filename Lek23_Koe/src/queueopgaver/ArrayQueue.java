package queueopgaver;
import java.util.NoSuchElementException;
/**
 * An implementation of a queue as a array.
 */
public class ArrayQueue implements QueueI {
	private Object[] elements;
	private int head;
	private int tail;
	private int size;
	/**
	 * Constructs an empty queue.
	 */
	public ArrayQueue() {
		// TODO
		final int INITIAL_SIZE = 10;
		elements = new Object[INITIAL_SIZE];
		size = 0;
		head = 0;
		tail = 0;
	}
	/**
	 * Checks whether this queue is empty.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO
		return size() == 0;
	}
	/**
	 * Adds an element to the tail of this queue.
	 *
	 * @param newElement
	 *            the element to add
	 */
	@Override
	public void enqueue(Object newElement) {
		// TODO
		growIfNecessary();
		size++;
		elements[tail] = newElement;
		tail = (tail + 1) % elements.length;
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
	/**
	 * Removes an element from the head of this queue.
	 *
	 * @return the removed element
	 */
	@Override
	public Object dequeue() {
		// TODO
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		Object removed = elements[head];
		head = (head + 1) % elements.length;
		size--;
		return removed;
	}
	/**
	 * Returns the head of this queue. The queue is unchanged.
	 *
	 * @return the head element
	 */
	@Override
	public Object getFront() {
		// TODO
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return elements[head];
	}
	/**
	 * The number of elements on the queue.
	 *
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		// TODO
		return size;
	}
}
