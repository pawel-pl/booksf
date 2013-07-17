package epic;

public class PrintWellOrderedPsw {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printWellOrdered(0, 0, 3);
		System.out.println("\n");
		genPsw(0, 1, 5);
	}

	private static void genPsw(int number, int start, int n) {

		if (n == 0) {
			System.out.println(number);
			return;
		}

		if (9 - start + 1 < n) {
			return;
		}
		for (int i = start; i <= 9; i++) {
			genPsw(number * 10 + i, i + 1, n - 1);
		}

	}

	private static void printWellOrdered(int number, int prev, int n) {

		if (n == 0) {
			System.out.println(number);
			return;
		}

		for (int i = (prev + 1); i < (11 - n); i++) {
			printWellOrdered(number * 10 + i, i, n - 1);
		}

	}
}
