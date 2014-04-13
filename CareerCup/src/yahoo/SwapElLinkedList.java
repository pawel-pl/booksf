package yahoo;

import common.helper.Node;

public class SwapElLinkedList {

    public static void main(String[] args) {

        Node head1 = new Node(1, new Node(2), new Node(3), new Node(4), new Node(5), new Node(6), new Node(7),
                new Node(8));
        Node head2 = new Node(1, new Node(2), new Node(3), new Node(4), new Node(5), new Node(6), new Node(7),
                new Node(8));
        Node.printList(swapElRec(head1, 3));
        Node.printList(swapElIter(head2, 3));
    }

    public static Node swapElRec(Node head, int k) {

        if (head == null) {
            return null;
        }

        Node current = head;
        Node next = head.next;
        head.next = null;

        int i = 0;
        while (next != null && i < k - 1) {
            Node temp = next.next;
            next.next = current;
            current = next;
            next = temp;

            i++;
        }

        if (next != null) {
            head.next = swapElRec(next, k);
        }

        return current;
    }

    public static Node swapElIter(Node head, int k) {

        boolean firstSwap = true;
        Node newHead = null;
        Node endOfPrevSwap = head;
        while (head != null) {
            Node current = head;
            Node next = current.next;
            current.next = null;
            int i = 0;
            while (next != null && i < k - 1) {
                Node temp = next.next;
                next.next = current;
                current = next;
                next = temp;

                i++;
            }
            if (firstSwap) {
                newHead = current;
                firstSwap = false;
            } else {
                endOfPrevSwap.next = current;
                endOfPrevSwap = head;
            }
            head = next;
        }

        return newHead;
    }

}
