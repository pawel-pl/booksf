package modeln;

import java.util.HashSet;
import java.util.Set;

public class FindFirstMissingPositivNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = {0,1,2};
		//int a[] = { 3, 4, -1, 1 };
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int arrSum = 0;
		int result;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				arrSum += a[i];
				if (a[i] > max) {
					max = a[i];
				}
			}
		}
		sum = (max * (max + 1)) / 2;
		if (sum == arrSum) {
			result = max + 1;
		} else {
			result = sum - arrSum;
		}
		System.out.println(result);
		findMissing(a);
	}

	public static void findMissing(int arr[]) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				set.add(arr[i]);
				if (arr[i] < min) {
					min = arr[i];
				} else if (arr[i] > max) {
					max = arr[i];
				}
			}
		}
		if (min > 1) {
			System.out.println(1);
			return;
		}
		boolean change = false;
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(min + 1)) {
				min = min + 1;
				change = true;
			}
			if (change == false) {
				break;
			} else {
				change = false;
			}
		}
		if (min == max) {
			System.out.println(max + 1);
		} else {
			System.out.println(min + 1);
		}
	}

}
