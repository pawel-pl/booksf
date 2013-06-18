package morganstanley;

/*
 * http://stackoverflow.com/questions/726756/print-two-dimensional-array-in-spiral-order
 */
public class SpiralMatrix {

	public static void printMatrix(int n, int[][] a) {

		int z = n - 1;
		for (int i = 0; i < n; i++) {
			// top left
			for (int l = z - i; l >= i; l--) {
				int k = i;
				System.out.printf("%d ", a[k][l]);
			}
			// left down
			for (int j = i + 1; j <= z - i; j++) {
				int k = i;
				System.out.printf("%d ", a[j][k]);
			}
			// bottom right
			for (int j = i + 1; j <= z - i; j++) {
				int k = z - i;
				System.out.printf("%d ", a[k][j]);
			}
			// right up
			for (int j = z - 1 - i; j >= i + 1; j--) {
				int k = z - i;
				System.out.printf("%d ", a[j][k]);
			}
		}
	}

	public static void printMatrix2(int n, int[][] a) {

		int z = n - 1;
		for (int i = 0; i < n; i++) {
			// top right
			for (int j = i; j <= z - i; j++) {
				System.out.printf("%d ", a[i][j]);
			}
			// right down
			for (int j = i + 1; j <= z - i; j++) {
				int k = z - i;
				System.out.printf("%d ", a[j][k]);
			}
			// bottom left
			for (int j = z - i - 1; j >= i; j--) {
				int k = z - i;
				System.out.printf("%d ", a[k][j]);
			}
			// left up
			for (int j = z - 1 - i; j >= i + 1; j--) {
				int k = i;
				System.out.printf("%d ", a[j][k]);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] m = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		printMatrix(5, m);
		System.out.println();
		printMatrix2(5, m);
	}

}
