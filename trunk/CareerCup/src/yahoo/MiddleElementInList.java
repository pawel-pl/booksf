package yahoo;

import common.helper.Node;

public class MiddleElementInList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node last = new Node(9);
		Node fourth = new Node(4);
		Node head = new Node(1, new Node(2), new Node(3), fourth, new Node(5), new Node(6), new Node(7), new Node(8),
				last);

		//last.next = head;
		 last.next = fourth;

		//findMiddleEl(n);
		findMiddleElCircular(head);
		findMiddleElCircular2(head);
	}

	public static void findMiddleEl(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		System.out.println(slow);
	}

	public static void findMiddleElCircular(Node head) {

		Node slow = head;
		Node fast = head;
		boolean firstMeet = false;
		int loopLength = 0;
		int lengthBeforeLoop = 0;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (firstMeet == true) {
				loopLength++;
			}
			if (slow.equals(fast)) {
				if (firstMeet == false) {
					firstMeet = true;
				} else {
					break;
				}

			}
		}
		slow = head;
		while (!slow.equals(fast)) {
			slow = slow.next;
			fast = fast.next;
			lengthBeforeLoop++;
		}
		slow = head;
		for (int i = 0; i < (loopLength + lengthBeforeLoop) / 2; i++) {
			slow = slow.next;
		}
		System.out.println(slow);
		System.out.println(lengthBeforeLoop);
		System.out.println(loopLength);

	}

	public static void findMiddleElCircular2(Node head) {

		Node slow = head;
		Node fast = head;
		int listLength = 0;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			listLength++;
			if (slow.equals(fast)) {
				break;
			}
		}
		slow = head;
		while (!slow.equals(fast)) {
			slow = slow.next;
			fast = fast.next;
			listLength++;
		}
		slow = head;
		for (int i = 0; i < listLength / 2; i++) {
			slow = slow.next;
		}
		System.out.println(slow);
		System.out.println(listLength);

	}
}
