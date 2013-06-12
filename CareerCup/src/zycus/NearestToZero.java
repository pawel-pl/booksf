package zycus;

import static java.lang.Math.abs;

public class NearestToZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(findNearestToZero(new int[] { -3, 2, -3, 0, -2, 5, 7 }));
	}

	public static int findNearestToZero(int[] a) {

		int retval = a[0], mindist = abs(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (abs(a[i]) > mindist || a[i] == 0)
				continue;
			if (abs(a[i]) == mindist && a[i] > 0)
				retval = a[i];
			else {
				mindist = abs(a[i]);
				retval = a[i];
			}
		}

		return retval;
	}
}
