package epic;

import java.util.Arrays;

public class SeqFollowTheSameSeq {

	public static void main(String[] args) {

		// char[] s = "123123qs".toCharArray();
		// char[] s = "123qs123qs".toCharArray();
		char[] s = "1w23qs1a2323qs".toCharArray();
		checkSeq("1w23qs1a2323qs");
		// isPasswordValid("123234");
		int[] latestIndex = new int[256];
		Arrays.fill(latestIndex, -1);
		int startOfSeq = -1;
		int startOfPrevSeq = -1;
		int seqLength = 0;
		for (int i = 0; i < s.length; i++) {
			if (latestIndex[s[i]] == -1) {
				latestIndex[s[i]] = i;
				if (startOfSeq != -1) {
					if (startOfPrevSeq + seqLength == startOfSeq) {
						System.out.println("Not valid");
						return;
					} else {
						for (int j = startOfSeq; j < i; j++) {
							latestIndex[s[j]] = j;
						}
					}
				}
				startOfSeq = -1;
				startOfPrevSeq = -1;
				seqLength = 0;
			} else {
				if (startOfSeq == -1) {
					startOfPrevSeq = latestIndex[s[i]];
					startOfSeq = i;
					seqLength = 1;
				} else if (s[startOfPrevSeq + seqLength] == s[i]) {
					seqLength++;
				} else {
					if (startOfPrevSeq + seqLength == startOfSeq) {
						System.out.println("Not valid");
						return;
					} else {
						for (int j = startOfSeq; j < i; j++) {
							latestIndex[s[j]] = j;
						}
						startOfSeq = -1;
						startOfPrevSeq = -1;
						seqLength = 0;
						i--;
					}
				}
			}
		}
		if (startOfSeq != -1) {
			if (startOfPrevSeq + seqLength == startOfSeq) {
				System.out.println("Not valid");
				return;
			}
		}
		System.out.println("Valid");
	}

	public static void checkSeq(String s) {

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				int secHalf = (j + i + 1) / 2;
				if (s.substring(i, secHalf).equals(s.substring(secHalf, j + 1))) {
					System.out.println("Not valid");
					return;
				}
			}
		}
	}

	public static void isPasswordValid(String pass) {
		boolean isPassword = true;
		if (pass.matches("(?=.*\\d)(?=.*[a-z]).{5,12}")) {
			for (int i = 0; i < pass.length(); i++) {
				for (int j = 1 + i; j - i <= pass.substring(i).length() / 2; j++) {
					if (pass.substring(i, j).equals(pass.substring(j, j + pass.substring(i, j).length()))) {
						isPassword = false;
						break;
					}
				}

				if (!isPassword)
					break;
			}
		} else {
			isPassword = false;
		}
		if (isPassword)
			System.out.println("Valid password");
		else
			System.out.println("Invalid password");
	}
}
