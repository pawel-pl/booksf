package student;

/*
 *  0	1	1	0	0 
 *	0	0	0	1	1 
 *	0	1	0	1	1 
 *	0	1	1	1	0 
 *	0	1	1	1	0 
 *	1	0	1	1	0 
 */
public class LargestRectangAreaHistoMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] a = { { 1, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println("Maximum area is " + findMaxMatrix(a));
	}

	public static int findMaxMatrix(int a[][]) {

		int max, cur_max;
		cur_max = 0;
		int row = a.length;
		int col = a[0].length;

		// Calculate Auxilary matrix
		for (int j = 0; j < col; j++)
			for (int i = 1; i < row; i++) {
				if (a[i][j] == 1)
					a[i][j] = a[i - 1][j] + 1;
			}

		// Calculate maximum area in S for each row
		for (int i = 0; i < row; i++) {
			max = LargestRectangAreaHisto.getMaxArea(a[i], col);
			if (max > cur_max)
				cur_max = max;
		}

		// Regenerate Oriignal matrix
		for (int i = row - 1; i > 0; i--)
			for (int j = 0; j < col; j++) {
				if (a[i][j] == 0)
					a[i][j] = a[i][j] - a[i - 1][j];
			}

		return cur_max;
	}
}
