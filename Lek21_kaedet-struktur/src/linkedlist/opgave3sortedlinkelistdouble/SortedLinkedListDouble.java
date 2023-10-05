package linkedlist.opgave3sortedlinkelistdouble;

import linkedlist.opgave2sortedlinkedlist.SortedLinkedList;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class SortedLinkedListDouble {

	// first og last er tomme sentinels.

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
		// hvis listen er tom
		if (first.next == last) {
			newNode.prev = first;
			newNode.next = last;
			first.next = newNode;
			last.prev = newNode;
			//Hvis det nye element er mindre end det første.
		} else if (e.compareTo(first.next.data) < 0) {
			newNode.next = first.next;
			newNode.prev = first;
			first.next.prev = newNode;
			first.next = newNode;
		} else {
			Node temp = first.next;
			while (temp.next != last && e.compareTo(temp.next.data) > 0) {
				temp = temp.next;
			}
			//newNode indsættes efter temp.
				newNode.next = temp.next;
				newNode.prev = temp;
				temp.next.prev = newNode;
				temp.next = newNode;
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
		boolean removed = false;

		if (first.next == last) {
			throw new NoSuchElementException();
		}

		Node temp = first.next;
		while (temp != last && !removed) {
			if (temp.data.equalsIgnoreCase(e)) {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				removed = true;
				size--;
			}
			temp = temp.next;
		}

		return removed;
	}


	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge 
	 */
	public void udskrivElements() {
		//TODO
		if (first.next == last) {
			return; // Listen er tom, der er intet at udskrive
		}

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
		if (first.next == last) {
			return; // Listen er tom, der er intet at udskrive
		}

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
