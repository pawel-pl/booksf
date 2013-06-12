package thoughworks;

public class DevideWithoutDevideSigns {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	System.out.println(divide(3, 21));
    }

    public static int divide(int divisor, int dividend) {

	int quotient = 0;
	while (divisor <= dividend) {
	    dividend = dividend - divisor;
	    quotient++;
	}
	return quotient;
    }

}
