package magma;

/*
 * http://www.ibm.com/developerworks/library/j-seqalign/
 * http://www.columbia.edu/~cs2035/courses/csor4231.F11/lcs.pdf
 */
public class LongestCommonSubsequenceDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "GCCCTAGCG";
		String s2 = "GCGCAATG";
		lcs2(s1, s2);
		System.out.println();
		lcs(s2, s1);
		// System.out.println(lcs("ABC", "ABCDEF"));
		// System.out.println(lcs("ABCDEF", "ACEG"));
		// System.out.println(lcs("ABCDEF", "ZACYEFX"));
	}

	public static void lcs2(String s1, String s2) {

		char[][] a = new char[s2.length() + 2][s1.length() + 2];
		StringBuilder sb = new StringBuilder();
		a[1][1] = (char) (0 + '0');
		for (int i = 2; i < a.length; i++) {
			a[i][0] = s2.charAt(i - 2);
			a[i][1] = (char) (0 + '0');
		}
		for (int i = 2; i < a[0].length; i++) {
			a[0][i] = s1.charAt(i - 2);
			a[1][i] = (char) (0 + '0');
		}
		int v;
		for (int i = 2; i < s2.length() + 2; i++) {
			for (int j = 2; j < s1.length() + 2; j++) {
				if (a[0][j] == a[i][0]) {
					v = (int) (a[i - 1][j - 1] - '0') + 1;
				} else {
					v = (int) (a[i - 1][j - 1] - '0');
				}
				a[i][j] = (char) (Math.max(v, Math.max((int) (a[i - 1][j] - '0'), (int) (a[i][j - 1] - '0'))) + '0');
			}
		}
		printMatrix(a);
		int i = a.length - 1;
		int j = a[0].length - 1;
		while (i > 1 && j > 1) {
			if (a[i][j] == a[i - 1][j]) {
				i--;
			} else if (a[i][j] == a[i][j - 1]) {
				j--;
			} else {
				sb.append(s2.charAt(i - 2));
				i--;
				j--;
			}
		}
		System.out.println(sb.reverse() + ", " + a[a.length - 1][a[0].length - 1]);
	}

	private static void printMatrix(char[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void printMatrix(int[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void lcs(String a, String b) {

		int[][] lengths = new int[a.length() + 1][b.length() + 1];
		// row 0 and column 0 are initialized to 0 already
		for (int i = 0; i < a.length(); i++)
			for (int j = 0; j < b.length(); j++)
				if (a.charAt(i) == b.charAt(j))
					lengths[i + 1][j + 1] = lengths[i][j] + 1;
				else
					lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);

		// read the substring out from the matrix
		StringBuffer sb = new StringBuffer();
		int x = a.length(), y = b.length();
		while (x != 0 && y != 0) {
			if (lengths[x][y] == lengths[x - 1][y])
				x--;
			else if (lengths[x][y] == lengths[x][y - 1])
				y--;
			else {
				assert a.charAt(x - 1) == b.charAt(y - 1);
				sb.append(a.charAt(x - 1));
				x--;
				y--;
			}
		}
		printMatrix(lengths);
		System.out.println(sb.reverse().toString());
	}
}
