package cadence;

public class ProductWithoutLoopAndMulti {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = -2;
		int b = -4;
		if(a < 0 && b < 0) {
			a = Math.abs(a);
			b = Math.abs(b);
		} else if (b < 0) {
			int temp = a;
			a = b;
			b = temp;
		}
		int result = prod(a, b);
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
