package flipkart;

/*
 * http://topcoder.bgcoder.com/print.php?id=2086
 * http://red.cliff.jp/topcoder/RoughStrings.txt
 * http://apps.topcoder.com/forums/?module=Thread&threadID=608083&mc=32&view=threaded
 */
public class RoughStrings {

	boolean check(int r, int[] freq, int n, int len) {

		for (int min = 1; min <= len; min++) {
			int max = r + min;
			int need = 0;
			boolean isMin = false;
			boolean isMax = false;
			for (int i = 0; i < 26; i++) {
				if (freq[i] == 0) {
					continue;
				}
				if (freq[i] == min) {
					isMin = true;
				} else if (freq[i] == max) {
					isMax = true;
				}else if (freq[i] < min) { //9 8 1 - remove one
					need += freq[i];
				} else if (freq[i] > max) {
					need += freq[i] - max;
				}
				if (isMax && isMin) {
					return true;
				}
			}
			if (need <= n) {
				return true;
			}
		}
		return false;
	}

	public int minRoughness(String s, int n) {

		int[] freq = new int[26];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			freq[s.charAt(i) - 'a']++;
		}
		int left = 0;
		int right = len;
		while (left < right) {
			int mid = (left + right) / 2;
			if (check(mid, freq, n, len)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {

		int[] noOfRemoves = { 1, 5, 1, 5, 17, 2 };
		String[] s = { "aaaaabbc", "aaaabbbbc", "veryeviltestcase",
				"gggggggooooooodddddddllllllluuuuuuuccckkk",
				"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", "bbbccca" };
		for (int i = 0; i < 1; i++) {
			System.out.println(new RoughStrings().minRoughness(s[i],
					noOfRemoves[i]));
		}
	}
}
