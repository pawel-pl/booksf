package twitter;

import java.util.HashSet;
import java.util.Set;

public class IsertSpaceBeforeWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set<String> dictionary = new HashSet<String>();
		dictionary.add("google");
		dictionary.add("is");
		dictionary.add("awesome");
		StringBuilder sb = new StringBuilder("isgoogleawesome");
		printWords("isgoogleawesome", 0, sb, dictionary);
		System.out.println(sb);
		sb = new StringBuilder("isgoogleawesome");
		printWords2(sb, dictionary);
	}

	public static boolean printWords(String string, int beginIndex, StringBuilder sb, Set<String> dictionary) {

		if (string.length() == beginIndex) {
			return true;
		}
		for (int i = beginIndex + 1; i <= string.length(); ++i) {
			String curWord = string.substring(beginIndex, i);
			if (dictionary.contains(curWord) && printWords(string, i, sb, dictionary)) {
				if (i < string.length()) {
					sb.insert(i, ' ');
				}
				return true;
			}
		}
		return false;
	}

	public static void printWords2(StringBuilder sb, Set<String> dict) {

		StringBuilder currentWord = new StringBuilder();
		for (int i = sb.length() - 1; i >= 0; i--) {
			currentWord.insert(0, sb.charAt(i));
			if (dict.contains(currentWord.toString()) && i != 0) {
				sb.insert(i, " ");
				currentWord.setLength(0);
			}
		}
		System.out.println(sb);
	}
}
