package linkedlist.opgave2sortedlinkedlist;

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

		if (first == null) {
			first = newNode;
		}
		else if (e.compareTo(first.data) < 0) {
			newNode.next = first;
			first = newNode;
		}
		else {
			Node temp = first;
			while (temp.next != null && e.compareTo(temp.next.data) > 0) {
				temp = temp.next;
			}
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
		// TODO
		Node temp = first;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return true;
	}
	
	/**
	 * Fjerner den første forekomst af e i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis e blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeElement(String e) {
		// TODO
		// Mangler at lave specialtilfælde i starten
		boolean b = false;
		if (first.data.equalsIgnoreCase(e)) {
			first = first.next;
		} else {
			Node temp = first;
			while (temp != null && !b) {
				if (temp.next.data.equalsIgnoreCase(e)) {
					if (temp.next.next != null) {
						temp.next = temp.next.next;
					} else {
						temp.next = null;
					}
					b = true;
				}
				temp = temp.next;
			}
		}
		return b;
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
	public SortedLinkedListIterator iterator() {
		return new SortedLinkedListIterator();
	}

	// Privat indre klasse der modellerer en node i listen
	public class Node {
		public String data;
		public Node next;

	}

	private class SortedLinkedListIterator implements java.util.Iterator {


		private final Node position;

		public SortedLinkedListIterator() {
			position = first;
		}

		@Override
		public boolean hasNext() {
			if (position.next == null) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Object next() {
			Node next = null;
			if (position.next != null) {
				next = position.next;
			}
			return next;
		}
	}

}
