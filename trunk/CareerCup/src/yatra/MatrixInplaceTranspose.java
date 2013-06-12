package yatra;

/*
 * http://www.geeksforgeeks.org/inplace-m-x-n-size-matrix-transpose/
 * http://en.wikipedia.org/wiki/In-place_matrix_transposition
 */
public class MatrixInplaceTranspose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * int[] a = { 1, 2, 4 }; int next = 0; for (int i = 0; i < a.length;
		 * i++) { next = (a[i] * 2) % 7; System.out.println(next); }
		 */

		int r = 2, c = 4;
		int size = r * c;
		int[] a = new int[size];

		for (int i = 0; i < size; i++)
			a[i] = i + 1;

		print2DArray(a, r, c);
		matrixInplaceTranspose(a, r, c);
		print2DArray(a, c, r);

	}

	public static void matrixInplaceTranspose(int[] a, int rowCount, int colCount) {

		int n = rowCount * colCount;
		int swapIndex = 1;
		boolean[] used = new boolean[n];
		used[0] = used[n - 1] = true;
		while (swapIndex < n - 1) {
			int cycleBegin = swapIndex;
			int swapValue = a[swapIndex];
			// iterate over cycle
			do {
				int newIndex = (swapIndex * rowCount) % (n - 1);
				int temp = a[newIndex];
				a[newIndex] = swapValue;
				used[swapIndex] = true;
				swapIndex = newIndex;
				swapValue = temp;
			} while (swapIndex != cycleBegin);

			// find the beginning of the new cycle
			for (swapIndex = 1; swapIndex < n - 1 && used[swapIndex]; swapIndex++)
				;
		}
	}

	public static void print2DArray(int[] a, int rowCount, int colCount) {

		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				System.out.print(a[r * colCount + c] + " ");
			}

			System.out.print("\n");
		}

		System.out.print("\n");
	}

}
