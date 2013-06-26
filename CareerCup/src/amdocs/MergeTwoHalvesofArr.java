package amdocs;

import java.util.Arrays;

public class MergeTwoHalvesofArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//int[] arr = { 1, 3, 6, 8, -5, -2, 3, 8 };
		//int[] arr = { 1, -5, -2 };
		int[] arr = { 30, 40, 50, 3, 4, 5 };
		int endOfSecHalf = arr.length - 1;
		int endOfFirstHalf = arr.length / 2 - 1;
		while (endOfSecHalf > 0) {
			while (arr[endOfSecHalf] >= arr[endOfFirstHalf] && endOfSecHalf > endOfFirstHalf) {
				endOfSecHalf--;
			}
			// all elements in sec half are bigger the elements in the first
			// half
			if (endOfSecHalf == endOfFirstHalf) {
				// break;
				return;
			}
			if (endOfFirstHalf == 0) {
				int temp = arr[0];
				for(int i=1; i <= endOfSecHalf; i++) {
					arr[i-1] = arr[i];
				}
				arr[endOfSecHalf] = temp;
				break;
			} else {
				int i = endOfFirstHalf;
				while (i > 0 && arr[endOfSecHalf] <= arr[i]) {
					i--;
				}
				int k = endOfFirstHalf;
				while (k > i) {
					int temp = arr[endOfSecHalf];
					arr[endOfSecHalf] = arr[k];
					arr[k] = temp;
					k--;
					endOfSecHalf--;
				}
				endOfSecHalf = endOfFirstHalf - 1;
				endOfFirstHalf = i;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
