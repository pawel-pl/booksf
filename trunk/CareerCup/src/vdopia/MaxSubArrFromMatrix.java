package vdopia;


/*
 * http://stackoverflow.com/questions/2643908/getting-the-submatrix-with-maximum-sum
 * http://www.algorithmist.com/index.php/UVa_108
 */
public class MaxSubArrFromMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int[][] m = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, {
		// -1, 8, 0, -2 } };
		int[][] m = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { 4, 1, -4, 1 }, { -1, -8, 0, -2 } };
/*		 int[][] m = { { -11, -2, -3, -4 }, { -5, -1, -7, -8 }, { -9, -10, -11,
		 -12 }, { -13, -14, -15, -16 } };*/
		int[][] r = findMaximumSubMatrix2(m);
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[0].length; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}



	public static int[][] findMaximumSubMatrix2(int[][] matrix) {
		
		int dim = matrix.length;
		// computing the vertical prefix sum for columns
		int[][] ps = new int[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (j == 0) {
					ps[j][i] = matrix[j][i];
				} else {
					ps[j][i] = matrix[j][i] + ps[j - 1][i];
				}
			}
		}

		int maxSum = Integer.MIN_VALUE;
		int beginIndexForRow = 0, sumForRow = 0;
		int top = 0, left = 0, bottom = 0, right = 0;

		for (int i = 0; i < dim; i++) {
			for (int k = i; k < dim; k++) {
				// Kadane over all columns with the i..k rows
				beginIndexForRow = 0;
				sumForRow = 0;
				for (int j = 0; j < dim; j++) {
					sumForRow += ps[k][j] - (i == 0 ? 0 : ps[i - 1][j]);
					if (sumForRow >= maxSum) {
						maxSum = sumForRow;
						top = i;
						bottom = k;
						left = beginIndexForRow;
						right = j;
					} else if (sumForRow < 0) {
						sumForRow = 0;
						beginIndexForRow = j + 1;
					}
				}
			}// Kandane ends here
		}

		System.out.println("Max SubMatrix determinant = " + maxSum);
		System.out.println("top: " + top + ", bottom: " + bottom + ", left: " + left + ", right: " + right);
		// composing the required matrix
		int[][] output = new int[bottom - top + 1][right - left + 1];

		for (int i = top, k = 0; i <= bottom; i++, k++) {
			for (int j = left, l = 0; j <= right; j++, l++) {
				output[k][l] = matrix[i][j];
			}
		}

		return output;
	}

}
