package amdocs;

import java.util.Arrays;

public class MergeSingleArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 3, 6, 8, -5, -2, 3, 8 };
		// int[] arr = { 4, 7, 9, 20, 1, 3, 10, 15 };
		// int[] arr = { 1, -5, -2 };
		// int[] arr = { 30, 40, 50, 3, 4, 5 };
		merge2(arr);
	}

	public static void merge2(int arr[]) {

		int endOfSecHalf = arr.length - 1;
		int endOfFirstHalf = arr.length / 2 - 1;
		System.out.println(Arrays.toString(arr));
		while (endOfFirstHalf >= 0) {
			// find first smaller element in sec half then the max el in first
			// half
			while (arr[endOfSecHalf] >= arr[endOfFirstHalf] && endOfSecHalf > endOfFirstHalf) {
				endOfSecHalf--;
			}
			// all elements in sec half are bigger the elements in the first
			// half
			if (endOfSecHalf == endOfFirstHalf) {
				// break;
				return;
			}
			int temp = arr[endOfFirstHalf];
			for (int i = endOfFirstHalf + 1; i <= endOfSecHalf; i++) {
				arr[i - 1] = arr[i];
			}
			arr[endOfSecHalf] = temp;
			endOfSecHalf--;
			endOfFirstHalf--;
			System.out.println(Arrays.toString(arr));
		}
	}
}
