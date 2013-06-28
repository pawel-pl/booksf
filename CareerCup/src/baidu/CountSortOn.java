package baidu;

import java.util.Arrays;

/*
 * http://en.wikipedia.org/wiki/Counting_sort
 * http://www.careercup.com/question?id=9655653
 */
public class CountSortOn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 5, 7, 3, 3 };
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			} else if (arr[i] < min) {
				min = arr[i];
			}
		}
		int[] count = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}
		System.out.println(Arrays.toString(count));
		int elementsBefore = 0;
		for (int i = 0; i < count.length; i++) {
			int temp = count[i];
			count[i] = elementsBefore;
			elementsBefore += temp;
		}
		System.out.println(Arrays.toString(count));
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[count[arr[i] - min]] = arr[i];
			count[arr[i] - min]++;
		}
		System.out.println(Arrays.toString(result));
	}

}
