package interview;

public class CountParentPhases {

    public static void main(String[] args) {

	System.out.println(count("(a(b))(c(d(f))g)(y(h))"));

    }

    public static int count(String s) {
	char[] c = s.toCharArray();
	int max = 0;
	int count = 0;
	int leftCount = 0;
	int rightCount = 0;
	for (int i = 0; i < c.length; i++) {
	    if (rightCount > leftCount) {
		return -1;
	    }
	    if (c[i] == '(') {
		leftCount++;
		count++;
		if (count > max) {
		    max = count;
		}
	    } else if (c[i] == ')') {
		rightCount++;
		count--;
	    }
	}
	if (leftCount != rightCount) {
	    return -1;
	}
	return max;
    }

    // root
    class Node {
	Node left;
	Node right;
	int v;
    }

    public static Integer find(Node root, int n) {

	if (root == null) {
	    return null;
	}
	Integer result = null;
	result = find(root.left, n);
	if (root.v <= n) {
	    result = find(root.right, n);
	} else {
	    result = root.v;
	}

	return result;
    }
}
