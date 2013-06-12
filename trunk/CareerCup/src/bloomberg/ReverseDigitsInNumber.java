package bloomberg;

public class ReverseDigitsInNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int num = 123456;
		int result = 0;
		while (num > 0) {
			result = result * 10 + num % 10;
			int numOfTens = 0;
			while (num > 10) {
				num -= 10;
				numOfTens++;
			}
			num = numOfTens;
		}
		System.out.println(result);
	}

}
