package dictionaryelev;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryLinked() {
		// Sentinel (tomt listehoved - der ikke indeholder data)
		start = new Node();
		size = 0;
	}

	@Override
	public V get(K key) {
		// TODO
		Node temp = start;
		while(temp.next != null) {
			if (temp.next.key.equals(key)) {
				return temp.next.value;
			} else {
				temp = temp.next;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		// TODO
		V v = null;
		boolean found = false;
		Node temp = start;
		while(temp.next != null && !found) {
			if (temp.next.key.equals(key)) {
				v = temp.next.value;
				temp.next.value = value;
				found = true;
			} else {
				temp = temp.next;
			}
		}
		if (!found) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			temp.next = newNode;
			size++;
		}
		return v;
	}

	@Override
	public V remove(K key) {
		// TODO
		V v = null;
		Node temp = start;
		while(temp.next != null) {
			if (temp.next.key.equals(key)) {
				v = temp.next.value;
				temp.next = temp.next.next;
				size--;
			} else {
				temp = temp.next;
			}
		}
		return v;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node {
		Node next;
		K key;
		V value;
	}

}
