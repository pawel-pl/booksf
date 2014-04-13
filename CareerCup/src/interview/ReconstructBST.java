package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBST {

    public static class Node {
	Node left;
	Node right;
	int value;

	public Node(int value) {
	    this.value = value;
	}
    }

    public static void main(String[] args) {

	// int[][] nodes = { { 2, 4 }, { 1, 2 }, { 3, 6 }, { 1, 3 }, { 2, 5 } };
	int[][] nodes = { { 4, 7 }, { 1, 2 }, { 2, 4 }, { 3, 6 }, { 1, 3 }, { 2, 5 } };
	Map<Integer, List<Integer>> treeMap = new HashMap<Integer, List<Integer>>();
	Map<Integer, Integer> childParentMap = new HashMap<Integer, Integer>();
	int rootCandidate = nodes[0][0];
	for (int i = 0; i < nodes.length; i++) {
	    List<Integer> children = null;
	    if (treeMap.containsKey(nodes[i][0])) {
		children = treeMap.get(nodes[i][0]);
	    } else {
		children = new ArrayList<Integer>();
		treeMap.put(nodes[i][0], children);
	    }
	    children.add(nodes[i][1]);
	    childParentMap.put(nodes[i][1], nodes[i][0]);
	}
	while(childParentMap.containsKey(rootCandidate)) {
	    rootCandidate = childParentMap.get(rootCandidate);
	}
	Node root = reconstructTree(treeMap, rootCandidate);
	System.out.println();
    }

    public static Node reconstructTree(Map<Integer, List<Integer>> treeMap, int v) {
	Node root = new Node(v);
	if (treeMap.get(v) == null || treeMap.get(v).isEmpty()) {
	    return root;
	}
	root.left = reconstructTree(treeMap, treeMap.get(v).get(0));
	if (treeMap.get(v).size() == 2) {
	    root.right = reconstructTree(treeMap, treeMap.get(v).get(1));
	}
	return root;
    }
}
