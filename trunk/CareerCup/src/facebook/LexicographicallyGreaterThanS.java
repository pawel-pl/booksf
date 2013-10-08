package facebook;

import java.util.Arrays;

public class LexicographicallyGreaterThanS {

    /**
     * @param args
     */
    public static void main(String[] args) {

	String s = "bcd";
	System.out.println(countStrings(s.toCharArray(), 0, new char[s.length()], true));
    }

    public static int countStrings(char[] s, int pos, char[] res, boolean isPrevousSmaller) {

	if (pos == s.length) {
	    System.out.println(Arrays.toString(res));
	    return 1;
	}

	int count = 0;
	for (char ch = 'a'; ch <= 'z'; ch++) {
	    if (pos > 0 && ch == res[pos - 1]) {
		continue;
	    }
	    if (pos == 0 && ch == s[pos]) {
		isPrevousSmaller = false;
	    }
	    if (!isPrevousSmaller && ch > s[pos]) {
		break;
	    }

	    res[pos] = ch;
	    count += countStrings(s, pos + 1, res, isPrevousSmaller ? true : ch < s[pos]);
	}

	return count;
    }
}
