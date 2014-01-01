package interview;

class Node {
    public int value;
    public Node next;

    public Node() {
	value = 0;
	next = null;
    }

    public Node(int value, Node next) {
	this.value = value;
	this.next = next;
    }
}

public class MergeListProblem {

    public static Node mergeLists(Node head1, Node head2) {

	Node newHead = new Node();
	if (head1.value <= head2.value) {
	    newHead.value = head1.value;
	    head1 = head1.next;
	} else {
	    newHead.value = head2.value;
	    head2 = head2.next;
	}
	Node prev = newHead;
	while (head1 != null && head2 != null) {
	    Node n = new Node();
	    if (head1.value <= head2.value) {
		n.value = head1.value;
		head1 = head1.next;
	    } else {
		n.value = head2.value;
		head2 = head2.next;
	    }
	    prev.next = n;
	    prev = n;
	}
	while (head1 != null) {
	    Node n = new Node();
	    n.value = head1.value;
	    head1 = head1.next;
	    prev.next = n;
	    prev = n;
	}
	while (head2 != null) {
	    Node n = new Node();
	    n.value = head2.value;
	    head2 = head2.next;
	    prev.next = n;
	    prev = n;
	}
	
	return newHead;
    }
}
