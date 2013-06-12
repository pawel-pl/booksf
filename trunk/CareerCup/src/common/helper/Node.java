package common.helper;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public Node next;
	public int d;

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

	
	@Override
	public boolean equals(Object obj) {
	
		return this.d == ((Node) obj).d;
	}

	public String toString() {

		return String.valueOf(d);
	}
	
	public static void printList(Node head) {
		
		List<Integer> l = new ArrayList<Integer>();
		while(head != null){
			l.add(head.d);
			head = head.next;
		}
		
		System.out.println(l);
	}
}
