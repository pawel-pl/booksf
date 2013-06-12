package nvidia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * For ex- {4,5,1,5,7,6,8,4,1} and W is 5, output can be -{5,7,6,8,4}.
 * http://stackoverflow.com/questions/12234510/subarray-which-consists-of-numbers-that-can-be-arranged-in-a-continuous-sequence
 */
public class ContiguousSubarrayOfLengthW {

	private int w = 5;
	private int start;
	private int end = w - 1;
	// int[] arr = { 1, 2, 3, 4, 5, 1, 3, 3, 5, 7, 6, 8, 4, 1, 15, 20 };
	int[] arr = { 42, 10, 7, 4, 5, 1, 5, 7, 6, 8, 4, 1 };
	private int min = arr[0];
	private int max = arr[0];
	private Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {

		ContiguousSubarrayOfLengthW sol = new ContiguousSubarrayOfLengthW();
		sol.findSubArr();
	}

	private void findSubArr() {

		for (start = 0; start <= end; start++) {
			if (set.contains(arr[start])) {
				if (reset()) {
					continue;
				} else {
					break;
				}
			}
			set.add(arr[start]);
			min = Math.min(min, arr[start]);
			max = Math.max(max, arr[start]);
			if (!checkMinMax()) {
				if (reset()) {
					continue;
				} else {
					break;
				}
			}
		}

		if (start > end) {
			int[] subArr = new int[w];
			System.arraycopy(arr, start - w, subArr, 0, w);
			System.out.println("Start: " + (start - w) + ", end: " + end + ": " + Arrays.toString(subArr));
		}
	}

	private boolean reset() {

		end = start + w - 1;
		if (end >= arr.length) {
			return false;
		}
		min = arr[start];
		max = arr[start];
		set.clear();
		set.add(arr[start]);
		return true;
	}

	private boolean checkMinMax() {

		return max - min <= w;
	}

}
