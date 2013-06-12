package common;

public class Test {

	public static void main(String[] args) {

		findPalindrom();
	}

	private static void findPalindrom() {

		boolean found = false;
		int l = 3;
		/*
		 * for (int i = 997; i >= 100; i--) { char[] j = new char[2 * l];
		 * System.arraycopy(String.valueOf(i).toCharArray(), 0, j, 0, l); j[3] =
		 * j[2]; j[4] = j[1]; j[5] = j[0]; int x = Integer.parseInt(new
		 * String(j));
		 * 
		 * System.out.println(x + " -> " + limit);
		 */
		int limit = (int) Math.sqrt(906609);
		System.out.println(906609 + " -> " + limit);
		// First one that has two three digit factors
		for (int z = limit; z >= 100; z--) {
			System.out.println(z + " -> " + 906609 / z);
			if (906609 % z == 0) {
				System.out.println(906609 + " --> " + z + " --> " + 906609 / z);
				found = true;
				// break;
			}
		}
		/*
		 * if (found) break; }
		 */
	}
}
