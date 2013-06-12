package magma;

public class LongestIncreasingSubSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int maxLength = 1, bestEnd = 0;
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int[] DP = new int[arr.length];
		DP[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			DP[i] = 1;
			for (int j = i - 1; j >= 0; j--)
				if (DP[j] + 1 > DP[i] && arr[j] < arr[i]) {
					DP[i] = DP[j] + 1;
					// prev[i] = j;
				}

			if (DP[i] > maxLength) {
				bestEnd = i;
				maxLength = DP[i];
			}
		}

		System.out.println(bestEnd + ", " + maxLength);
	}

}
