package roxar;

public class NaturalSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "A11B";
		String s2 = "A11B";
		System.out.println(compare(s1, s2));
	}

	public static int compare(String s1, String s2) {

		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (isDigit(s1.charAt(i)) && isDigit(s2.charAt(j))) {
				StringBuilder sumS1 = new StringBuilder().append(s1.charAt(i++));
				StringBuilder sumS2 = new StringBuilder().append(s2.charAt(j++));
				while (i < s1.length() && isDigit(s1.charAt(i))) {
					sumS1.append(s1.charAt(i++));
				}
				while (j < s2.length() && isDigit(s2.charAt(j))) {
					sumS2.append(s2.charAt(j++));
				}
				int result = Integer.valueOf(sumS1.toString()).compareTo(Integer.valueOf(sumS2.toString()));
				if (result != 0) {
					return result;
				}
			} else {
				int result = new Character(s1.charAt(i++)).compareTo(new Character(s2.charAt(j++)));
				if (result != 0) {
					return result;
				}
			}
		}

		if (j == s2.length() && i == s1.length()) {
			return 0;
		} else if (j == s2.length()) { // s1 is bigger
			return 1;
		}

		return -1; // s2 is bigger
	}

	private static boolean isDigit(char ch) {

		if ('0' <= ch && ch <= '9') {
			return true;
		}
		return false;
	}
}
