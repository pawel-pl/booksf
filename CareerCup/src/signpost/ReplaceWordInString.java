package signpost;

public class ReplaceWordInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(reverseReplace("Hello World cacats", "cats", "dogs"));
	}

	public static String reverseReplace(String str, String targeted, String replace) {
		int common_chars = 0;
		String Result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == targeted.charAt(common_chars)) {
				common_chars++;
				if (common_chars == targeted.length()) {
					Result += replace;
					common_chars = 0;
				}
			} else {
				if (common_chars != 0) {
					for (int j = common_chars; j > 0; j--) {
						Result += str.charAt(i - j);
					}
					common_chars = 0;
				}
				Result += str.charAt(i);
			}
		}
		return Result;
	}
}
