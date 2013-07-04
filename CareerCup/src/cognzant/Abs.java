package cognzant;

/*
 * graphics.stanford.edu/~seander/bithacks.html#IntegerAbs , is power of 2, find min max in 2 ints
 */
public class Abs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * int v; // we want to find the absolute value of v unsigned int r; //
		 * the result goes here int const mask = v >> sizeof(int) * CHAR_BIT -
		 * 1;
		 * 
		 * r = (v + mask) ^ mask;
		 */
		int x = -5;
		System.out.println(Math.sqrt(x*x));
		

	}

}
