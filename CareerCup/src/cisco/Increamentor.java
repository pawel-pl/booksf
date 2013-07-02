package cisco;

public class Increamentor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int x = 1;
		int y = 1;
		x = x++ + ++y; // y = 16 x = 21
		y = ++x + ++y; // y = 39  x = 22
		System.out.println(x + " " + y);

	}

}
