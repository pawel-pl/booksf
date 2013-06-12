package walmart;

import java.util.Arrays;

public class FindTripletInAr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 5, 1, 6, 1, 1, 7 };
		int[] a2 = { 6, 7, 3, 4, 8 };
		triplet(a2);

	}

	public static void triplet(int[] a) {

		int[] triplet = new int[3];
		int min = triplet[0] = a[0];
		triplet[1] = triplet[2] = Integer.MAX_VALUE;

		for (int i = 1; i < a.length; i++) {
			if (a[i] <= min)
				min = a[i];
			else if (a[i] <= triplet[1]) {
				triplet[0] = min;
				triplet[1] = a[i];
			} else {
				triplet[2] = a[i];
				System.out.println("T1: " + Arrays.toString(triplet));
				break;
			}
		}
	}
}
