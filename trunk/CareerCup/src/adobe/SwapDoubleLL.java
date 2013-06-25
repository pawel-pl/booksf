package adobe;

import common.helper.Node;

public class SwapDoubleLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node head = new Node(1, true, new Node(2), new Node(3), new Node(4), new Node(5), new Node(6), new Node(7),
				new Node(8), new Node(9));
		Node head2 = new Node(1, true, new Node(2), new Node(3), new Node(4), new Node(5), new Node(6), new Node(7),
				new Node(8), new Node(9));
		Node.printList(head);
		Node.printList(pairWiseSwap(head));
		Node.printList(swapKElements(head2, 2));

	}

	public static Node swapKElements(Node head, int k) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		Node current = head;
		Node next = head.next;
		current.next = null;
		current.prev = null;
		int i = 0;
		while (next != null && i < k - 1) {
			Node temp = next.next;
			next.next = current;
			next.prev = current.prev;
			current.prev = next;
			current = next;
			next = temp;
			i++;
		}
		if (next != null) {
			head.next = swapKElements(next, k);
			if (head.next != null) {
				head.next.prev = head;
			}
		}

		return current;
	}

	public static Node pairWiseSwap(Node root) {

		if (root == null || root.next == null) {
			return root;
		}
		Node a = root;
		Node b = root.next;

		root = b; // after swap b will be the head of the list

		do {
			a.next = b.next;
			b.next = a;
			b.prev = a.prev;
			a.prev = b;

			// Example in list a,b,c,d after swapping nodes 'a' & 'b' pointers ,
			// 'c.prev' should be made point to 'a' now .. The list will be
			// b,a,c,d now . After swapping 'c' & 'd' , a.next should be set to
			// d . Now the list is b,a,d,c

			if (a.next != null) {
				a.next.prev = a;
			}

			if (b.prev != null) {
				b.prev.next = b;
			}
			a = a.next;
			b = (a != null) ? a.next : null;

		} while (a != null && b != null);
		return root;
	}
}
