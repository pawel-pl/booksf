package denmin;

public class AlmostPrimeNumber {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			if (isAlmostPrimeNumber(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isAlmostPrimeNumber(int n) {

		if (isPrimeNumber(n)) {
			return false;
		}
		int sqrt = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= sqrt; i++) {
			if (n % i != 0) {
				continue;
			}
			if (!isPrimeNumber(i) || !isPrimeNumber(n / i)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPrimeNumber(int n) {

		if (n <= 3) {
			return true;
		}
		int sqrt = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
