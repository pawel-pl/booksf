package urban;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * http://stackoverflow.com/questions/1507780/searching-for-a-sequence-of-bytes-in-a-binary-file-with-java
 * http://www.cs.utexas.edu/~eberlein/cs337/KMPEx.pdf
 * http://jqyblogger.blogspot.fi/2012/08/sample-java-code-for-kmp-algorithm.html
 * http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
 * http://en.wikipedia.org/wiki/Substring
 * http://dev-faqs.blogspot.fi/2010/05/knuth-morris-pratt-algorithm.html
 */
public class KmpSubStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    	System.out.println(Arrays.toString(computeFailure("AABAAC")));
		// System.out.println(Arrays.toString(computeFailure("ABCDABD")));
		//System.out.println(Arrays.toString(computeFailure("AABAACAABAA")));
		//System.out.println(Arrays.toString(computeKmpPrefix("AABAACAABAA")));
		/*
		 * System.out.println();
		 * System.out.println(Arrays.toString(computeFailure("ABCDE")));
		 * //System.out.println(Arrays.toString(computeKmpPrefix("ABCDE")));
		 * System.out.println();
		 * System.out.println(Arrays.toString(computeFailure("AAAAA")));
		 * //System.out.println(Arrays.toString(computeKmpPrefix("AAAAA")));
		 * System.out.println();
		 * System.out.println(Arrays.toString(computeFailure("AAABAAA")));
		 * //System.out.println(Arrays.toString(computeKmpPrefix("AAABAAA")));
		 * System.out.println();
		 * System.out.println(Arrays.toString(computeFailure("AAACAAAAAC")));
		 * //System
		 * .out.println(Arrays.toString(computeKmpPrefix("AAACAAAAAC")));
		 */System.out.println();
	}

	public int indexOf(String data, String pattern) {

		int[] failure = computeFailure(pattern);

		int j = 0;
		if (data.length() == 0)
			return -1;

		for (int i = 0; i < data.length(); i++) {
			while (j > 0 && pattern.charAt(j) != data.charAt(i)) {
				j = failure[j - 1];
			}
			if (pattern.charAt(j) == data.charAt(i)) {
				j++;
			}
			if (j == pattern.length()) {
				return i - pattern.length() + 1;
			}
		}
		return -1;
	}

	//For the pattern “AABAACAABAA”, lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]
	public static int[] computeFailure(String pattern) {

		System.out.println(pattern);

		int j = 0; // prefix index
		int[] failure = new int[pattern.length()];

		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = failure[j - 1];
			}
			if (pattern.charAt(j) == pattern.charAt(i)) {
				j++;
			}
			failure[i] = j;
		}
		System.out.println(Arrays.toString(failure));
		
		return failure;
	}

	public static int[] computeKmpPrefix(String pattern) {

		int patternSize = pattern.length();
		int[] kmpPrefix = new int[patternSize];
		int prefixPos = 0;
		int suffixPos = 1;

		while (suffixPos < patternSize) {
			if (pattern.charAt(prefixPos) == pattern.charAt(suffixPos)) {
				kmpPrefix[suffixPos] = prefixPos + 1;
				prefixPos++;
				suffixPos++;
			} else if (prefixPos > 0) {// found some match
				prefixPos = kmpPrefix[prefixPos - 1];// backtrack for matching
														// // prefix e.g. //
														// aaaaabaaaaaa
			} else {
				kmpPrefix[suffixPos] = 0;
				suffixPos++;
			}
		}
		return kmpPrefix;
	}
}
