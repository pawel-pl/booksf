package myntra;


/*
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * 
 *     10  1   3   25
 * in  10  1   13  35 
 * ex  0   10  10  13
 * 
 * ex - max sum excluding current element
 * in - max sum including current element 
 */
public class MaxSumNotAdjacent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 10, 1, 3, 25 };
		// int a[] = { 5, 5, 10, 40, 50, 35 };
		// int a[] = { 5, 5, 10, 100, 10, 5 };
		// int[] a = { 3, 2, 5, 10, 7 };
		int currentSum = 0;
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int offset = 2; i + offset < a.length; offset++) {
				currentSum = a[i];
				for (int k = i + offset; k < a.length; k = k + offset) {
					currentSum += a[k];
					maxSum = Math.max(maxSum, currentSum);
				}
			}
		}
		System.out.println(maxSum);
		findMaxSum(a);

	}

	private static void findMaxSum(int arr[]) {
		
		// current max including i
		int incl = arr[0];
		// current max excluding i
		int excl = 0;
		int excl_new;
		int i;
		for (i = 1; i < arr.length; i++) {
			/* current max excluding i */
			excl_new = Math.max(incl, excl);
			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}
		/* return max of incl and excl */
		System.out.println(Math.max(incl, excl));
	}
}
