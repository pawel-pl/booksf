package adobe;

public class SnakeSeq {

    public static void main(String[] args) {

	int[][] arr = { { 1, 3, 2, 6, 8 }, { -9, 7, 1, -1, 2 }, { 1, 5, 0, 1, 9 } };
	findSnakeSeq(arr);
    }

    public static void findSnakeSeq(int[][] m) {

	int[][] l = new int[m.length][m[0].length];
	int maxLength = 0;
	for (int i = 0; i < l.length; i++) {
	    for (int j = 0; j < l[0].length; j++) {
		if (l[i][j] == 0) {
		    int res = fillSeqLength(i, j, m, l);
		    if (res > maxLength) {
			maxLength = res;
		    }
		}
	    }
	}
	printMatrix(l);
	printSequences(m, l, maxLength);
    }

    public static int fillSeqLength(int i, int j, int[][] m, int[][] l) {

	if (i < 0 || j < 0 || i >= m.length || j >= m[0].length) {
	    return 0;
	}
	if (l[i][j] != 0) {
	    return l[i][j];
	}
	int right = 0;
	int down = 0;
	if (j + 1 < m[0].length && (m[i][j + 1] == m[i][j] + 1 || m[i][j + 1] == m[i][j] - 1)) {
	    right = fillSeqLength(i, j + 1, m, l);
	}
	if (i + 1 < m.length && (m[i + 1][j] == m[i][j] + 1 || m[i + 1][j] == m[i][j] - 1)) {
	    down = fillSeqLength(i + 1, j, m, l);
	}
	l[i][j] = Math.max(right, down) + 1;

	return l[i][j];
    }

    public static void printSequences(int[][] m, int[][] l, int maxLength) {

	for (int i = 0; i < l.length; i++) {
	    for (int j = 0; j < l[0].length; j++) {
		if (l[i][j] == maxLength) {
		    printSequences(m, l, i, j, maxLength);
		}
	    }
	}

    }

    public static void printSequences(int[][] m, int[][] l, int i, int j, int maxLength) {

	while (maxLength > 0) {
	    System.out.print(m[i][j] + " ");
	    maxLength -= 1;
	    if (j + 1 < m[0].length && l[i][j + 1] == maxLength
		    && (m[i][j + 1] == m[i][j] + 1 || m[i][j + 1] == m[i][j] - 1)) {
		j++;
		continue;
	    }
	    if (i + 1 < m.length && l[i + 1][j] == maxLength
		    && (m[i + 1][j] == m[i][j] + 1 || m[i + 1][j] == m[i][j] - 1)) {
		i++;
		continue;
	    }
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
}
