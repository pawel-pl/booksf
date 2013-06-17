package nationalinstruments;

import common.helper.Node;

/*
 * at any point if A.data>=B.data then the resultant link list will have a node of value 
 * A.data-Ba.data 
 * else if B.data is greater, resultant will have a node of value 10+A.data-B.data. and the value
 * of previous node in the resultant link list will be decremented by 1. ( will need to maintain a previous pointer) 
 */
public class LinkedListSubtract {

	public static void main(String[] args) {

		//Node n1 = new Node(5, new Node(4), new Node(2), new Node(0), new Node(0), new Node(9), new Node(0), new Node(0));
		//Node n2 = new Node(1, new Node(9), new Node(9));
		Node n1 = new Node(1, new Node(0), new Node(0), new Node(0), new Node(0), new Node(0), new Node(0), new Node(0));
		Node n2 = new Node(1);
		Node headN1 = n1;
		Node headN2 = n2;
		int lengthN1 = 0;
		int lengthN2 = 0;
		while (n1 != null) {
			lengthN1++;
			n1 = n1.next;
		}
		while (n2 != null) {
			lengthN2++;
			n2 = n2.next;
		}
		while (lengthN2 < lengthN1) {
			Node n = new Node(0);
			n.next = headN2;
			headN2 = n;
			lengthN2++;
		}
		Node.printList(headN1);
		Node.printList(headN2);
		Node result = new Node(headN1.d - headN2.d);
		Node prev = result;
		headN1 = headN1.next;
		headN2 = headN2.next;
		Node latestBiggerThenZero = result;
		int remainder = 0;
		while (headN1 != null) {
			Node n = new Node();
			prev.next = n;
			if (headN2.d > headN1.d) {
				latestBiggerThenZero.d = latestBiggerThenZero.d - 1;
				while (latestBiggerThenZero.next != n) {
					latestBiggerThenZero.next.d = 9;
					latestBiggerThenZero = latestBiggerThenZero.next;
				}
				remainder = 10;
			}
			n.d = headN1.d - headN2.d + remainder;
			remainder = 0;
			headN1 = headN1.next;
			headN2 = headN2.next;
			if (n.d > 0) {
				latestBiggerThenZero = n;
			}
			prev = n;
		}
		Node.printList(result);
	}
}
