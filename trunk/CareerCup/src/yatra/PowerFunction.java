package yatra;

//especially for the case when y is of the form 2^n.
public class PowerFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int x = 3;
		int y = 4;

		int i = 1;
		while (i < y) {
			x *= x;
			i *= 2;
		}
		System.out.println(x);
	}

}
