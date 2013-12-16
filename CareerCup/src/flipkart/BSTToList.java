package flipkart;

import common.helper.BinaryTreeNode;

public class BSTToList {

    public static void main(String[] args) {

	BinaryTreeNode n2 = new BinaryTreeNode(null, null, 2);
	BinaryTreeNode n6 = new BinaryTreeNode(null, null, 6);
	BinaryTreeNode n5 = new BinaryTreeNode(n2, n6, 5);

	BinaryTreeNode n12 = new BinaryTreeNode(null, null, 12);
	BinaryTreeNode n14 = new BinaryTreeNode(null, null, 14);
	BinaryTreeNode n13 = new BinaryTreeNode(n12, n14, 13);

	BinaryTreeNode n20 = new BinaryTreeNode(null, null, 20);
	BinaryTreeNode n15 = new BinaryTreeNode(n13, n20, 15);

	BinaryTreeNode root = new BinaryTreeNode(n5, n15, 10);
	BinaryTreeNode head = treeToList(root);
	while (head != null) {
	    System.out.print(head.value + " ");
	    head = head.next;
	}
    }

    public static BinaryTreeNode treeToList(BinaryTreeNode root) {

	if (root == null) {
	    return null;
	}

	BinaryTreeNode right = treeToList(root.right);
	BinaryTreeNode left = treeToList(root.left);
	BinaryTreeNode listNode = new BinaryTreeNode(null, null, root.value);
	listNode.next = right;
	if (left != null) {
	    BinaryTreeNode n = left;
	    while (n.next != null) {
		n = n.next;
	    }
	    n.next = listNode;
	}
	return left != null ? left : listNode;
    }
}
