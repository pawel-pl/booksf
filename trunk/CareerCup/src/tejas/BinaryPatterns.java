package tejas;

class BinaryPatterns {

	static void printPatterns(String pattern, int m, int n) {

		if (m > 0) {
			printPatterns(pattern + '0', m - 1, n);
		}
		if (n > 0) {
			printPatterns(pattern + '1', m, n - 1);
		} else if (m == 0 && n == 0) {
			System.out.println(pattern);
		}
	}

	static void printPatternsSB(StringBuilder sb, int m, int n) {

		if (m > 0) {
			printPatternsSB(sb.append('0'), m - 1, n);
			sb.setLength(sb.length() - 1);
		}
		if (n > 0) {
			printPatternsSB(sb.append('1'), m, n - 1);
			sb.setLength(sb.length() - 1);
		} else if (m == 0 && n == 0) {
			System.out.println(sb);
		}
	}

	public static void main(String[] args) {
		// printPatterns("", 2, 2);
		printPatternsSB(new StringBuilder(), 2, 2);
	}
}
