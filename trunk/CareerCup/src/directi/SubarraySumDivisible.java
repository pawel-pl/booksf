package directi;

import java.util.Arrays;

public class SubarraySumDivisible {
	public static void computeSubarray(int[] a) {
		int[] b = new int[a.length + 1];
		b[0] = 0;
		for (int i = 0; i < a.length; i++)
			b[i + 1] = (b[i] + a[i]) % a.length;
		int[] c = new int[a.length];
		Arrays.fill(c, -1);
		for (int i = 0; i < b.length; i++) {
			int pos = b[i];
			if (c[pos] < 0)
				c[pos] = i;
			else {
				int begin = c[pos], end = i;
				int sum = 0;
				for (int j = begin; j < end; j++)
					sum += a[j];

				System.out.println("found solution: subarray from index " + begin + " (inclusive) to " + end
						+ " (exclusive)");
				System.out.println("has sum = " + sum + ", which is divisible by length of array " + a.length);

				return;
			}
		}
		// you are not supposed to get here
		System.err.println("You broke math.");
		System.exit(1);
	}

	public static void main(String[] args) {
		// TODO: parse this from the user or generate randomly
		int[] a = { 63, 92, 51, 92, 39, 15, 43, 89, 36, 69, 40, 16, 23, 2, 29, 91, 57, 43, 55, 22 };
		computeSubarray(a);
	}
}
