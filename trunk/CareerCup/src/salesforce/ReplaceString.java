package salesforce;

import java.util.Arrays;

public class ReplaceString {

	public static void main(String[] args) {
		replace("i am chandu", "ABC", ' ');
	}

	public static void replace(String str, String replacer, char ch) {

		char[] input = str.toCharArray();
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == ch) {
				count++;
			}
		}
		char[] output = new char[input.length + count * (replacer.length() - 1)];
		System.arraycopy(input, 0, output, 0, input.length);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(output));
		int j = output.length - 1;
		for (int i = input.length - 1; i >= 0; i--) {
			if (output[i] == ch) {
				for (int k = replacer.length() - 1; k >= 0; k--) {
					output[j--] = replacer.charAt(k);
				}
			} else {
				output[j--] = output[i];
			}
		}

		System.out.println(Arrays.toString(output));
	}
}
