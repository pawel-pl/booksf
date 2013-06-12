package riverbed;

/*
 * http://stackoverflow.com/questions/3250957/finding-the-largest-palindrome-of-the-product-of-two-three-digit-numbers-problem
 */
public class PalindromicNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		findPalindrom();
		findPalindrom2();
	}

	private static void findPalindrom2() {

		boolean found = false;
		int l = 3;
		for (int i = 997; i >= 100; i--) {
			char[] j = new char[2 * l];
			System.arraycopy(String.valueOf(i).toCharArray(), 0, j, 0, l);
			j[3] = j[2];
			j[4] = j[1];
			j[5] = j[0];
			int x = Integer.parseInt(new String(j));
			// First one that has two three digit factors
			for (int z = 999; z >= 100; z--) {
				if (x % z == 0) {
					int secFactor = x / z;
					if (secFactor >= 100 && secFactor <= 999) {
						System.out.println(x + " --> " + z+" - "+secFactor);
						found = true;
						break;
					} else if (secFactor >= 1000) {
						break;	
					}
				}
			}
			if (found)
				break;
		}
	}

	private static void findPalindrom() {

		boolean found = false;
		int l = 3;
		for (int i = 997; i >= 100; i--) {
			char[] j = new char[2 * l];
			System.arraycopy(String.valueOf(i).toCharArray(), 0, j, 0, l);
			j[3] = j[2];
			j[4] = j[1];
			j[5] = j[0];
			int x = Integer.parseInt(new String(j));
			int limit = (int) Math.sqrt(x);
			//System.out.println(x + " -> " + limit);
			// First one that has two three digit factors
			for (int z = 999; z >= limit; z--) {
				if (x % z == 0) {
					System.out.println(x + " --> " + z);
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
	}
}
