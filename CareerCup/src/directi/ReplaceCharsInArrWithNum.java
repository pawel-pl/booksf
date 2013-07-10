package directi;

import java.util.Arrays;

public class ReplaceCharsInArrWithNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] chars = { 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd', 'd', 'e', 'e' };
//		char[] chars = { 'a', 'b', 'c' };
		int count = 1;
		char currentChar = chars[0];
		int tail = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == currentChar) {
				count++;
				continue;
			}
			if (count > 1) {
				chars[tail++] = (char) (count + '0');
			}
			chars[tail++] = chars[i];
			currentChar = chars[i];
			count = 1;
		}
		if (count > 1) {
			chars[tail++] = (char) (count + '0');
		}
		Arrays.fill(chars, tail, chars.length, ' ');
		System.out.println(Arrays.toString(chars));
	}

}
