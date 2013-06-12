package qualcomm;

import java.util.Arrays;

public class MaxOneDiff {

	public static void main(String[] args) {
		
		int k = 3;
		printNumber(k, new int[k], 0);
	}

	public static void printNumber(int k, int[] result, int index) {

		for (int i = 1; i <= k; i++) {

			if (index > 0 && Math.abs((i - result[index - 1])) > 1) {
				continue;
			}
			result[index] = i;
			if (index == k - 1) {
				System.out.println(Arrays.toString(result));
			} else {
				printNumber(k, result, index + 1);
			}
		}
	}

}
