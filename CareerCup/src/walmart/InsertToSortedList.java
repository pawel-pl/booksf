package walmart;

import common.helper.Node;

public class InsertToSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node n = new Node(1, new Node(2), new Node(4), new Node(5));
		Node smallest = insertEl(n, new Node(3));
		System.out.println(smallest);
		Node.printList(smallest);
		
		smallest = insertEl(n, new Node(0));
		System.out.println(smallest);
		Node.printList(smallest);
	}
	
	public static Node insertEl(Node head, Node ins) {
		
		if(head == null) {
			return null;
		}
		
		if(head.d > ins.d) {	
			ins.next = head;
			return ins;
		}
		
		Node parent = head;
		Node n = head.next;
		
		while(n != null && n.d <= ins.d) {
			parent = n;
			n = n.next;
		}
		
		parent.next = ins;
		ins.next = n;
		
		return head;
	}

}
