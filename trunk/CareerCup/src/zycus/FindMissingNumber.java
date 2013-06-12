package zycus;

public class FindMissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		xor1();
		// xor2();
		// sum();
		xor3();
		search(new int[] { 0, 1, 3, 4, 5, 6, 7 });
	}

	public static void search(int[] arr) {
		System.out.println(binarySearch(arr, 0, arr.length));
	}

	public static int binarySearch(int[] arr, int left, int right) {

		if (right - left <= 0) {
			return arr[right] - 1;
		}
		int midIndex = (left + right) / 2;
		System.out.println(midIndex + " : " + arr[midIndex]);
		if (arr[midIndex] != midIndex) {
			// take left
			System.out.println("LEFT");
			return binarySearch(arr, left, midIndex);
		} else {
			// take right
			System.out.println("RIGHT");
			return binarySearch(arr, midIndex + 1, right);
		}
	}

	public static void sum() {

		int[] arr = { 1, 2, 3, 5 };
		// sum = n*(n+1)/2
		int sum = 5 * (5 + 1) / 2;
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
		}
		System.out.println(sum);
	}

	public static void xor1() {

		int[] arr = { 1, 2, 3, 5 };
		int x1 = arr[0] ^ arr[1];
		int x2 = 1;
		for (int i = 2; i <= 5; i++) {
			if (i < arr.length) {
				x1 ^= arr[i];
			}
			x2 ^= i;
		}
		System.out.println(x2 ^ x1);
	}

	public static void xor2() {

		int[] arr = { 1, 2, 3, 5 };
		System.out.println("Beginning: " + Integer.toBinaryString(0));
		int x1 = 0 ^ arr[0];
		int temp = x1;
		System.out.println("0 (" + appendZero(Integer.toBinaryString(0)) + ") ^ " + arr[0] + " ("
				+ appendZero(Integer.toBinaryString(arr[0])) + ") = " + x1 + " ("
				+ appendZero(Integer.toBinaryString(x1)) + ")");
		for (int i = 1; i <= 5; i++) {
			System.out
					.println("_______________________________________________________________________________________");
			if (i < arr.length) {
				x1 ^= arr[i];
				System.out.println(temp + " (" + appendZero(Integer.toBinaryString(temp)) + ") ^ " + arr[i] + " ("
						+ appendZero(Integer.toBinaryString(arr[i])) + ") = " + x1 + " ("
						+ appendZero(Integer.toBinaryString(x1)) + ")");
				temp = x1;
			}
			x1 ^= i;
			System.out.println(temp + " (" + appendZero(Integer.toBinaryString(temp)) + ") ^ " + i + " ("
					+ appendZero(Integer.toBinaryString(i)) + ") = " + x1 + " ("
					+ appendZero(Integer.toBinaryString(x1)) + ")");
			temp = x1;
		}
		System.out.println(x1);
	}

	public static void xor3() {

		int[] arr = { 1, 2, 3, 5, 6, 7 };
		int x1 = 1;
		for (int i = 1; i <= 7; i++) {
			if (i < arr.length) {
				x1 ^= arr[i] ^ i;
			} else {
				x1 ^= i;
			}
		}
		System.out.println("result: " + x1);
	}

	private static String appendZero(String s) {

		int diff = 4 - s.length();
		for (int i = 0; i < diff; i++) {
			s = "0" + s;
		}
		return s;
	}
}
