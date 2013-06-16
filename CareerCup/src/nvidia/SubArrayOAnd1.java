package nvidia;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 */
public class SubArrayOAnd1 {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
	// int arr[] = {1, 0, 0, 1, 0, 1, 1};;
	findSubArray(arr, arr.length);
    }

    private static int findSubArray(int arr[], int n) {

	int maxsize = -1, startindex = -1; // variables to store result values

	// Create an auxiliary array sunmleft[]. sumleft[i] will be sum of array
	// elements from arr[0] to arr[i]
	int[] sumleft = new int[n];
	int min, max; // For min and max values in sumleft[]
	int i;

	// Fill sumleft array and get min and max values in it.
	// Consider 0 values in arr[] as -1
	sumleft[0] = ((arr[0] == 0) ? -1 : 1);
	min = arr[0];
	max = arr[0];
	for (i = 1; i < n; i++) {
	    sumleft[i] = sumleft[i - 1] + ((arr[i] == 0) ? -1 : 1);
	    if (sumleft[i] < min)
		min = sumleft[i];
	    if (sumleft[i] > max)
		max = sumleft[i];
	}
	int[] hash = new int[max - min + 1];

	// Initialize hash table
	for (i = 0; i < max - min + 1; i++)
	    hash[i] = -1;

	for (i = 0; i < n; i++) {
	    // Case 1: when the subarray starts from index 0
	    if (sumleft[i] == 0) {
		maxsize = i + 1;
		startindex = 0;
	    }

	    // Case 2: fill hash table value. If already filled, then use it
	    // leftmost index of the value
	    if (hash[sumleft[i] - min] == -1)
		hash[sumleft[i] - min] = i;
	    // if find again check the difference
	    else if ((i - hash[sumleft[i] - min]) > maxsize) {
		maxsize = i - hash[sumleft[i] - min];
		startindex = hash[sumleft[i] - min] + 1;
	    }

	    System.out.println(Arrays.toString(hash));
	}
	if (maxsize == -1)
	    System.out.println("No such subarray");
	else
	    System.out.println(String.format("Maxsize: %d, %d to %d", maxsize, startindex, startindex + maxsize - 1));

	return maxsize;
    }

}
