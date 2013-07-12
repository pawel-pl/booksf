package directi;

import java.util.Arrays;
import java.util.Stack;

/*
 * Like Histogram - use stack
 */
public class FindClosestSmallerElBeforeX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] arr = { 1, 9, 8, 6, 3, 4, 8, 2, 10 };
		Integer[] output = new Integer[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while (i < arr.length) {
			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				output[stack.pop()] = stack.isEmpty() ? null : arr[stack.peek()];
			}
		}
		while (!stack.isEmpty()) {
			output[stack.pop()] = stack.isEmpty() ? null : arr[stack.peek()];
		}
		System.out.println(Arrays.toString(output));
	}

}
