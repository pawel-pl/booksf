package synopsys;

import common.helper.Node;

public class ListNthFromLastRecursion {

    /**
     * @param args
     */
    private static int count = 0;

    public static void main(String[] args) {

	Node n = new Node(1, new Node(2), new Node(3), new Node(4), new Node(5), new Node(6), new Node(7), new Node(8));
	System.out.println(findNth(n, 3));
    }

    private static Node findNth(Node head, int n) {

	if (head == null) {
	    return null;
	}

	Node node = findNth(head.next, n);
	count++;
	if (count == n) {
	    node = head;
	}
	return node;
    }
}
