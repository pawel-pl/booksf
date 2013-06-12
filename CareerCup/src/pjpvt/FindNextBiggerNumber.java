package pjpvt;

import java.util.Arrays;

public class FindNextBiggerNumber {

	// 12342 12423
	public static void main(String[] args) {

		String str = "84265";
		char[] num = str.toCharArray();
		int index = -1;
		for (int i = num.length - 1; i >= 1; i--) {
			if (num[i] > num[i - 1]) {
				index = i - 1;
				break;
			}
		}
		if (index < 0) {
			return;
		}
		int diff = Integer.MAX_VALUE;
		int indexToReplace = 0;
		for (int i = num.length - 1; i > index; i--) {
			int currentDiff = num[i] - num[index];
			if (currentDiff > 0 && currentDiff < diff) {
				diff = currentDiff;
				indexToReplace = i;
			}
		}
		char temp = num[index];
		num[index] = num[indexToReplace];
		num[indexToReplace] = temp;
		quickSort(num, index + 1, num.length - 1);
		System.out.println(Arrays.toString(num));
	}

	public static int partition(char[] num, int start, int end) {

		int i = start;
		int j = end;
		char pivot = num[(start + end) / 2];
		while (i < j) {
			while (num[i] < pivot) {
				i++;
			}
			while (num[j] > pivot) {
				j--;
			}
			if (i < j) {
				char temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				j--;
				i++;
			}
		}

		return i;
	}

	public static void quickSort(char[] num, int start, int end) {

		int i = partition(num, start, end);
		if (i - 1 > start) {
			quickSort(num, start, i - 1);
		}
		if (i < end) {
			quickSort(num, i, end);
		}
	}

}
