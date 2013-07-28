package epic;

/*
 * Like snake - adjacent cells
 */
public class LIS2dArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] arr = { { 2, 3, 4, 5 }, { 4, 5, 10, 11 }, { 20, 6, 9, 12 }, { 6, 7, 8, 40 } };
		findLIS(arr);
	}

	public static void findLIS(int[][] m) {

		int[][] l = new int[m.length][m[0].length];
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[0].length; j++) {
				if (l[i][j] == 0) {
					fillCell(i, j, m, l);
				}
			}
		}

		int maxI = 0;
		int maxJ = 0;
		int maxLength = 0;
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[0].length; j++) {
				if (l[i][j] > maxLength) {
					maxI = i;
					maxJ = j;
					maxLength = l[i][j];
				}
			}
		}
		printMatrix(l);
		int i = maxI;
		int j = maxJ;
		while (maxLength > 0) {
			System.out.print(m[i][j] + " ");
			maxLength -= 1;
			if (j - 1 >= 0 && l[i][j - 1] == maxLength && m[i][j - 1] == m[i][j] + 1) {
				j--;
				continue;
			}
			if (j + 1 < m[0].length && l[i][j + 1] == maxLength && m[i][j + 1] == m[i][j] + 1) {
				j++;
				continue;
			}
			if (i - 1 >= 0 && l[i - 1][j] == maxLength && m[i - 1][j] == m[i][j] + 1) {
				i--;
				continue;
			}
			if (i + 1 < m.length && l[i + 1][j] == maxLength && m[i + 1][j] == m[i][j] + 1) {
				i++;
				continue;
			}
		}
	}

	public static int fillCell(int i, int j, int[][] m, int[][] l) {

		if (i < 0 || j < 0 || i >= m.length || j >= m[0].length) {
			return 0;
		}
		if (l[i][j] != 0) {
			return l[i][j];
		}
		int left = 0;
		int right = 0;
		int up = 0;
		int down = 0;
		if (j - 1 >= 0 && m[i][j - 1] == m[i][j] + 1) {
			left = fillCell(i, j - 1, m, l);
		}
		if (j + 1 < m[0].length && m[i][j + 1] == m[i][j] + 1) {
			right = fillCell(i, j + 1, m, l);
		}
		if (i - 1 >= 0 && m[i - 1][j] == m[i][j] + 1) {
			up = fillCell(i - 1, j, m, l);
		}
		if (i + 1 < m.length && m[i + 1][j] == m[i][j] + 1) {
			down = fillCell(i + 1, j, m, l);
		}
		l[i][j] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;

		return l[i][j];
	}
	
	    private static void printMatrix(int[][] m) {

		for (int i = 0; i < m.length; i++) {
		    for (int j = 0; j < m[0].length; j++) {
			System.out.print(m[i][j] + " ");
		    }
		    System.out.println();
		}
	    }
}
