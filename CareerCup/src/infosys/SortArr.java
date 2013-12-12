package infosys;

import java.util.Arrays;

/*
 * http://www.careercup.com/question?id=14183738
 */
public class SortArr {

    public static void main(String[] args) {

	int[] arr = { 3, -1, -2, 2, 2, 3, 2, -6, 2, 3, -8, 0, 2 };

	int positivePtr = arr.length - 1;
	int negativePtr = arr.length - 1;

	System.out.println(Arrays.toString(arr));
	while (positivePtr >= 0 && negativePtr >= 0) {
	    if (arr[positivePtr] < 0) {
		positivePtr--;
	    } else {
		if (negativePtr >= positivePtr || arr[negativePtr] >= 0) {
		    negativePtr--;
		} else {
		    int tmp = arr[positivePtr];
		    arr[positivePtr] = arr[negativePtr];
		    arr[negativePtr] = tmp;
		    negativePtr--;
		    positivePtr--;
		}
	    }
	}
	System.out.println(Arrays.toString(arr));
    }

}
