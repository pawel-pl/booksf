package akamai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.helper.Node;

/*
 * http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 */
public class CreateCopyOfLLWithArbitPtr {

    /**
     * @param args
     */
    public static void main(String[] args) {

	Node n = Node.createArbitList();
	Node head = n;
	printListForward(head);
	printListArbitrary(head);
	
	Node newHead = null;
	Map<Node, Node> map = new HashMap<Node, Node>();
	Node newPrev = null;
	while (n != null) {
	    map.put(n, n.next);
	    Node newNode = new Node(n.d);
	    if (newHead == null) {
		newHead = newNode;
	    }
	    n.next = newNode;
	    newNode.prev = n;
	    if (newPrev != null) {
		newPrev.next = newNode;
	    }
	    newPrev = newNode;
	    n = map.get(n);
	}
	for (Node oldNode : map.keySet()) {
	    oldNode.next.prev = oldNode.prev.next;
	}
	for (Node oldNode : map.keySet()) {
	    oldNode.next = map.get(oldNode);
	}

	printListForward(head);
	printListArbitrary(head);

	printListForward(newHead);
	printListArbitrary(newHead);
    }

    public static void printListForward(Node head) {

	List<Integer> l = new ArrayList<Integer>();
	while (head != null) {
	    l.add(head.d);
	    head = head.next;
	}

	System.out.println(l);
    }

    public static void printListArbitrary(Node head) {

	List<Integer> l = new ArrayList<Integer>();
	while (head != null) {
	    l.add(head.prev != null ? head.prev.d : null);
	    head = head.next;
	}

	System.out.println(l);
    }

}
