package epic;

import java.util.Arrays;

public class SeqFollowTheSameSeq {

	public static void main(String[] args) {

		// char[] s = "123123qs".toCharArray();
		// char[] s = "123qs123qs".toCharArray();
		char[] s = "1w23qs1a23qs".toCharArray();
		int[] latestIndex = new int[256];
		Arrays.fill(latestIndex, -1);
		int startOfSeq = -1;
		int startOfPrevSeq = -1;
		int seqLength = 0;
		for (int i = 0; i < s.length; i++) {
			if (latestIndex[s[i]] == -1) {
				latestIndex[s[i]] = i;
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
					if (startOfPrevSeq + seqLength == startOfSeq - 1) {
						System.out.println("False");
						return;
					} else {
						for (int j = startOfSeq; j < i; j++) {
							latestIndex[s[j]] = j;
						}
					}
				}
			}
		}
	}

}
