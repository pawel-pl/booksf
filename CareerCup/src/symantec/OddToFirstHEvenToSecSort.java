package symantec;

import java.util.Arrays;

public class OddToFirstHEvenToSecSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(arr));
		moveEl(arr);
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, (arr.length / 2) - 1);
		System.out.println(Arrays.toString(arr));
		quickSort(arr, arr.length / 2, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void moveEl(int[] arr) {

		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {

			while (i % 2 != 0) {
				i++;
			}
			while (j % 2 == 0) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		/*
		 * int m = arr.length / 2; int i = 0; int j = m % 2 == 0 ? m + 1 : m;
		 * 
		 * 
		 * while (i < m && j < arr.length) {
		 * 
		 * int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp; i = i + 2; j = j +
		 * 2; }
		 */
	}

	private static void quickSort(int[] arr, int start, int end) {

		int i = partition(arr, start, end);
		if (i - 1 > start) {
			quickSort(arr, start, i - 1);
		}
		if (i < end) {
			quickSort(arr, i, end);
		}
	}

	public static int partition(int arr[], int left, int right) {

		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}

		return i;
	}
}
