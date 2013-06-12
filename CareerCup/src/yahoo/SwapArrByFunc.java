package yahoo;

import java.util.Arrays;

public class SwapArrByFunc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//int a[] = { 7, 8, 0, 9, 1, 2, 3, 4 };
		int a[] = { 5, 0, 6, 7, 8, 9, 10, 11 };
		int i = 0;
		int j = a.length - 1;

		while (i < j) {

			while (func(a[i])) {
				i++;
			}

			while (!func(a[j])) {
				j--;
			}
			if (i <= j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			}
		}

		System.out.println(Arrays.toString(a));
	}

	public static boolean func(int i) {

		if (i < 5) {
			return true;
		}

		return false;
	}

}
