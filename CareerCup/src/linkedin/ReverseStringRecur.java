package linkedin;

public class ReverseStringRecur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "This is a test";
		System.out.println(reverse(s, 0));
	}

	public static String reverse(String str, int pos) {

		if (pos == str.length()) {
			return "";
		}
		return reverse(str, pos + 1) + str.substring(pos, pos + 1);
	}

}
