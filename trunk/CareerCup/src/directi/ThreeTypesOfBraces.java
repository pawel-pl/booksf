package directi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ThreeTypesOfBraces {

	public static String left = "([{";
	public static String right = ")]}";

	public static void main(String[] args) {

//		String s = "[](){}";
//		String s = "()[{}]";
//		String s = "(){[}]";
//		String s = "({[])}";
		String s = "([)}}]";
		createBraces(s);
	}

	public static void createBraces(String s) {

		StringBuilder formated = new StringBuilder();
		Stack<Character> leftBrackets = new Stack<Character>();
		Deque<Character> rightBrackets = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			Character currentChar = s.charAt(i);
			if (left.indexOf(currentChar) != -1) {
				if (!rightBrackets.isEmpty() && isBracketEqual(currentChar, rightBrackets.peekFirst())) {
					formated.append(currentChar);
					formated.append(rightBrackets.removeFirst());
				} else {
					leftBrackets.push(currentChar);
				}
			} else {
				if (!leftBrackets.isEmpty() && isBracketEqual(leftBrackets.peek(), currentChar)) {
					formated.append(leftBrackets.pop());
					formated.append(currentChar);
				} else {
					rightBrackets.addFirst(currentChar);
				}
			}
		}
		if (rightBrackets.isEmpty() || leftBrackets.isEmpty()) {
			System.out.println(formated);
			return;
		}

		while (!leftBrackets.isEmpty() && !rightBrackets.isEmpty()) {
			int i = 0;
			Character leftBracket = leftBrackets.pop();
			while (i < rightBrackets.size() && !isBracketEqual(leftBracket, rightBrackets.peekFirst())) {
				rightBrackets.addLast(rightBrackets.removeFirst());
				i++;
			}
			if (i != rightBrackets.size()) {
				formated.append(leftBracket);
				formated.append(rightBrackets.removeFirst());
			}
			
		}
		System.out.println(formated);
	}

	public static boolean isBracketEqual(Character l, Character r) {

		return left.indexOf(l) == right.indexOf(r);
	}
}
