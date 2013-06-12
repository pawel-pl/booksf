package symphony;

import java.util.Arrays;

public class Multiply2Arr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 3 };
		int[] c = new int[3];

		int temp = 1;
		for (int i = 0; i < b.length; i++) {
			temp *= b[i];
		}

		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] * temp / b[i];
		}

		System.out.println(Arrays.toString(c));
	}

}
