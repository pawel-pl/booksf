package mSpot;

import java.util.Arrays;

public class NCombinationsFromArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int n = 3;
		findCombinations(arr, 0, 0, n, new int[n]);
	}

	private static void findCombinations(int[] arr, int startFrom, int index, int n, int[] result) {

		if (index == n) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = startFrom; i < arr.length; i++) {
			result[index] = arr[i];
			findCombinations(arr, i + 1, index + 1, n, result);
		}
	}
}
