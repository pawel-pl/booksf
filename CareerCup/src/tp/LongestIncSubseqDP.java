package tp;

import java.util.Arrays;

/*
 * http://professorjava.weebly.com/longest-increasing-subsequence.html
 */
public class LongestIncSubseqDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		increasingSubsequence(a);
	}

	// for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}
	public static void increasingSubsequence(int[] seq) {

		int[] L = new int[seq.length];
		L[0] = 1;
		for (int i = 1; i < L.length; i++) {
			int maxn = 0;
			for (int j = 0; j < i; j++) {
				if (seq[j] < seq[i] && L[j] > maxn) {
					maxn = L[j];
				}
			}
			L[i] = maxn + 1;
		}
		
		int maxi = 0;
		for (int i = 0; i < L.length; i++) {
			if (L[i] > maxi) {
				maxi = L[i];
			}
		}
		System.out.println(Arrays.toString(seq));
		System.out.println(Arrays.toString(L));
		System.out.println(maxi);
	}
}
