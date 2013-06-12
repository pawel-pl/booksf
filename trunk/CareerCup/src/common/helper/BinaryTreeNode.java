package common.helper;

import java.util.ArrayList;

public class BinaryTreeNode extends TreeNode {

	public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int value) {

		if (children == null) {
			children = new ArrayList<TreeNode>();
		}
		if (right == null && left == null) {
			children.clear();
		}

		if (left != null) {
			children.set(0, left);
		}
		if (right != null) {
			children.set(1, right);
		}

		super.value = value;
	}

	public TreeNode getLeft() {

		if (children == null || children.isEmpty()) {
			return null;
		}

		return children.get(0);
	}

	public TreeNode getRight() {

		if (children == null || children.isEmpty() || children.size() == 1) {
			return null;
		}

		return children.get(1);

	}

	public void setLeft(TreeNode left) {

		children.set(0, left);
	}

	public void setRight(TreeNode right) {

		children.set(1, right);
	}
}
