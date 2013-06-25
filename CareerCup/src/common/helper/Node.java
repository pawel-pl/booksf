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
	
	public static Node createArbitList() {
	    
	    Node n1 = new Node(1);
	    Node n2 = new Node(2);
	    Node n3 = new Node(3);
	    Node n4 = new Node(4);
	    Node n5 = new Node(5);
	    n1.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
	    
	    n1.prev = n3;
	    n3.prev = n5;
	    n2.prev = n1;
	    n5.prev = n2;
	    n4.prev = n3;
	    
	    
	    return n1;
	}
}
