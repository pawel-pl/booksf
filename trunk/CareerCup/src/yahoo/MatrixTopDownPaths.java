package yahoo;

import java.util.ArrayList;

public class MatrixTopDownPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int i = 0; i < 3; i++) {
			printPaths(m, 0, i, 3, 3, new ArrayList<Integer>());
		}

	}

	public static void printPaths(int[][] m, int r, int c, int rowCount, int colCount, ArrayList<Integer> path) {

		int nextRow = r + 1;
		path.add(m[r][c]);

		if (nextRow == rowCount) {
			System.out.println(path);
			path.remove(r);
			return;
		}
		if (c - 1 >= 0) {
			printPaths(m, nextRow, c - 1, rowCount, colCount, path);
		}
		printPaths(m, nextRow, c, rowCount, colCount, path);
		if (c + 1 < colCount) {
			printPaths(m, nextRow, c + 1, rowCount, colCount, path);
		}

		path.remove(r);
	}

}
