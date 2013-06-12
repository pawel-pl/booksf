package zynga;

public class TwoNumbersToDouble {

    /**
     * @param args
     */
    public static double numberAdd(int a, int b) {
	
	double A = (double) a;
	double B = (double) b;
	while (B >= 1) {
	    B = B / 10;
	}
	return A + B;

    }

    public static void main(String[] args) {

	int a = 10, b = 122252225;
	System.out.println(numberAdd(a, b));

    }

}
