package worksapp;

import java.util.Stack;

public class StackMiddleEl {

	/**
	 * @param args
	 */
	static class StackDepth {

		Integer depth = null;
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);

		System.out.println(getMiddleEl(stack, new StackDepth(), 0));
	}

	public static Integer getMiddleEl(Stack<Integer> s, StackDepth depth, int level) {

		if (s.isEmpty()) {
			depth.depth = --level;
			return null;
		}
		Integer currentElement = s.pop();
		Integer middleEl = getMiddleEl(s, depth, level+1);
		s.push(currentElement);
		if (level == depth.depth / 2) {
			middleEl = currentElement;
		}

		return middleEl;
	}

}
