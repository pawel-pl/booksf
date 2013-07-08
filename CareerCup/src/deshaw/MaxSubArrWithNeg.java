package deshaw;

public class MaxSubArrWithNeg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 2, -3, -4, 5, -2, -4 };
		int maxPositiveSum = 0;
		int maxPositiveStart = 0;
		int maxPositiveEnd = 0;
		int currentPositiveStart = 0;
		int currentPositiveSum = 0;

		int maxNegativeSum = 0;
		int maxNegativeStart = 0;
		int maxNegativeEnd = 0;
		int currentNegativeStart = 0;
		int currentNegativeSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currentPositiveSum += arr[i];
			currentNegativeSum += arr[i];
			if (currentPositiveSum < 0) {
				currentPositiveSum = 0;
				currentPositiveStart = i + 1;
			} else if (currentPositiveSum > maxPositiveSum) {
				maxPositiveSum = currentPositiveSum;
				maxPositiveStart = currentPositiveStart;
				maxPositiveEnd = i;
			}
			if (currentNegativeSum > 0) {
				currentNegativeSum = 0;
				currentNegativeStart = i + 1;
			} else if (Math.abs(currentNegativeSum) > maxNegativeSum) {
				maxNegativeSum = Math.abs(currentNegativeSum);
				maxNegativeStart = currentNegativeStart;
				maxNegativeEnd = i;
			}
		}
		if (Math.abs(maxNegativeSum) > maxPositiveSum) {
			System.out.println("Start: " + maxNegativeStart + ", Emd: " + maxNegativeEnd + ", Sum: "
					+ Math.abs(maxNegativeSum));
		} else {
			System.out.println("Start: " + maxPositiveStart + ", Emd: " + maxPositiveEnd + ", Sum: " + maxPositiveSum);
		}
	}
}
