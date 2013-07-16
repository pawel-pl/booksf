package directi;

public class FindTripletSumInRange12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// double[] arr = { 1.9, 0.2, 0.3, 0.4 };
		// double[] arr = { 1.9, 0.2, 0.5, 0.36 };
		// double[] arr = { 0.001, 0.002, 0.004, 1.0, 2.0, 0.3, 0.3, 0.5, 0.1,
		// 0.01, 0.01, 0.7, 1.0 };
		// double[] arr = { 0.5, 0.001, 0.002, 0.004, 1.0, 0.5 };
//		double[] arr = { 1.2, 0.01, 1.9, 1.2, 0.01 };
		 double[] arr = { 0.4, 0.01, 0.4, 0.01, 0.4, 0.01 };
		// double[] arr = { 0.6, 0.6, 0.6};
		findTriplet(arr);
	}

	public static boolean findTriplet(double[] arr) {

		double first = Float.MAX_VALUE;
		double sec = Float.MAX_VALUE;
		double third = Float.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 2) {
				continue;
			}
			System.out.println(arr[i]);
			if (arr[i] <= first) {
				third = sec;
				sec = first;
				first = arr[i];
			} else if (arr[i] <= sec) {
				third = sec;
				sec = arr[i];
			} else if (arr[i] <= third) {
				third = arr[i];
			}
			double res = first + sec + third;
			if (res > 1 && res < 2) {
				System.out.println("Found triplet: " + first + " + " + sec + " + " + third + " = " + res);
				return true;
			} else if (res < 1) {

			}
		}
		System.out.println("Triplet was not found");

		return false;
	}

}
