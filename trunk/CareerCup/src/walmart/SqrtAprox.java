package walmart;

/*
 * http://www.sosmath.com/calculus/diff/der07/der07.html
 * http://stackoverflow.com/questions/8971659/explanation-of-newtons-method-example-on-java
 */
public class SqrtAprox {

	public static void main(String[] args) {

		System.out.println(sqroot(2));
		System.out.println(sqrt(2));
	}

	public static double sqrt(double c) {

		double epsilon = 0.000000001;// 1e-15; // relative error tolerance
		double t = c; // estimate of the square root of c

		// repeatedly apply Newton update step until desired precision is
		// achieved
		while (Math.abs(t - c / t) > epsilon) {// *t) {
			t = (c / t + t) / 2.0;
		}

		// print out the estimate of the square root of c
		return t;
	}

	public static double sqroot(double x) {

		double fa = x / 2;
		double sa = x / fa;
		double ta = (fa + sa) / 2.0;
		while (Math.abs(x - Math.pow(ta, 2)) > 0.000000001) {
			fa = ta;
			sa = x / fa;
			ta = (fa + sa) / 2;
		}
		return ta;
	}
}
