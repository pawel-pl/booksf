package watchguard;

public class FactorialFactors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(factor(8));
		//factorial_factor(8);
	}

	public static int factor(int number) {
		
		int factor = 2;
		int total = 0;
		while (number > 1) {
			while (number % factor == 0) {
				total++;
				number /= factor;
			}
			factor++;
		}
		return total;
	}

	public static void factorial_factor(int number) {
		number = number > 0 ? number : -1 * number;
		int total = 0;
		for (int i = number; i > 1; i--) {
			total += factor(i);
		}
		System.out.println("total = " + total);
	}
}
