package facebook;

import java.util.Arrays;

public class UniqueThreeMemberSubsets {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int[] arr = { 2, 2, 2, 1, 1, 1, 4, 4, 4, 3, 3, 3, 5, 5 };
	// int[] arr = { 2, 2, 2 };
	Arrays.sort(arr);
	int[] triplet = new int[3];
	for (int i = 0; i < arr.length - 2;) {
	    triplet[0] = arr[i];
	    while (i < arr.length && arr[i] == triplet[0]) {
		i++;
	    }
	    for (int j = i; j < arr.length - 1;) {
		triplet[1] = arr[j];
		while (j < arr.length && arr[j] == triplet[1]) {
		    j++;
		}
		for (int l = j; l < arr.length;) {
		    triplet[2] = arr[l];
		    System.out.println(Arrays.toString(triplet));
		    while (l < arr.length && arr[l] == triplet[2]) {
			l++;
		    }
		}
	    }
	}
    }

    public static void quickSort(int[] arr, int start, int end) {

	int i = partition(arr, start, end);
	if (i - 1 > start) {
	    quickSort(arr, start, i - 1);
	}
	if (i < end) {
	    quickSort(arr, i, end);
	}
    }

    public static int partition(int[] arr, int start, int end) {

	int pivot = arr[start + (end - start) / 2];
	int i = start;
	int j = end;

	while (i <= j) {
	    while (arr[i] < pivot) {
		i++;
	    }
	    while (arr[j] > pivot) {
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

	return i;
    }
}
