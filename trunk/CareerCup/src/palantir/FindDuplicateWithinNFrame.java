package palantir;

import java.util.HashSet;

public class FindDuplicateWithinNFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean findDuplicateWithinN(int[] array, int n) {

		HashSet<Integer> set = new HashSet<Integer>(n);

		for (int i = 0; i < array.length; i++) {

			// Duplicate found
			if (set.contains(array[i])) {
				return true;
			}

			// Always keep set size as n
			if (i >= n) {
				set.remove(array[i - n]);
			}
			set.add(array[i]);
		}

		return false;
	}

}
