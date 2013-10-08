package cadence;

public class ProductWithoutLoopAndMulti {

    /**
     * @param args
     */
    public static void main(String[] args) {

	System.out.println(product(-5, -3));
    }

    private static int product(int a, int b) {

	if (b == -1) {
	    return -(a);
	}
	if (b == 1) {
	    return a;
	}
	if (b < 0) {
	    return product(a, ++b) - a;
	} else {
	    return product(a, --b) + a;
	}
    }

}
