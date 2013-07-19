package expedia;

import java.util.Arrays;

public class AddTwoArraysFromEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4 };
		// int[] b = { 5, 6, 7, 8 };
		int[] b = { 9, 6, 7, 8 };

		addArrays(a, b);
	}

	public static void addArrays(int[] a, int[] b) {

		int remainder = 0;
		int[] result = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			int r = a[i] + b[i] + remainder;
			result[i] = r % 10;
			remainder = r / 10;
		}
		if (remainder != 0) {
			int[] temp = result;
			result = new int[temp.length + 1];
			result[0] = remainder;
			System.arraycopy(temp, 0, result, 1, temp.length);
		}
		System.out.println(Arrays.toString(result));
	}
}
