package linkedlist.opgave2sortedlinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedList {

	// TODO hvilke feltvariable skal klassen have
	private Node first;

	public SortedLinkedList() {
		// TODO
		first = null;
	}

	/**
	 * Tilføjer e til listen, så listen fortsat er sorteret i henhold til den
	 * naturlige ordning på elementerne
	 */
	public void addElement(String e) {
		Node newNode = new Node();
		newNode.data = e;

		//hvis listen er tom:
		if (first == null) {
			first = newNode;
			//hvis det nye element er mindre end det første element:
		} else if (e.compareTo(first.data) < 0) {
			newNode.next = first;
			first = newNode;
			//ellers:
		} else {
			Node temp = first;
			while (temp.next != null && e.compareTo(temp.next.data) > 0) {
				temp = temp.next;
			}
			//newNode indsættes efter temp
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}


	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge
	 */
	public void udskrivElements() {
		// TODO
		Node temp = first;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Returnerer antallet af elementer i listen
	 */
	public int countElements() {
		// TODO
		int count = 0;
		Node temp = first;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}


	/**
	 * Fjerner det sidste (altså det største) element i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis der blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeLast() {
		if (first == null) {
			return false; // Listen er tom, kan ikke fjerne noget
		}
		// Hvis listen kun har ét element
		if (first.next == null) {
			first = null;
			return true; // Elementet blev fjernet
		}

		Node temp = first;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return true; // Elementet blev fjernet
	}


	/**
	 * Fjerner den første forekomst af e i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis e blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeElement(String e) {
		boolean removed = false;

		// Håndtering af specialtilfælde, hvis listen er tom
		if (first == null) {
			return false; // Elementet kan ikke fjernes fra en tom liste
		}

		// Håndtering af specialtilfælde, hvis det første element matcher
		if (first.data.equalsIgnoreCase(e)) {
			first = first.next;
			return true; // Elementet blev fjernet
		}

		Node current = first;
		while (current.next != null && !removed) {
			if (current.next.data.equalsIgnoreCase(e)) {
				if (current.next.next != null) {
					current.next = current.next.next;
				} else {
					current.next = null;
				}
				removed = true; // Elementet blev fjernet
			}
			current = current.next;
		}

		return removed; // Returnerer true, hvis elementet blev fjernet; ellers false
	}


	/**
	 * Tilføjer alle elementerne fra list til den aktuelle liste.
	 * Listen er fortsat sorteret i henhold til den naturlige ordning på
	 * elementerne.
	 */
	public void addAll(SortedLinkedList list) {
		// TODO: lav mig
		Node temp = list.first;
		while (temp != null) {
			addElement(temp.data);
			temp = temp.next;
		}
	}

	public int countElements2() {
		if (first == null) {
			return 0;
		}
		return counter(first);
	}

	public int counter(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + counter(node.next);
	}

	public Iterator<Node> iterator() {
		return new SortedLinkedListIterator();
	}

	// Privat indre klasse der modellerer en node i listen
	public class Node {
		public String data;
		public Node next;
	}

	private class SortedLinkedListIterator implements java.util.Iterator<Node> {
		private Node position;
		public SortedLinkedListIterator() {
			position = first;
		}
		@Override
		public boolean hasNext() {
			return position != null;
		}
		@Override
		public Node next() {
			if (!hasNext()) {
				throw new NoSuchElementException(); // Kaster NoSuchElementException, hvis der ikke er flere elementer
			}
			Node next = position;
			position = position.next;
			return next;
		}
	}
}
