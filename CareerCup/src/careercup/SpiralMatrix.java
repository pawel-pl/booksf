package careercup;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 4;
		fillMatrixIter(n);
		fillMatrixRec(n);
	}

	public static void fillMatrixIter(int n) {

		int[][] m = new int[n][n];
		int z = n - 1;
		int counter = 1;
		for (int i = 0; i <= z; i++) {
			for (int j = i; j <= z - i; j++) {
				m[i][j] = counter++;
			}
			for (int j = i + 1; j <= z - i; j++) {
				m[j][z - i] = counter++;
			}
			for (int j = z - i - 1; j >= i; j--) {
				m[z - i][j] = counter++;
			}
			for (int j = z - i - 1; j >= i + 1; j--) {
				m[j][i] = counter++;
			}
		}
		System.out.println();
	}

	public static void fillMatrixRec(int n) {

		int[][] m = new int[n][n];
		int z = n - 1;
		int counter = 1;
		fillMatrixRec(m, 0, z, counter);
	}

	public static void fillMatrixRec(int[][] m, int i, int z, int counter) {

		if (i > z) {
			System.out.println();
			return;
		}

		for (int j = i; j <= z - i; j++) {
			m[i][j] = counter++;
		}

		for (int j = i + 1; j <= z - i; j++) {
			m[j][z - i] = counter++;
		}

		for (int j = z - i - 1; j >= i; j--) {
			m[z - i][j] = counter++;
		}

		for (int j = z - i - 1; j >= i + 1; j--) {
			m[j][i] = counter++;
		}

		fillMatrixRec(m, i + 1, z, counter);
	}

}
