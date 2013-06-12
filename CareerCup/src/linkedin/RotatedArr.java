package linkedin;

/*
 * http://leetcode.com/2010/04/searching-element-in-rotated-array.html
 */
public class RotatedArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 4, 5, 6, 7, 0, 1, 1 };
		System.out.println(findSortedArrayRotation(a));

	}

	int rotatedBinarySearch(int A[], int N, int key) {

		int L = 0;
		int R = N - 1;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = L + ((R - L) / 2);
			if (A[M] == key)
				return M;

			// the bottom half is sorted
			if (A[L] <= A[M]) {
				if (A[L] <= key && key < A[M])
					R = M - 1;
				else
					L = M + 1;
			}
			// the upper half is sorted
			else {
				if (A[M] < key && key <= A[R])
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
	}

	public static int findSortedArrayRotation(int A[]) {

		int L = 0;
		int R = A.length - 1;

		while (A[L] > A[R]) {
			int M = L + (R - L) / 2;
			if (A[M] > A[R])
				L = M + 1;
			else
				R = M;
		}
		return L;
	}
}
