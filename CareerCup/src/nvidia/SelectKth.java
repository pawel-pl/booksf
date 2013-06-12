package nvidia;

import java.util.Arrays;

/*
 * http://blog.teamleadnet.com/2012/07/quick-select-algorithm-find-kth-element.html
 * http://stackoverflow.com/questions/5380568/algorithm-to-find-k-smallest-numbers-in-array-of-n-items
 * http://crackprogramming.blogspot.fi/2012/11/find-kth-largest-integer-given-integer.html
 * http://stackoverflow.com/questions/13023188/smallest-subset-of-array-whose-sum-is-no-less-than-key
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * http://www.careercup.com/question?id=14491723
 */
public class SelectKth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1 2 3 4 5 6
		// int[] arr = new int[] { 5, 1, 4, 3, 2, 6 };
		int[] arr = new int[] { 45, 97, 66, 92, 71, 11, 1, 4, 3, 2, 12, 6, 18 };
		quickSort(arr, 0, arr.length - 1, 5);
		// int[] arr = new int[] { 0, 1 };
		// System.out.println(selectKth(arr, 0));
		System.out.println(Arrays.toString(arr));
	}

	public static int selectKth(int[] arr, int k) {

		if (arr == null || arr.length <= k)
			throw new Error();

		int from = 0, to = arr.length - 1;

		// if from == to we reached the kth element
		while (from < to) {
			int left = from, right = to;
			int mid = arr[(left + right) / 2];
			// stop if the reader and writer meets
			while (left < right) {
				if (arr[left] >= mid) { // put the large values at the end
					int tmp = arr[right];
					arr[right] = arr[left];
					arr[left] = tmp;
					right--;
				} else { // the value is smaller than the pivot, skip
					left++;
				}
			}
			// if we stepped up (r++) we need to step one down
			if (arr[left] > mid) {
				left--;
			}
			// the r pointer is on the end of the first k elements
			if (k <= left) {
				to = left;
			} else {
				from = left + 1;
			}
		}
		return arr[k];
	}

	public static int partition(int arr[], int left, int right) {

		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		System.out.println("Left: " + left + ", Right: " + right + ", Pivot: " + pivot + ", i: " + i + ", Arr: "
				+ Arrays.toString(arr));
		return i;
	}

	public static void quickSort(int arr[], int left, int right, int k) {

		int index = partition(arr, left, right);
		if (k <= index - 1 && left < index - 1)
			quickSort(arr, left, index - 1, k);
		if (k > index && index < right)
			quickSort(arr, index, right, k);

		System.out.println(arr[k]);
	}

}
