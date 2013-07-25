package flipkart;

/*
 * http://topcoder.bgcoder.com/print.php?id=2086
 * http://red.cliff.jp/topcoder/RoughStrings.txt
 */
public class RoughStrings {

    boolean check(int r, int[] am, int n, int len) {

	for (int min = 1; min <= len; min++) {
	    int max = r + min;
	    int need = 0;
	    for (int i = 0; i < 26; i++) {
		if (am[i] < min) {
		    need += am[i];
		} else if (am[i] > max) {
		    need += am[i] - max;
		}
	    }
	    if (need >= 0 && need <= n) {
		return true;
	    }
	}
	return false;
    }

    public int minRoughness(String s, int n) {

	int[] am = new int[26];
	int len = s.length();
	for (int i = 0; i < len; i++) {
	    am[s.charAt(i) - 'a']++;
	}
	int left = -1;
	int right = len;
	while (left + 1 < right) {
	    int mid = (left + right) / 2;
	    if (check(mid, am, n, len)) {
		right = mid;
	    } else {
		left = mid;
	    }
	}
	return left + 1;
    }

    public static void main(String[] args) {

	int[] noOfRemoves = { 1, 5, 1, 5, 17, 2 };
	String[] s = { "aaaaabbc", "aaaabbbbc", "veryeviltestcase", "gggggggooooooodddddddllllllluuuuuuuccckkk",
		"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", "bbbccca" };
	for (int i = 0; i < s.length; i++) {
	    System.out.println(new RoughStrings().minRoughness(s[i], noOfRemoves[i]));
	}
    }
}
