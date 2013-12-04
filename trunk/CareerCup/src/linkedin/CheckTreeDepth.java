package linkedin;

import java.util.Stack;

public class CheckTreeDepth {

    /**
     * @param args
     */
    public static void main(String[] args) {

	System.out.println(checkDepth("(00)"));
	System.out.println(checkDepth("((00)0)"));
	System.out.println(checkDepth("((00)(00))"));
	System.out.println(checkDepth("((00)(0(00)))"));
	System.out.println(checkDepth("((00)(0(0(00))))"));
	System.out.println(checkDepth("x"));
	System.out.println(checkDepth("0"));
	System.out.println(checkDepth("()"));
	System.out.println(checkDepth("(0)"));
	System.out.println(checkDepth("(00)x"));
	System.out.println(checkDepth("(0p)"));
	System.out.println(checkDepth("(00)(00)(00)"));
	System.out.println(checkDepth("(000)"));
    }

    public static int checkDepth(String str) {

	char[] arr = str.toCharArray();
	if (arr.length < 4 || arr[0] != '(' || str.matches("\\(\\w+\\)(\\(\\w+\\))+")) {
	    return -1;
	}

	int childCount = 0;
	int leftCount = 1;
	int rightCount = 0;
	int depth = 0;
	Stack<Integer> childs = new Stack<Integer>();
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] == '0') {
		childCount++;
		if (childCount > 2) {
		    return -1;
		}
	    } else if (arr[i] == ')') {
		rightCount++;
		if (rightCount > leftCount || childCount != 2) {
		    return -1;
		} else if (!childs.isEmpty()) {
		    childCount = childs.pop();
		} else {
		    childCount = 0;
		}
	    } else if (arr[i] == '(') {
		childCount++;
		leftCount++;
		if (childCount > 2) {
		    return -1;
		} else {
		    childs.push(childCount);
		    depth = Math.max(depth, childs.size());
		    childCount = 0;
		}
	    } else {
		return -1;
	    }
	}
	if (leftCount != rightCount) {
	    return -1;
	}
	return depth;
    }
}
