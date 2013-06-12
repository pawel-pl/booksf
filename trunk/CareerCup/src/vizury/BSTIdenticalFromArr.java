package vizury;

import common.helper.BinaryTreeNode;

/*
 * http://stackoverflow.com/questions/9817214/bst-from-two-unsorted-array
 * http://stackoverflow.com/questions/1482822/determine-if-two-binary-trees-are-equal
 */
public class BSTIdenticalFromArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//int[] arr1 = {10, 5, 20, 15, 30};
		//int[] arr2 = {10, 20, 15, 30, 5};
		//int[] arr2 = {10, 15, 20, 30, 5};
		
		int[] arr1 = {2, 1, 4, 0, 3, 7};
		int[] arr2 = {2, 4, 1, 0, 7, 3};
		
		BinaryTreeNode root1 = createBST(arr1);
		BinaryTreeNode root2 = createBST(arr2);
		
		System.out.println(compareBSTs(root1, root2));
	}

	public static BinaryTreeNode createBST(int[] arr) {

		BinaryTreeNode root = new BinaryTreeNode(null, null, arr[0]);

		for (int i = 1; i < arr.length; i++) {
			insertNode(root, arr[i]);
		}

		return root;
	}

	public static void insertNode(BinaryTreeNode root, int el) {

		BinaryTreeNode parent = null;
		BinaryTreeNode n = root;

		while (n != null) {
			parent = n;
			if (el > n.value) {
				n = (BinaryTreeNode) n.getRight();
			} else {
				n = (BinaryTreeNode) n.getLeft();
			}
		}

		BinaryTreeNode newNode = new BinaryTreeNode(null, null, el);
		if (el > parent.value) {
			parent.setRight(newNode);
		} else {
			parent.setLeft(newNode);
		}
	}

	public static boolean compareBSTs(BinaryTreeNode root1, BinaryTreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.value != root2.value) {
			return false;
		}

		return compareBSTs((BinaryTreeNode) root1.getLeft(), (BinaryTreeNode) root2.getLeft())
				&& compareBSTs((BinaryTreeNode) root1.getRight(), (BinaryTreeNode) root2.getRight());
	}

}
