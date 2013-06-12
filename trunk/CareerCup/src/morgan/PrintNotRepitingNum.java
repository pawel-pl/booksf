package morgan;

public class PrintNotRepitingNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 3, 3, 3, 3, 4, 4, 4, 4, 4, 6, 8, 10, 17, 34 };
		int[] b = { 2, 8, 17, 33, 44, 66, 89, 100, 123 };

		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				System.out.print(a[i] + " ");
				i++;
			} else if (b[j] < a[i]) {
				System.out.print(b[j] + " ");
				j++;
			} else {
				i++;
				j++;
			}
			while (i < a.length && i != 0 && a[i] == a[i - 1]) {
				i++;
			}
			while (j < b.length && j != 0 && b[j] == b[j - 1]) {
				j++;
			}
		}

		while (i < a.length) {
			System.out.print(a[i] + " ");
			i++;
		}
		while (j < b.length) {
			System.out.print(b[j] + " ");
			j++;
		}
	}

}
