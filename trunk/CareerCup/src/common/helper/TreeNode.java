package common.helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

	public int value;
	public List<TreeNode> children;

	public TreeNode() {

		children = new ArrayList<TreeNode>();
		children.add(0, null);
		children.add(1, null);
	}

	public TreeNode(int value, List<TreeNode> children) {

		this.value = value;
		this.children = children;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String toString() {

		return String.valueOf(value);
	}

	public static void printTree(TreeNode root) {

		if (root == null) {
			return;
		}

		LinkedList<ArrayList<TreeNode>> list = new LinkedList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> rootLevel = new ArrayList<TreeNode>();
		rootLevel.add(root);
		list.add(rootLevel);
		for (int i = 0; i < list.size(); i++) {
			ArrayList<TreeNode> currentlevel = list.get(i);
			System.out.println(currentlevel);
			ArrayList<TreeNode> newlevel = new ArrayList<TreeNode>();
			for (TreeNode node : currentlevel) {
				if (node.children != null && !node.children.isEmpty()) {
					for (TreeNode ch : node.children) {
						if (ch != null) {
							newlevel.add(ch);
						}
					}
				}
			}
			if (!newlevel.isEmpty()) {
				list.add(newlevel);
			}
		}
	}
}
