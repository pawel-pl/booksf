package directi;

public class CreateStringFromABCChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(createString(0, 0, new StringBuilder(), 5));
	}

	public static int createString(int aCount, int bCount, StringBuilder sb, int n) {

		if (sb.length() == n) {
			System.out.println(sb);
			return 1;
		}
		int aResult = 0;
		int bResult = 0;
		int cResult = 0;
		if (aCount < 2) {
			sb.append('a');
			aResult = createString(aCount + 1, bCount, sb, n);
			sb.setLength(sb.length() - 1);
		}
		if (bCount == 0) {
			sb.append('b');
			bResult = createString(0, bCount + 1, sb, n);
			sb.setLength(sb.length() - 1);
		}
		sb.append('c');
		cResult = createString(0, bCount, sb, n);
		sb.setLength(sb.length() - 1);
		return aResult + bResult + cResult;
	}
}
