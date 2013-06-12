package yahoo;

import java.util.Arrays;


public class SortPartialySorted {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 8, 7, 6, 5, 4 };
		int[] unsortedPart = new int[5];
		int[] sortedPart = new int[3];
		System.arraycopy(a, 3, unsortedPart, 0, 5);
		System.arraycopy(a, 0, sortedPart, 0, 3);
		unsortedPart = sort(unsortedPart);
		System.out.println(Arrays.toString(merge(unsortedPart, sortedPart)));
	}

	public static int[] sort(int[] a) {

		if (a.length <= 1) {
			return a;
		}
		int m = a.length / 2;
		int[] left = new int[m];
		int[] right = new int[a.length - m];
		System.arraycopy(a, 0, left, 0, m);
		System.arraycopy(a, m, right, 0, a.length - m);
		left = sort(left);
		right = sort(right);
		
		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {

		int[] result = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {

			if (left[i] > right[j]) {
				result[k] = right[j];
				j++; // Next right-index
			} else {
				result[k] = left[i];
				i++;
			}
			k++;
		}
		while (i < left.length) {
			result[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			result[k] = right[j];
			j++; // right-index
			k++; // result-index
		}
		return result;
	}

}
