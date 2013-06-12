package yahoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.helper.BinaryTreeNode;
import common.helper.TreeNode;

public class PrintPathFromRoot {

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
		printPathsBinRec(root, new ArrayList<TreeNode>());
		System.out.println();
		printPathsRec(root, new ArrayList<TreeNode>());
		System.out.println();
		printPathsIter(root, new ArrayList<TreeNode>());

	}

	public static void printPathsBinRec(BinaryTreeNode root, List<TreeNode> path) {

		if (root == null) {
			return;
		}
		path.add(root);

		BinaryTreeNode left = (BinaryTreeNode) root.getLeft();
		BinaryTreeNode right = (BinaryTreeNode) root.getRight();

		if (left != null || right != null) {
			printPathsBinRec(left, path);
			printPathsBinRec(right, path);
		} else {
			System.out.println(path);
		}
		path.remove(root);
	}

	public static void printPathsRec(TreeNode root, List<TreeNode> path) {

		if (root == null) {
			return;
		}
		path.add(root);

		List<TreeNode> list = root.getChildren();

		if (list != null && !list.isEmpty()) {
			for (TreeNode n : list) {
				printPathsRec(n, path);
			}
		} else {
			System.out.println(path);
		}
		path.remove(root);
	}

	public static void printPathsIter(TreeNode root, List<TreeNode> path) {

		if (root == null) {
			return;
		}

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode n = stack.getFirst();
			if (path.contains(n)) {
				path.remove(n);
				stack.removeFirst();
				continue;
			}
			path.add(n);
			List<TreeNode> list = n.getChildren();
			if (list != null && !list.isEmpty()) {
				for (TreeNode ch : list) {
					stack.addFirst(ch);
				}
			} else {
				System.out.println(path);
			}
		}
	}
}
