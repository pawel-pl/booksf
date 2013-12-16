package microsoft;

import java.util.ArrayList;
import java.util.List;

public class FindSibling {

    static class Node {

	Node left;
	Node right;
	int value;

	public Node(Node left, Node right, int value) {

	    this.left = left;
	    this.right = right;
	    this.value = value;
	}

	public String toString() {
	    return String.valueOf(value);
	}
    }

    public static void main(String[] args) {

	// level 3 - leaves
	Node node1 = new Node(null, null, 10);
	Node node2 = new Node(null, null, 11);
	Node node3 = new Node(null, null, 12);
	Node node4 = new Node(null, null, 13);
	Node node5 = new Node(null, null, 14);
	Node node6 = new Node(null, null, 15);
	Node node7 = new Node(null, null, 16);
	Node node8 = new Node(null, null, 17);

	// level 2
	Node l2rightright = new Node(node7, node8, 8);
	Node l2rightleft = new Node(node5, node6, 7);
	Node l2leftright = new Node(node3, node4, 6);
	Node l2leftleft = new Node(node1, node2, 5);

	// level 1
	Node l1right = new Node(l2rightleft, l2rightright, 4);
	Node l1left = new Node(l2leftleft, l2leftright, 3);

	// level 0 - root
	Node root = new Node(l1left, l1right, 2);
	
	System.out.println(findSibling(root, node7));

    }

    private static Node findSibling(Node root, Node target) {

	// there is no siblings
	if (target == root) {
	    return null;
	}
	List<Node> currentLevel = new ArrayList<Node>();
	List<Node> nextLevel = new ArrayList<Node>();
	currentLevel.add(root);
	boolean foundTarget = false;
	int i = 0;
	while (i < currentLevel.size()) {
	    Node node = currentLevel.get(i);
	    i++;
	    if (node.left != null) {
		nextLevel.add(node.left);
	    }
	    if (node.right != null) {
		nextLevel.add(node.right);
	    }
	    if (target == node.left || target == node.right) {
		foundTarget = true;
	    }
	    if (i == currentLevel.size()) {
		// don't go to next level 
		if (foundTarget) {
		    break;
		} else {
		    currentLevel.clear();
		    currentLevel.addAll(nextLevel);
		    nextLevel.clear();
		    i = 0;
		}
	    }
	}

	if (foundTarget) {
	    // there is no siblings
	    if (nextLevel.size() == 1) {
		return null;
	    }
	    for (i = 0; i < nextLevel.size(); i++) {
		if (nextLevel.get(i) == target) {
		    return i == 0 ? nextLevel.get(i + 1) : nextLevel.get(i - 1);
		}
	    }
	}

	return null;
    }

}
