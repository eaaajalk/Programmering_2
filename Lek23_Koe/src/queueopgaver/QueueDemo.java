package queueopgaver;
public class QueueDemo {
	public static void main(String[] args) {
		QueueI q = new ArrayQueue();

		q.enqueue("Tom");
		q.enqueue("Diana");
		q.enqueue("Harry");
		q.enqueue("Thomas");
		q.enqueue("Bob");
		q.enqueue("Brian");
		System.out.println("front: " + q.getFront());
		System.out.println(q.isEmpty() + " " + q.size());
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		System.out.println();
		System.out.println(q.isEmpty() + " " + q.size());
		System.out.println();
		q.enqueue("Anna");
		q.enqueue("Lotte");
		System.out.println(q.isEmpty() + " " + q.size());
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		System.out.println();
		System.out.println(q.isEmpty() + " " + q.size());


		// Tester linkedListQueue
		System.out.println();
		System.out.println("LinkedListQueue:");
		QueueI ql = new LinkedListQueue();
		ql.enqueue("Tom");
		ql.enqueue("Diana");
		ql.enqueue("Harry");
		ql.enqueue("Thomas");
		ql.enqueue("Bob");
		ql.enqueue("Brian");
		System.out.println("front: " + ql.getFront());
		System.out.println(ql.isEmpty() + " " + ql.size());
		while (!ql.isEmpty()) {
			System.out.println(ql.dequeue());
		}
		System.out.println();
		System.out.println(ql.isEmpty() + " " + ql.size());
		System.out.println();
		ql.enqueue("Anna");
		ql.enqueue("Lotte");
		System.out.println(ql.isEmpty() + " " + ql.size());
		while (!ql.isEmpty()) {
			System.out.println(ql.dequeue());
		}
		System.out.println();
		System.out.println(ql.isEmpty() + " " + ql.size());
	}
}
