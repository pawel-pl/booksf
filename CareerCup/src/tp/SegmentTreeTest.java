package tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegmentTreeTest {
	
	public static int[] tree;
	public static int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

	public static void main(String[] args) {

		int treeSize = (int) (2 * Math.pow(2, Math.ceil(Math.log(arr.length))) - 1);
		tree = new int[treeSize];
		build(0, 0, arr.length - 1);
		printTree(treeSize);
		// update(0, 0, arr.length - 1, 5, 9);
		System.out.println(query(0, 0, arr.length-1, 0, 1));
		update(0, 0, arr.length - 1, 0, 1, 6);
		printTree(treeSize);
		System.out.println(query(0, 0, arr.length-1, 1, 1));
		//printTree(treeSize);
	}

	public static void printTree(int treeSize) {

		System.out.println(Arrays.toString(tree));

		List<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
		arrList.add(new ArrayList<Integer>(Arrays.asList(0)));
		while (!arrList.isEmpty()) {
			List<Integer> currentLevel = arrList.remove(0);
			ArrayList<Integer> nextLevel = new ArrayList<Integer>();
			for (int i = 0; i < currentLevel.size(); i++) {
				System.out.print(tree[currentLevel.get(i)] + " ");
				if (2 * currentLevel.get(i) + 1 < treeSize) {
					nextLevel.add(2 * currentLevel.get(i) + 1);
				}
				if (2 * currentLevel.get(i) + 2 < treeSize) {
					nextLevel.add(2 * currentLevel.get(i) + 2);
				}
			}
			System.out.println();
			if (!nextLevel.isEmpty()) {
				arrList.add(nextLevel);
			}
		}
	}

	public static int query(int n, int b, int e, int qb, int qe) {

		if (b > e || b > qe || e < qb) {
			return 0;
		}

		if (b >= qb && e <= qe) {
			return tree[n];
		}

		return query(2 * n + 1, (b), (b + e) / 2, qb, qe) + query(2 * n + 2, ((b + e) / 2) + 1, e, qb, qe);
	}

	public static void update(int n, int b, int e, int idx, int val) {

		if (b > e || b > idx || e < idx)
			return;
		if (b == e) {
			tree[n] = val;
			return;
		}

		update(n * 2 + 1, b, (b + e) / 2, idx, val);
		update(n * 2 + 2, (b + e) / 2 + 1, e, idx, val);

		// now some change might have been made in either of the child nodes.

		tree[n] = tree[n * 2 + 1] + tree[n * 2 + 2];
	}

	public static void update(int n, int b, int e, int i, int j, int val) {

		if (b > e || b > j || e < i)
			return;

		// if the node's range completely lies inside the update range,
		// update at the node.
		if (i <= b && j >= e) {
			tree[n] += (e - b + 1) * val;
			return;
		}

		update(n * 2 + 1, b, (b + e) / 2, i, j, val);
		update(n * 2 + 2, (b + e) / 2 + 1, e, i, j, val);
		// now some change might have been made in either of the child nodes.

		tree[n] = tree[n * 2 + 1] + tree[n * 2 + 2]; // this line is different
	}

	public static void build(int n, int b, int e) {

		// System.out.println("Range: " + b + " -> " + e);
		if (b > e)
			return;
		else if (b == e) {
			tree[n] = arr[b];
			return;
		}

		build(n * 2 + 1, b, (b + e) / 2); // go to children...child nodes of
											// node n
											// are 2n and 2n+1.

		build(n * 2 + 2, (b + e) / 2 + 1, e);

		// now both child nodes 2n and 2n+1 are built (ie they have done their
		// responsibility of storing the correct information)
		tree[n] = tree[n * 2 + 1] + tree[n * 2 + 2];

	}

}
