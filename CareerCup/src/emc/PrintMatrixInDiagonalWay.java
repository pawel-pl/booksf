package emc;

public class PrintMatrixInDiagonalWay {

	public static void main(String[] args) {

		int[][] m = { { 1, 2, 3, 4, 6 }, { 5, 4, 3, 5, 7 }, { 6, 5, 9, 8, 9 }, { 9, 8, 7, 6, 1 }, { 1, 8, 3, 6, 2 } };
		printMatrix(m);
	}

	public static void printMatrix(int[][] m) {

		int n = m.length;
		for (int i = 0; i < n; i++) {
			int r = 0;
			int c = i;
			while (r < n && c >= 0) {
				System.out.print(m[r][c] + " ");
				r += 1;
				c = c - 1;
			}
			System.out.println();
		}
		for (int i = 1; i < n; i++) {
			int r = i;
			int c = n - 1;
			while (r < n && c >= 0) {
				System.out.print(m[r][c] + " ");
				r += 1;
				c = c - 1;
			}
			System.out.println();
		}
	}
}
