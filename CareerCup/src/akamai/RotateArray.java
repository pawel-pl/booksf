package akamai;

import java.util.Arrays;

public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 1;
		rotateArray(arr.clone(), k);
	}

	public static void rotateArray(int[] arr, int k) {

		int swapIndex = 0;
		int swapValue = arr[0];
		int swapedCount = 0;
		while (swapedCount < arr.length) {
			int newIndex = swapIndex - k;
			if (newIndex < 0) {
				newIndex = arr.length + newIndex;
			}
			swapedCount++;
			int temp = arr[newIndex];
			arr[newIndex] = swapValue;
			swapIndex = newIndex;
			swapValue = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

}
