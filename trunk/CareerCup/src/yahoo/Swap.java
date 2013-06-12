package yahoo;

public class Swap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		swapTemp(3, 5);
		swapArytmetic(3, 5);
		swapXOR(3, 5);
	}

	public static void swapArytmetic(int a, int b) {

		System.out.println("a: " + a + ", b: " + b);
		a = (a + b) - (b = a);
		System.out.println("a: " + a + ", b: " + b);
	}

	public static void swapXOR(int a, int b) {

		System.out.println("a: " + a + ", b: " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a: " + a + ", b: " + b);
	}

	public static void swapTemp(int a, int b) {

		System.out.println("a: " + a + ", b: " + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a: " + a + ", b: " + b);
	}
}
