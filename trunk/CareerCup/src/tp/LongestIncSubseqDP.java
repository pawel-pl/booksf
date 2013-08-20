package tp;

import java.util.Arrays;

/*
 * http://professorjava.weebly.com/longest-increasing-subsequence.html
 *     // for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33,
 // 50, 60, 80}
 */
public class LongestIncSubseqDP {

    /**
     * @param args
     */
    public static void main(String[] args) {

	// int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	// int[] arr = { 5, 6, 7, 1, 2, 3 };
	// int[] arr = { 5, 6, 7, 1, 2, 3 };
	int[] arr = { 5, 4, 3, 2, 1 };
	int[] L = new int[arr.length];
	increasingSubsequence(arr, L);
	if (arr[0] > arr[arr.length - 1]) {
	    L[0] = L[arr.length - 1];
	    increasingSubsequence(arr, L);
	}

	int max = 0;
	for (int i = 0; i < L.length; i++) {
	    if (L[i] > max) {
		max = L[i];
	    }
	}
	System.out.println(Arrays.toString(arr));
	System.out.println(Arrays.toString(L));
	System.out.println(max);
    }

    public static void increasingSubsequence(int[] arr, int[] L) {

	L[0] += 1;
	for (int i = 1; i < L.length; i++) {
	    int maxn = 0;
	    for (int j = 0; j < i; j++) {
		if (arr[j] < arr[i] && L[j] > maxn) {
		    maxn = L[j];
		}
	    }
	    L[i] = maxn + 1;
	}
    }
}
