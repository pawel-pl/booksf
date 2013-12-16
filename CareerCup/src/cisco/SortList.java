package cisco;

import common.helper.Node;

public class SortList {

    public static void main(String[] args) {

	Node head = new Node(3, new Node(2), new Node(1), new Node(6), new Node(5), new Node(4), new Node(7), new Node(
		9), new Node(8));
	Node head2 = new Node(9, new Node(8), new Node(7), new Node(6), new Node(5), new Node(4), new Node(3), new Node(
		2), new Node(1));
	Node head3 = new Node(100, new Node(4), new Node(4), new Node(4), new Node(3), new Node(3), new Node(3), new Node(
		3), new Node(3));
	sortList(head);
	sortList(head2);
	sortList(head3);
    }

    public static void sortList(Node head) {

	Node tail = head;
	while (tail.next != null) {
	    tail = tail.next;
	}
	Node n = head;
	Node prev = null;
	Node max = null;
	Node prevForMax = null;
	while (tail != head) {
	    max = tail;
	    n = head;
	    prevForMax = null;
	    prev = null;
	    while (n != tail) {
		if (n.d > max.d) {
		    max = n;
		    prevForMax = prev;
		}
		prev = n;
		n = n.next;
	    }
	    if (max != tail) {
		if (prevForMax != null) {
		    prevForMax.next = tail;
		}
		if (max == prev) {
		    max.next = tail.next;
		    tail.next = max;
		} else {
		    Node temp = tail.next;
		    tail.next = max.next;
		    prev.next = max;
		    max.next = temp;
		}
	    }
	    if (max == head) {
		head = tail;
	    }
	    if (max != prev) {
		tail = prev;
	    }
	}
	Node.printList(head);
    }
}
