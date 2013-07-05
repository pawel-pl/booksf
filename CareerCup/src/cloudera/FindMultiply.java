package cloudera;

/*
 * http://mathschallenge.net/library/number/number_of_divisors
 */
public class FindMultiply {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 12;
		printDivisors(n);
		System.out.println("*****************************");
		printDivisors2(n);
	}

	public static void printDivisors(int n) {

		System.out.println(n + " * " + 1);
		StringBuilder sb = new StringBuilder();
		printDivisors(n, sb, 1);
	}

	public static void printDivisors(int n, StringBuilder sb, int prev) {

		if (n < 2) {
			return;
		}
		int sqrt = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= sqrt; i++) {
			if (n % i != 0 || i < prev || n / i < i) { //for 6 2*2*3 not again 2*3*2
														// ... 1*2 not 2*1
				continue;
			}
			int r = n / i;
			if (sb.length() > 0) {
				sb.append(" * " + i + " * " + r);
			} else {
				sb.append(i + " * " + r);
			}
			System.out.println(sb);
			sb.setLength(sb.length() - 4);
			printDivisors(r, sb, i);
			if (sb.length() == 1) {
				sb.setLength(0);
			} else {
				sb.setLength(sb.length() - 4);
			}
		}
	}

	static void printDivisors2(int n) {
		System.out.println("1*" + n);
		printDivisors("", 1, n);
	}

	static void printDivisors(String prefix, int prev, int n) {
		if (n < 2)
			return;
		int s = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= s; i++) {
			if (n % i == 0) {
				if (i >= prev && n / i >= i) {
					System.out.println(prefix + i + "*" + n / i);
					printDivisors(prefix + i + "*", i, n / i);
				}
			}

		}
	}
}
