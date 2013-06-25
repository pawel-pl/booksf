package common.helper;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public Node next;
	public Node prev;
	public int d;

	public Node() {

	}

	public Node(int d) {
		this.d = d;
	}

	public Node(int d, Node... node) {

		this.d = d;
		Node current = this;
		for (Node n : node) {
			current.next = n;
			current = n;
		}
	}

	public Node(int d, boolean dll, Node... node) {

		this(d, node);
		Node prev = this;
		Node n = this.next;
		while (n != null) {
			n.prev = prev;
			prev = n;
			n = n.next;
		}
	}

	@Override
	public boolean equals(Object obj) {

		return this.d == ((Node) obj).d;
	}

	public String toString() {

		return String.valueOf(d);
	}

	public static void printList(Node head) {

		List<Integer> l = new ArrayList<Integer>();
		while (head != null) {
			l.add(head.d);
			head = head.next;
		}

		System.out.println(l);
	}
}
