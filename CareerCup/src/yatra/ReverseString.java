package yatra;

import java.util.StringTokenizer;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		reverseWithToken("this   is a    string");
	}

	public static void reverseWithToken(String s) {

		StringTokenizer st = new StringTokenizer(s);
		int tokenCount = st.countTokens();
		String[] tokens = new String[tokenCount];
		for (int i = 0; i < tokenCount; i++) {
			tokens[i] = st.nextToken();
		}
		String newString = "";
		if (tokenCount != 0) {
			newString = tokens[tokenCount - 1];
		}
		for (int i = tokenCount - 2; i >= 0; i--) {
			newString += " " + tokens[i];
		}
		System.out.println(newString);
	}
	
	public static void reverseWithStack(String s) {

		StringTokenizer st = new StringTokenizer(s);
		int tokenCount = st.countTokens();
		String[] tokens = new String[tokenCount];
		for (int i = 0; i < tokenCount; i++) {
			tokens[i] = st.nextToken();
		}
		String newString = "";
		if (tokenCount != 0) {
			newString = tokens[tokenCount - 1];
		}
		for (int i = tokenCount - 2; i >= 0; i--) {
			newString += " " + tokens[i];
		}
		System.out.println(newString);
	}

}
