package interview;

import java.util.Arrays;

public class SortNames {

    public static void main(String[] args) {

	String[] names = { "hkl", "cdf", "pxz", "zxh", "lbc", "fgh" };
	sortNames(names, 0, names.length - 1);
	System.out.println(Arrays.toString(names));
    }

    public static void sortNames(String[] names, int l, int r) {

	int i = partition(names, 0, r);
	if (i - 1 > l) {
	    partition(names, l, i - 1);
	}
	if (i < r) {
	    partition(names, i, r);
	}
    }

    public static int partition(String[] names, int l, int r) {
	int pivot = l + (r - l) / 2;
	System.out.println(names[pivot]);
	char pivotFirstChar = names[pivot].charAt(0);
	char pivotLastChar = names[pivot].charAt(names[pivot].length() - 1);
	while (l <= r) {
	    while (names[l].charAt(names[l].length() - 1) == pivotFirstChar) {
		l++;
	    }
	    while (names[r].charAt(0) == pivotLastChar) {
		r--;
	    }
	    if (l <= r) {
		String temp = names[l];
		names[l] = names[r];
		names[r] = temp;
		l++;
		r--;
		System.out.println(Arrays.toString(names));
	    }
	}

	return l;
    }
}
