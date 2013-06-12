package zynga;

public class TeamNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] digits = { '1', '2', '3', '4' };
		int m = 3;
		boolean[] used = new boolean[digits.length];
		StringBuilder sb = new StringBuilder();
		buildTeamNames(digits, used, sb, m, 0);
	}

	public static void buildTeamNames(char[] digits, boolean[] used, StringBuilder sb, int m, int pos) {

		if (sb.length() == m) {
			System.out.println(sb.toString());
			return;
		}

		for (int i = 0; i < digits.length; i++) {
			if (used[i] || (pos == 1 && sb.charAt(0) > digits[i]) || (pos == 2 && sb.charAt(1) > digits[i])) {
				continue;
			}
			used[i] = true;
			sb.append(digits[i]);
			buildTeamNames(digits, used, sb, m, pos + 1);
			used[i] = false;
			sb.setLength(sb.length() - 1);
		}
	}
}
