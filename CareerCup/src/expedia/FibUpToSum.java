package expedia;

public class FibUpToSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(fib(25, 0, 1));
	}

	public static int fib(int sum, int num1, int num2) {

		if (sum == 0) {
			return 0;
		}
		if (sum == 1) {
			return 1;
		}
		num1 += num2;
		if (num1 > sum) {
			return num2;
		}

		return fib(sum, num2, num1);
	}
}
