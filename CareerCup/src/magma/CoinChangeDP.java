package magma;

import java.util.Arrays;

public class CoinChangeDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3 };
		// int arr[] = { 2, 5, 3, 6 };
		int m = arr.length;
		System.out.printf("%d \n", count(arr, m, 5));
		System.out.printf("%d ", countDP(arr, m, 5));
		// System.out.printf("%d ", count(arr, m, 10));
	}

	public static int count(int S[], int m, int n) {
		
		// If n is 0 then there is 1 solution (do not include any coin)
		if (n == 0)
			return 1;

		// If n is less than 0 then no solution exists
		if (n < 0)
			return 0;

		// If there are no coins and n is greater than 0, then no solution exist
		if (m <= 0 && n >= 1)
			return 0;

		// count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}

	private static int countDP(int S[], int m, int n) {
		
		int i, j, x, y;

		// We need n+1 rows as the table is consturcted in bottom up manner
		// using
		// the base case 0 value case (n = 0)
		int[][] table = new int[n + 1][m];

		// Fill the enteries for 0 value case (n = 0)
		for (i = 0; i < m; i++)
			table[0][i] = 1;

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < n + 1; i++) {
			for (j = 0; j < m; j++) {
				// Count of solutions including S[j]
				x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

				// Count of solutions excluding S[j]
				y = (j >= 1) ? table[i][j - 1] : 0;

				// total count
				table[i][j] = x + y;
			}
		}
		for(i = 0 ; i < table.length ; i++) {
			System.out.println(Arrays.toString(table[i]));
		}
		return table[n][m - 1];
	}
}
