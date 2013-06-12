package tp;

public class SegmentTreeTest2 {

	private static class Node {

		public int value;
		public int changes;
		public Node left;
		public Node right;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		Node root = build(arr, 0, arr.length - 1, false);
		System.out.println(querySum(root, 0, arr.length - 1, 4, 7, 0));
		updateSum(root, 0, arr.length - 1, 4, 7, -1);
		System.out.println(querySum(root, 0, arr.length - 1, 4, 7, 0));
		System.out.println(querySum(root, 0, arr.length - 1, 6, 7, 0));
		System.out.println(querySum(root, 0, arr.length - 1, 4, 6, 0));
		System.out.println(querySum(root, 0, arr.length - 1, 6, 6, 0));
	}

	public static Integer querySum(Node root, int start, int end, int qs, int qe, int changesForTheSegment) {

		if (start > end || qe < start || qs > end) {
			return 0;
		}

		if (start >= qs && end <= qe) {
			return root.value + (end - start + 1) * changesForTheSegment;
		}

		changesForTheSegment += root.changes;
		int mid = (start + end) / 2;
		Integer leftValue = querySum(root.left, start, mid, qs, qe, changesForTheSegment);
		Integer rightValue = querySum(root.right, mid + 1, end, qs, qe, changesForTheSegment);

		return leftValue + rightValue;
	}

	public static Integer queryMax(Node root, int start, int end, int qs, int qe, int changesForTheSegment) {

		if (start > end || qe < start || qs > end) {
			return Integer.MIN_VALUE;
		}

		if (start >= qs && end <= qe) {
			return root.value + changesForTheSegment;
		}

		changesForTheSegment += root.changes;
		int mid = (start + end) / 2;
		Integer leftValue = queryMax(root.left, start, mid, qs, qe, changesForTheSegment);
		Integer rightValue = queryMax(root.right, mid + 1, end, qs, qe, changesForTheSegment);

		return Math.max(leftValue, rightValue);
	}

	public static void updateSum(Node root, int start, int end, int qs, int qe, int newValue) {

		if (start > end || qe < start || qs > end) {
			return;
		}

		if (start >= qs && end <= qe) {
			root.changes += newValue;
			root.value += newValue * (end - start + 1);
			return;
		}

		int mid = (start + end) / 2;
		updateSum(root.left, start, mid, qs, qe, newValue);
		updateSum(root.right, mid + 1, end, qs, qe, newValue);

		root.value = (root.left != null ? root.left.value : 0) + (root.right != null ? root.right.value : 0)
				+ root.changes * (end - start + 1);
	}

	public static void updateMax(Node root, int start, int end, int qs, int qe, int newValue) {

		if (start > end || qe < start || qs > end) {
			return;
		}

		if (start >= qs && end <= qe) {
			root.changes += newValue;
			root.value += newValue;
			return;
		}

		int mid = (start + end) / 2;
		updateMax(root.left, start, mid, qs, qe, newValue);
		updateMax(root.right, mid + 1, end, qs, qe, newValue);

		root.value = Math.max(root.left != null ? root.left.value : Integer.MIN_VALUE,
				root.right != null ? root.right.value : Integer.MIN_VALUE)
				+ root.changes;
	}

	public static Node build(int[] arr, int start, int end, boolean max) {

		Node n = new Node();

		if (start == end) {
			n.value = arr[start];
			return n;
		}

		int mid = (start + end) / 2;

		n.left = build(arr, start, mid, max);
		n.right = build(arr, mid + 1, end, max);
		if (max) {
			n.value = Math.max(n.left != null ? n.left.value : Integer.MIN_VALUE, n.right != null ? n.right.value
					: Integer.MIN_VALUE);
		} else {
			int sum = 0;
			if (n.left != null) {
				sum += n.left.value;
			}
			if (n.right != null) {
				sum += n.right.value;
			}
			n.value = sum;
		}

		return n;
	}

}
