package sap;

public class CompareStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(compareStrings("str2", "str2"));
	}

	// s1.compareTo(s2)
	public static boolean compareStrings(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		for (int i = 0; i < str1.length(); i++) {

			if (str1.charAt(i) < str2.charAt(i) || str2.charAt(i) < str1.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
