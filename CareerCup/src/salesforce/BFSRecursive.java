package salesforce;

import java.util.LinkedList;
import java.util.Queue;

import common.helper.TreeNode;

public class BFSRecursive {

	public static void BFS(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		recursiveBFS(q);
	}

	public static void recursiveBFS(Queue<TreeNode> q) {
		if (q.isEmpty())
			return;
		TreeNode t = q.poll();
		System.out.println(t.value);
		for (TreeNode temp : t.children)
			// if not visited
			// temp.visited = VISITING
			q.add(temp);
		recursiveBFS(q);

		// visited
	}
}
