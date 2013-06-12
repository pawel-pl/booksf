package zynga;

import common.helper.Node;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node n = new Node(1, new Node(2), new Node(3), new Node(4), new Node(5));
		System.out.println(reverseIterative(n));
	}

	public static Node reverseIterative(Node head) {
		Node current = head;
		Node next = current.next;
		current.next = null;
		Node temp;
		while (next != null) {
			temp = next.next;
			next.next = current;
			current = next;
			next = temp;
		}
		return current;
	}

	public static Node reverseRecursive(Node head) {
		if (head.next == null)
			return head;
		Node oldNext = head.next;
		Node newHead = reverseRecursive(head.next);
		oldNext.next = head;
		head.next = null;
		return newHead;
	}

}
