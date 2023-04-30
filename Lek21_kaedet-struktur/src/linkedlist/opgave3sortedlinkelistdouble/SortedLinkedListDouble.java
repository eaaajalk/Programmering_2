package linkedlist.opgave3sortedlinkelistdouble;

import linkedlist.opgave2sortedlinkedlist.SortedLinkedList;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class SortedLinkedListDouble {

	private Node first;
	private Node last;
	private int size;

	public SortedLinkedListDouble() {
		first = new Node();
		last = new Node();
		first.next = last;
		last.prev = first;
		size = 0;
	}

	/**
	 * Tilføjer e til listen, så listen fortsat er sorteret i henhold til den
	 * naturlige ordning på elementerne
	 */
	public void addElement(String e) {
		// TODO
		Node newNode = new Node();
		newNode.data = e;

		if (first.next == last) {
			newNode.prev = first;
			newNode.next = last;
			first.next = newNode;
			last.prev = newNode;
		} else if (e.compareTo(first.next.data) < 0) {
			newNode.next = first.next;
			newNode.prev = first;
			first.next.prev = newNode;
			first.next = newNode;
		} else {
			Node temp = first.next;
			while (temp.next != last && e.compareTo(temp.data) > 0) {
				temp = temp.next;
			}
				newNode.next = temp;
				newNode.prev = temp.prev;
				temp.prev.next = newNode;
				temp.prev = newNode;
		}
		size++;
	}


	/**
	 * Fjerner den første forekomst af e i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis e blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeElement(String e) {
	// TODO
		boolean b = false;
		if (first.next == last) {
			throw new NoSuchElementException();
		}
		Node temp = first;
		while (temp.next != last || !b) {
			if (temp.next.data.equalsIgnoreCase(e)) {
				temp.next = temp.next.next;
				temp.next.prev = temp;
				b = true;
				size--;
			}
			temp = temp.next;
		}
		return b;
	}

	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge 
	 */
	public void udskrivElements() {
		//TODO
		Node temp = first.next;
		while (temp != last) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge bagfra
	 */
	public void udskrivBagfra() {
		// TODO
		Node temp = last.prev;
		while (temp != first) {
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}

	/**
	 * Returnerer antallet af elementer i listen
	 */
	public int countElements() {
		return size;
	}

	// Privat indre klasse der modellerer en node i en dobbeltkædet liste
	class Node {
		public String data;
		public Node next;
		public Node prev;
	}
}
