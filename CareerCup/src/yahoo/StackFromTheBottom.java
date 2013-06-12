package yahoo;

import java.util.Stack;

public class StackFromTheBottom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		while(!stack.isEmpty()) {
			System.out.println(pop(stack));
		}

	}

	private static Integer pop(Stack<Integer> stack) {
		Integer temp = null, temp1 = null;

		if (stack.size() == 1) {
			temp = stack.pop();
		} else {
			temp1 = stack.pop();
			temp = pop(stack);
			stack.push(temp1);
		}

		return temp;
	}

}
