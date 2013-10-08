package unitedhealthgroup;

import java.util.Arrays;

public class SortDupsInTwoSubArr {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int arr[] = { 2, 9, 1, 5, 1, 4, 9, 7, 2, 1, 4 };
	int min = arr[0];
	int max = arr[0];
	for (int i = 1; i < arr.length; i++) {
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
	int i = 0;
	while (i < arr.length) {
	    for (int j = 0; j < count.length; j++) {
		if (count[j] > 0) {
		    arr[i++] = j + min;
		    count[j]--;
		}
	    }
	}
	System.out.println(Arrays.toString(arr));
    }

}
