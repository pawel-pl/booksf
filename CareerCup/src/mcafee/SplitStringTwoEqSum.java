package mcafee;

public class SplitStringTwoEqSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "986561517416921217551395112859219257312";
		// String s = "123321";
		char[] arr = s.toCharArray();
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = (int) (arr[0] - '0');
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = (int) (arr[i] - '0') + prefixSum[i - 1];
		}
		int halfLength = arr.length / 2;
		int sum = 0;
		int begOfSecHalf;
		outer: while (halfLength > 0) {
			begOfSecHalf = halfLength;
			for (int begOfFirstHalf = 0; begOfSecHalf + halfLength - 1 < arr.length; begOfFirstHalf++, begOfSecHalf = begOfFirstHalf
					+ halfLength) {
				int sumLeft;
				if (begOfFirstHalf == 0) {
					sumLeft = prefixSum[halfLength - 1];
				} else {
					sumLeft = prefixSum[begOfFirstHalf + halfLength - 1] - prefixSum[begOfFirstHalf - 1];
				}
				int sumRight = prefixSum[begOfSecHalf + halfLength - 1] - prefixSum[begOfSecHalf - 1];
				sum = sumRight - sumLeft;
				if (sum == 0) {
					break outer;
				}
			}
			halfLength--;
		}
		if (sum == 0) {
			System.out.println(halfLength * 2);
		} else {
			System.out.println("00");
		}
	}

}
