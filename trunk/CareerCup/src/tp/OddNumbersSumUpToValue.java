package tp;

public class OddNumbersSumUpToValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 12, 2, 1, 4 };
		int sum = 1;
		System.out.println(findSum(arr, sum, 0, arr.length - 1));
	}

	public static boolean findSum(int[] arr, int sum, int count, int pos) {

		if (pos < 0 || sum < 0) {
			return false;
		}
		if (sum == 0 && count % 2 != 0) {
			return true;
		}

		return findSum(arr, sum - arr[pos], count + 1, pos - 1) || findSum(arr, sum, count, pos - 1);
	}

}
