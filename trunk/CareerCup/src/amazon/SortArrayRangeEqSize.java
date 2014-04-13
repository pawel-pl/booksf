package amazon;

import java.util.Arrays;

/*
 * http://www.careercup.com/question?id=5705699820568576
 * 
 */
public class SortArrayRangeEqSize {

    public static void main(String[] args) {

	// int[] arr = { 9, 9, 9, 9, 9, 9, 9, 8, 7, 9, 9 };
	int[] arr = { 2, 2, 4, 4, 5 };
	int pos = 0;
	int desiredPos = 0;
	while (pos < arr.length) {
	    if (arr[pos] <= 0) {
		pos++;
		continue;
	    }
	    desiredPos = arr[pos] - 1;
	    if (arr[desiredPos] > 0) {
		arr[pos] = arr[desiredPos];
		arr[desiredPos] = -1;
	    } else {
		arr[desiredPos]--;
		arr[pos] = 0;
		pos++;
	    }
	}
	System.out.println(Arrays.toString(arr));
    }
}
