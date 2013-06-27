package athena;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Replace2CharsWithThird {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "abbc";
		//String s = "aaac";
		//String s = "aaaa";
		Set<Character> uniqueChars = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			uniqueChars.add(s.charAt(i));
		}
		Stack<Character> stack = new Stack<Character>();
		int i = 1;
		Character newChar = s.charAt(0);
		while (i < s.length()) {
			if (stack.isEmpty() || stack.peek().equals(newChar)) {
				stack.push(newChar);
				newChar = s.charAt(i++);
			} else {
				Character top = stack.pop();
				for (Character unChar : uniqueChars) {
					if (!unChar.equals(top) && !unChar.equals(newChar)) {
						newChar = unChar;
						break;
					}
				}
			}
		}
		boolean change = true;
		while (change) {
			if (stack.isEmpty() || stack.peek().equals(newChar)) {
				stack.push(newChar);
				change = false;
			} else {
				Character top = stack.pop();
				for (Character unChar : uniqueChars) {
					if (!unChar.equals(top) && !unChar.equals(newChar)) {
						newChar = unChar;
						break;
					}
				}
			}
		}
		System.out.println(stack.size() + " - " + stack);
	}

}
