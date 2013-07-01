package cadence;

public class ProductWithoutLoopAndMulti {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = -2;
		int b = -4;
		int result = prod(Math.abs(a), Math.abs(b));
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
			result *= -1;
		}
		System.out.println(result);
	}

	public static int prod(int a, int b) {

		if (b == 0) {
			return 0;
		}
		if (b == 1) {
			return a;
		}

		return a + prod(a, b - 1);
	}

}
