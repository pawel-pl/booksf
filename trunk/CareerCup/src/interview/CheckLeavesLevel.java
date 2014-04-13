package interview;

public class CheckLeavesLevel {

    class Node {
	Node left;
	Node right;
    }

    Integer lastLevel = null;

    public boolean checkDepth(Node n, int level) {
	if (n.left == null && n.right == null) {
	    if (lastLevel == null || lastLevel.equals(level)) {
		lastLevel = level;
		return true;
	    }
	    return false;
	}
	boolean result = true;
	if (n.left != null) {
	    result = checkDepth(n.left, level + 1);
	}
	if (result == true && n.right != null) {
	    result = checkDepth(n.right, level + 1);
	}

	return result;
    }
}
