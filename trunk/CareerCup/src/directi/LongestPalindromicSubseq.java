package directi;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * http://wcipeg.com/wiki/Longest_palindromic_subsequence
 * 
 * it equals with finding the longest common subsequence between one word (e.g. XAYBZBA) and its reverse (e.g. ABZBYAX).
 */
public class LongestPalindromicSubseq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String seq = "BBABCBCAB";
		System.out.printf("The lnegth of the LPS is %d", lps(seq));
	}

	// Returns the length of the longest palindromic subsequence in seq
	public static int lps(String s) {
		
		int n = s.length();
		char[] str = s.toCharArray();
		int i, j, cl;
		int[][] L = new int[n][n]; // Create a table to store results of
									// subproblems

		// Strings of length 1 are palindrome of lentgh 1
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		// Build the table. Note that the lower diagonal values of table are
		// useless and not filled in the process. The values are filled in a
		// manner similar to Matrix Chain Multiplication DP solution (See
		// http://www.geeksforgeeks.org/archives/15553). cl is length of
		// substring
		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (str[i] == str[j] && cl == 2)
					L[i][j] = 2;
				else if (str[i] == str[j])
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
				
				System.out.println("i: "+i+", j:  "+j+", len: "+cl);
				printMatrix(L);
				System.out.println();
			}
		}
		return L[0][n - 1];
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
