package socialcam;

import java.util.Arrays;
import java.util.LinkedList;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

	// int[] X = { 8, 1, 5, 3, 8, 5, 9, 0, 1 };
	// int[] X = {8, 4, 1, 9, 2, 6, 1, 0, 1};
	int[] X = { 2, 3, 1, 4 };
	         // 1  2  3  4
	int[] Y = X.clone();
	Arrays.sort(Y);

	int[][] L = new int[X.length + 1][X.length + 1];
	int[][] B = new int[X.length + 1][X.length + 1];
	// For B, say 0 = Up, 1 = Left, 2 = UpLeft
	for (int i = 1; i <= X.length; i++) {
	    for (int j = 1; j <= Y.length; j++) {
		if (X[i - 1] == Y[j - 1]) {
		    L[i][j] = L[i - 1][j - 1] + 1;
		    B[i][j] = 2;
		} else if (L[i - 1][j] >= L[i][j - 1]) {
		    L[i][j] = L[i - 1][j];
		    B[i][j] = 0;
		} else {
		    L[i][j] = L[i][j - 1];
		    B[i][j] = 1;
		}
	    }
	}
	printMatrix(L);
	System.out.println();
	printMatrix(B);

	LinkedList<Integer> S = new LinkedList<Integer>();
	{
	    int i = X.length, j = Y.length;
	    while (i > 0 && j > 0) {
		if (B[i][j] == 2) {
		    S.addFirst(X[i - 1]);
		    i--;
		    j--;
		} else if (B[i][j] == 0) {
		    i--;
		} else {
		    j--;
		}
	    }
	}
	System.out.printf("Solution (%d): ", L[X.length][Y.length]);
	for (Integer i : S) {
	    System.out.printf("%d ", i);
	}
	System.out.println();

    }

    private static void printMatrix(int[][] m) {

	for (int i = 0; i < m.length; i++) {
	    for (int j = 0; j < m[0].length; j++) {
		System.out.print(" " + m[i][j]);
	    }
	    System.out.println();
	}
    }
}
