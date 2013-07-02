package cisco;

import java.util.Stack;

import common.helper.BinaryTreeNode;

/*
 * http://www.youtube.com/watch?v=50v1sJkjxoc
 * http://www.youtube.com/watch?v=hv-mJUs5mvU
 */
public class BTIterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinaryTreeNode node1 = new BinaryTreeNode(null, null, 10);
		BinaryTreeNode node2 = new BinaryTreeNode(null, null, 11);
		BinaryTreeNode node3 = new BinaryTreeNode(null, null, 12);
		BinaryTreeNode node4 = new BinaryTreeNode(null, null, 13);
		BinaryTreeNode node5 = new BinaryTreeNode(null, null, 14);
		BinaryTreeNode node6 = new BinaryTreeNode(null, null, 15);
		BinaryTreeNode node7 = new BinaryTreeNode(null, null, 16);
		BinaryTreeNode node8 = new BinaryTreeNode(null, null, 17);

		BinaryTreeNode l2rightright = new BinaryTreeNode(node1, node2, 8);
		BinaryTreeNode l2rightleft = new BinaryTreeNode(node3, node4, 7);
		BinaryTreeNode l2leftright = new BinaryTreeNode(node5, node6, 6);
		BinaryTreeNode l2leftleft = new BinaryTreeNode(node7, node8, 5);

		BinaryTreeNode l1right = new BinaryTreeNode(l2rightleft, l2rightright, 4);
		BinaryTreeNode l1left = new BinaryTreeNode(l2leftleft, l2leftright, 3);

		BinaryTreeNode root = new BinaryTreeNode(l1left, l1right, 2);

		BinaryTreeNode.printTree(root);
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}

	public static void preOrder(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode node = stack.pop();
			System.out.print(node.value + " ");
			if (node.getRight() != null) {
				stack.add((BinaryTreeNode) node.getRight());
			}
			if (node.getLeft() != null) {
				stack.add((BinaryTreeNode) node.getLeft());
			}
		}
	}

	public static void inOrder(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.add(root);
		BinaryTreeNode node = (BinaryTreeNode) root.getLeft();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = (BinaryTreeNode) node.getLeft();
			} else {
				BinaryTreeNode top = stack.pop();
				System.out.print(top.value + " ");
				node = (BinaryTreeNode) top.getRight();
			}
		}
	}

	public static void postOrder(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> out = new Stack<BinaryTreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode node = stack.pop();
			out.push(node);
			if (node.getLeft() != null) {
				stack.add((BinaryTreeNode) node.getLeft());
			}
			if (node.getRight() != null) {
				stack.add((BinaryTreeNode) node.getRight());
			}
		}
		while (!out.isEmpty()) {
			System.out.print(out.pop().value + " ");
		}
	}
}
