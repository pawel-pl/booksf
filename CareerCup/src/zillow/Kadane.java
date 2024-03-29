package zillow;

public class Kadane {

	public static void main(String[] args) {
		// int[] intArr = { 3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
		// int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		int[] intArr = { 3, -2, -2, 2, -1 };
		// int[] intArr={-6,-2,-3,-4,-1,-5,-5};
		findMaxSubArray(intArr);
		findMaxSum();
	}

	public static void findMaxSubArray(int[] inputArray) {

		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int maxSum = Integer.MIN_VALUE;

		int cumulativeSum = 0;
		int maxStartIndexUntilNow = 0;

		for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

			cumulativeSum += inputArray[currentIndex];

			if (cumulativeSum > maxSum) {
				maxSum = cumulativeSum;
				maxStartIndex = maxStartIndexUntilNow;
				maxEndIndex = currentIndex;
			} else if (cumulativeSum < 0) {
				maxStartIndexUntilNow = currentIndex + 1;
				cumulativeSum = 0;
			}
		}

		System.out.println("Max sum         : " + maxSum);
		System.out.println("Max start index : " + maxStartIndex);
		System.out.println("Max end index   : " + maxEndIndex);
	}

	public static void findMaxSum() {

		int[] numbers = { 2, 3, -2, -1, 10 };
		int max = 0;
		int currentMax = 0;
		for (int num : numbers) {
			currentMax = Math.max(0, currentMax + num);
			max = Math.max(max, currentMax);
		}
		System.out.println(max);
	}
}
