package microsoft;

import java.util.Arrays;

/*
 * Sample Input:  3 5 7 8 4 9 
 * Sample Output: 3 < 5 > 4 < 8 >7 < 9
 */
public class SwapSmallerGreater {

    public static void main(String[] args) {

	// int[] a = { 3, 5, 7, 8, 4, 9 };
	int[] a = { 100, 7, 5, 8, 4, 9 };
	arrangeList(a);
	System.out.println(Arrays.toString(a));
    }

    private static void arrangeList(int A[]) {

	for (int i = 1; i < A.length; i++) {
	    if (i % 2 == 1 && A[i] < A[i - 1])
		swap(A, i, i - 1);
	    if (i % 2 == 0 && A[i] > A[i - 1])
		swap(A, i, i - 1);
	}
    }

    private static void swap(int[] a, int i, int j) {

	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
}
